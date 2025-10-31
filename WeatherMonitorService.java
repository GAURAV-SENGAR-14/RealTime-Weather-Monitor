import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Real-Time Weather Monitoring System - Backend Service (Conceptual)
 * * This file demonstrates the use of Object-Oriented Programming (OOP) and
 * Concurrency (Multithreading) as required for the project documentation.
 * It simulates fetching data, processing it, and persisting it to a MySQL database.
 */

// --- OOP: Base Class (Inheritance) ---
abstract class WeatherSensor {
    protected String sensorType;
    protected String location;

    public WeatherSensor(String sensorType, String location) {
        this.sensorType = sensorType;
        this.location = location;
    }

    public abstract void processData();

    public String getStatus() {
        return "Sensor Type: " + sensorType + ", Location: " + location;
    }
}

// --- OOP: Child Class (Polymorphism) ---
class CityWeather extends WeatherSensor {
    private double temperature; // C
    private double humidity;    // %
    protected String condition;

    public CityWeather(String location, double temperature, double humidity, String condition) {
        super("OpenWeatherMapAPI", location);
        this.temperature = temperature;
        this.humidity = humidity;
        this.condition = condition;
    }

    // Polymorphic method
    @Override
    public void processData() {
        System.out.println("Processing data for " + location + ". Current temp: " + temperature);
        if (temperature > 35 || condition.contains("Thunderstorm")) {
            System.out.println("ALERT: Extreme condition detected at " + location + "!");
        }
    }

    public void updateData(double newTemp, double newHumidity, String newCondition) {
        this.temperature = newTemp;
        this.humidity = newHumidity;
        this.condition = newCondition;
        processData();
        persistToMySQL();
    }
    
    // Simulate data persistence function
    private void persistToMySQL() {
        System.out.println("-> [MySQL] Persisted current weather data for " + location + ".");
    }

    public double getTemperature() {
        return temperature;
    }
}

public class WeatherMonitorService {
    private final List<CityWeather> monitoredLocations = Collections.synchronizedList(new ArrayList<>());
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(5); 

    public WeatherMonitorService() {
        monitoredLocations.add(new CityWeather("Tokyo", 28.5, 65, "Partly Cloudy"));
        monitoredLocations.add(new CityWeather("London", 15.2, 88, "Rainy"));
        monitoredLocations.add(new CityWeather("New York", 22.0, 55, "Clear Sky"));
    }

    public void startMonitoring() {
        System.out.println("--- Starting Real-Time Weather Monitoring Service ---");
        System.out.println("Architecture: Client-Server (Java Backend/Dockerized)");
        scheduler.scheduleAtFixedRate(this::fetchRealTimeData, 0, 5, TimeUnit.MINUTES);
    }

    private void fetchRealTimeData() {
        System.out.println("\n--- Data Fetch Cycle Started: " + new java.util.Date() + " ---");
        for (CityWeather city : monitoredLocations) {
            scheduler.execute(() -> {
                try {
                    Thread.sleep((long) (Math.random() * 2000)); 
                    double newTemp = city.getTemperature() + (Math.random() * 2 - 1);
                    double newHumidity = city.getTemperature() + (Math.random() * 5 - 2);
                    city.updateData(newTemp, newHumidity, city.condition);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.err.println("API call interrupted for " + city.location);
                } catch (Exception e) {
                    System.err.println("CRITICAL ERROR: Failed to process data for " + city.location + ". Reconnecting...");
                }
            });
        }
        System.out.println("-> All concurrent API calls launched for " + monitoredLocations.size() + " locations.");
    }

    public static void main(String[] args) {
        WeatherMonitorService service = new WeatherMonitorService();
        service.startMonitoring();
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
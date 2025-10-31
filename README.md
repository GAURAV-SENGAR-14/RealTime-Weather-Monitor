# Real-Time Weather Monitoring System (OOTS Using JAVA)

This project implements a conceptual **Real-Time Weather Monitoring System**, designed as a client-server application demonstrating core **Object-Oriented Programming (OOP)** principles, **concurrency via Multithreading**, and **scalable data persistence**.

The system is built based on the requirements for a university project *(BCSE0352/BMICSE0352)*, leveraging **Java** for backend logic and **HTML/CSS/JavaScript** for the client-side visualization.

---

## 🚀 Key Technologies

- **Backend Logic:** Java (Conceptual OOTS implementation)
- **Concurrency:** Multithreading (Simulated concurrent data fetching)
- **Data Persistence:** MySQL (Conceptual)
- **Deployment:** Docker (Conceptual)
- **Frontend Client:** HTML5, Tailwind CSS (via CDN), JavaScript

---

## ✨ Project Features

- **Real-Time Monitoring:** Continuous data visualization for multiple configured locations.
- **Concurrent Fetching:** Backend conceptual code uses multithreading to simulate concurrent API calls (e.g., fetching data for multiple cities simultaneously).
- **Object-Oriented Design (OOD):** Implements classes (*WeatherSensor*, *CityWeather*) demonstrating **Inheritance** and **Polymorphism** for modular and scalable architecture.
- **Dynamic City Search:** Allows users to add new locations to the real-time monitoring list on the client side.
- **Alert System:** Provides non-blocking notifications for predefined weather conditions (e.g., Heat/Cold/Humidity warnings).
- **Detailed Metrics:** Displays Temperature, Humidity, Wind Speed, Pressure, and Cloudiness.

---

## 📁 Repository Structure

```
.
├── src/main/java/com/weatherapp/
│   └── WeatherMonitorService.java  # Conceptual Java Backend Service
├── index.html                      # Complete Frontend Web Client (HTML/CSS/JS)
└── README.md                       # Project Documentation
```

---

## 🛠 Setup and Running the Application

### 1. Frontend (Client) Setup

The `index.html` file is a standalone web application.

1. Clone this repository or download the files.
2. Open **index.html** directly in any modern web browser.
3. The frontend will start running immediately, simulating concurrent data fetching and UI updates using JavaScript timers.

### 2. Backend (Conceptual Java) Overview

The `WeatherMonitorService.java` file contains the conceptual server-side logic:

- **OOD Implementation:** Defines the class structure for weather data.
- **fetchRealTimeData():** Simulates the core function where multithreading would be used to connect to the OpenWeatherMap API and update the MySQL database.

This file demonstrates the required **Java and OOP components** of the project.  
Actual integration would require setting up a Java server (e.g., **Spring Boot**) and a **MySQL instance**.

---

## 📌 Compliance and Scalability

The architecture is designed to meet requirements for:
- **Low latency**
- **High reliability**
- **Scalability**

Ensuring the system can easily support integrating **five or more data streams** without performance degradation.

---



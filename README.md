---

# 🧠 Event Management System - Microservices Architecture

A powerful **Spring Boot-based microservices application** for seamless **event management**.
📅 Organizers can create events, manage registrations, and monitor participation.
👥 Users can browse and join upcoming events.

> Ideal for managing **seminars**, **workshops**, **conferences**, and more.

---

## 📁 Project Structure

| Service                | Description                                    |
| ---------------------- | ---------------------------------------------- |
| `api-gateway`          | Routes requests to backend services.           |
| `eureka-server`        | Service registry using Spring Cloud Eureka.    |
| `event-service`        | Manages event creation and updates.            |
| `registration-service` | Handles event registrations.                   |
| `user-service`         | Manages users and authentication.              |
| `transactions`         | (Optional) Manages payment-related operations. |
| `logs`                 | Centralized logging service (if used).         |

---

## ⚙️ Technologies Used

* **Java + Spring Boot**
* **Spring Cloud (Eureka, Gateway)**
* **Spring Data JPA**
* **MySQL**
* **Lombok**
* **Maven**

---

## 🚀 Features

* 🔐 User authentication and role-based access
* 📋 Event creation and management
* ✅ Event registration and validation
* 📊 Participation tracking
* 📡 Centralized routing via API Gateway
* 🔄 Service discovery via Eureka

---

## 🛠️ Setup Instructions

1. **Clone the Repository**

   ```bash
   git clone https://github.com/yourusername/event-management-system.git
   cd event-management-system
   ```

2. **Set Up MySQL**

   * Create databases for each service (`user_db`, `event_db`, etc.)
   * Update `application.properties` or `application.yml` for each service with your MySQL credentials:

     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/user_db
     spring.datasource.username=root
     spring.datasource.password=your_password
     spring.jpa.hibernate.ddl-auto=update
     ```

3. **Run Eureka Server**

   ```bash
   cd eureka-server
   mvn spring-boot:run
   ```

4. **Start Other Services One by One**

   ```bash
   cd api-gateway && mvn spring-boot:run
   cd user-service && mvn spring-boot:run
   cd event-service && mvn spring-boot:run
   cd registration-service && mvn spring-boot:run
   cd transactions && mvn spring-boot:run  # optional
   ```

5. **Access Services**

   * **Eureka Dashboard:** `http://localhost:8761`
   * **API Gateway:** `http://localhost:8080`

---

## 🖼️ Screenshots

> Add screenshots of the UI here to showcase features like event creation, registration, dashboards, etc.

| Feature           | Screenshot                                         |
| ----------------- | -------------------------------------------------- |
| Home Page         | ![image](https://github.com/user-attachments/assets/f68e3700-4949-45ae-b2db-0c8c8f775b77)|
| User Dashboard    | ![image](https://github.com/user-attachments/assets/750b3228-2460-4443-ab0a-320596603789)|
| Create Event Page | ![image](https://github.com/user-attachments/assets/01a7918f-5534-4188-a2e3-00065dd17983)|
| Admin Dashboard   | ![image](https://github.com/user-attachments/assets/e495c472-9569-4800-a8f1-1027f7b71d3a)|
| Events Panel      | ![image](https://github.com/user-attachments/assets/71a787f4-3906-4bf6-840f-b83eb75592bc)|
| Event Preview     | ![image](https://github.com/user-attachments/assets/997e4913-85e3-4673-9eb2-68165e2bbf86)|

---

## 🧪 Testing

Use tools like:

* **Postman** to test endpoints
* **JUnit** + **Mockito** for unit tests

---

## ✅ To Do / Future Improvements

* 📧 Email notifications for registrations
* 📈 Admin dashboard with statistics
* 🧾 Reports export (CSV/PDF)

---

## 📜 License

This project is licensed under the [MIT License](LICENSE).

---

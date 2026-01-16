# 🚀 Microservices Architecture Project

This project demonstrates a **Spring Boot Microservices architecture** using:

- Eureka Service Discovery  
- Spring Cloud Config Server  
- OpenFeign (Inter-service communication)  
- Distributed tracing with Zipkin  
- REST APIs  

---

## 🧩 Services Included

| Service | Description |
|-----------|--------------|
| config_service | Central configuration server |
| eureka_service | Service registry (Eureka Server) |
| order_service | Handles order operations |
| payment_service | Handles payment processing |
| product_service | Manages product data |
| search_service | Search operations |

---

## 🛠 Tech Stack

- Java 21  
- Spring Boot  
- Spring Cloud  
- Eureka Server  
- Config Server  
- OpenFeign  
- MySQL / H2  
- Zipkin  
- Maven  

---

## 🏗 Architecture

Client
|
v
Order Service ---> Payment Service
|
---> Product Service

(All services registered in Eureka)
(All configs from Config Server)


---

## 🔗 Service Communication

- Services communicate using **Feign Client**
- Example:
  - Order Service → Payment Service
  - Order Service → Product Service

---

## 🔍 Distributed Tracing

- Zipkin is used for tracing requests
- Shows:
  - Parent span (Order Service)
  - Child span (Payment Service)

---

## ⚙ Configuration Server

- Centralized configuration using Spring Cloud Config
- Profiles supported:
  - dev
  - prod

---

## ▶ How to Run

### Step 1: Start Config Server

### Step 2: Start Eureka Server

### Step 3: Start Microservices

---

## 🌐 Access URLs

| Service | URL |
|-----------|--------------------------|
| Eureka Dashboard | http://localhost:8761 |
| Zipkin UI | http://localhost:9411 |
| Order API | http://localhost:8081 |
| Payment API | http://localhost:8083 |

---

## 🔄 Sample Flow

1. Client calls  

---

## 🌐 Access URLs

| Service | URL |
|-----------|--------------------------|
| Eureka Dashboard | http://localhost:8761 |
| Zipkin UI | http://localhost:9411 |
| Order API | http://localhost:8081 |
| Payment API | http://localhost:8083 |

---

## 🔄 Sample Flow

1. Client calls  

2. Order Service saves order  
3. Calls Payment Service using Feign  
4. Payment processed  
5. Response returned to client  

---

## 📌 Features

✔ Service Discovery  
✔ Centralized Configuration  
✔ Feign Client communication  
✔ Distributed tracing  
✔ RESTful APIs  
✔ Load balancing  

---

## 📂 Project Structure

Microservices/
├── config_service
├── eureka_service
├── order_service
├── payment_service
├── product_service
├── search_service


---

## 👨‍💻 Author

**Deepghosh-123**

---

## ⭐ Support

If you like this project  
please give a ⭐ on GitHub 😊

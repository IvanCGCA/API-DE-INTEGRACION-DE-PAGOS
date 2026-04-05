# 💳 Payment Integration API (Event-Driven)

## 📝 Project Overview
The **Payment Integration API** is a full-stack, event-driven application designed to simulate and manage payment gateway transactions (similar to services like Stripe). It leverages a robust Spring Boot backend to process transactions, while utilizing Apache Kafka for asynchronous message brokering, ensuring high availability and scalable data flow.

## 🛠️ Tech Stack & Architecture

**Frontend (Client)**
* **Framework:** React.js
* **Styling:** HTML5, CSS3

**Backend (Server)**
* **Language/Framework:** Java, Spring Boot
* **Build Tool:** Maven
* **Architecture:** RESTful API

**Message Broker**
* **Service:** Apache Kafka (Local instance with Zookeeper)

**Database**
* **Engine:** SQLite (Designed with adaptability for migration to robust relational databases like PostgreSQL or MySQL)

## 🚀 Getting Started (Local Development)

### Prerequisites
Make sure you have the following installed:
* [Java Development Kit (JDK)](https://adoptium.net/) (11 or higher)
* [Apache Maven](https://maven.apache.org/)
* [Node.js](https://nodejs.org/)
* [Apache Kafka](https://kafka.apache.org/downloads) (Windows environment configured)

---

### 1. 🐘 Starting Apache Kafka (Windows)
Open a terminal and navigate to your Kafka binary folder (e.g., `C:\Kafka\kafka_2.13-3.3.2\bin\windows`).

**Start Zookeeper:**
```cmd
zookeeper-server-start.bat ..\..\config\zookeeper.properties
```

Leave this terminal open.

Start Kafka Server:

Open a new terminal in the same directory:

```cmd
kafka-server-start.bat ..\..\config\server.properties
```

Leave this terminal open.

2. ☕ Setting up the Backend (Spring Boot)
Open a terminal in the backend project directory:

```Bash
# Update dependencies and clean the project
mvn clean install

# Run the Spring Boot application
mvn spring-boot:run
```

(Alternatively, you can import the pom.xml into your favorite IDE like Eclipse or IntelliJ and run it as a Java Application).

3. ⚛️ Setting up the Frontend (React)
Open a terminal in the frontend project directory:

```Bash
# Install dependencies
npm install

# Start the development server
npm start
```

4. 🗄️ Database Access (SQLite)
To query the database manually, open a terminal in your SQLite installation directory:

```DOS
sqlite3 C:\path\to\your\project\IntegracionPagos\db\pagos.db
```

📡 Kafka Topic Monitoring

To verify that payment events are being published correctly, open a terminal in the Kafka bin/windows directory and run the consumer:

```DOS
kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic test_topic --from-beginning
```

📸 Functionality Overview & Screenshots

Create Payment:

![image](https://github.com/user-attachments/assets/ae221c81-a92f-4c3e-bcc7-67ff060195b6)


View All Payments:

![image](https://github.com/user-attachments/assets/16c0a042-e5c7-4528-a649-6f10a808e3fe)



Query Specific Payment:

![image](https://github.com/user-attachments/assets/08f33a91-00de-4b3f-95d0-5ee29057c30c)


Delete Payment:

![image](https://github.com/user-attachments/assets/6dd4cb82-2668-4fd8-a735-3c47ac44c215)


Kafka Event Logs:

![image](https://github.com/user-attachments/assets/0d88eb4f-bc2b-4c99-a25e-ac4cdef4eefc)



Linkedin: www.linkedin.com/in/ivan-vega-porras


Developed by Iván Vega Porras


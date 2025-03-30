![img_1.png](img_1.png)
# Web Application for Guspred


## 🌐 Web Page
- **Application URL:** [Guspred](https://guspred.com/)
- **Our Website:** [CodePred](https://codepred.pl/)

📧 **Contact Us:** [kontakt@codepred.pl](mailto:kontakt@codepred.pl)

---

## 🚀 Installation Guide

### ✅ Requirements
To build and run the application, ensure you have the following installed:

- [JDK 21](https://www.oracle.com/pl/java/technologies/downloads/)
- [Maven 3](https://maven.apache.org)

### 🔑 API Key Setup
To use the application, you need to obtain your own GUS API Key. You can generate one here:

🔗 [GUS API Registration](https://api.stat.gov.pl/Home/RegonApi)

Once obtained, set the API key in your application secrets:
```env
GUSPRED_KEY=<your_api_key>
```

---

## ▶️ Running the Application

### Locally
To start the application locally, run:
```sh
mvn spring-boot:run
```

### In a Docker Container
To deploy using Docker, execute:
```sh
docker compose up -d --build
```

### 🗄️ H2 Database Console
Access the embedded H2 database at:
[http://localhost:8080/h2-console](http://localhost:8080/h2-console)

---

## 📜 Copyright
❌ **No copyright allowed.**
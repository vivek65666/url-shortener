# 🚀 Full-Stack URL Shortener

A scalable full-stack URL Shortener application built using **Java 21**, **Spring Boot**, **Spring Data JPA**, **MySQL**, and a responsive **HTML, CSS, JavaScript** frontend. The application enables users to generate short URLs, automatically redirect to the original URLs, and track click analytics in real time.

---

## 📸 Project Preview

### Landing Page
![Landing Page](Screenhots/url-shortener%20land%20page.png)

### Website View
![Website View](Screenhots/url-shortener%20website.png)

### Shortened URL Generation
![Shortened URL](Screenhots/url-shortener%20website%20link.png)

### MySQL Database
![Database](Screenhots/url-shortener%20db%20mapping.png)

---

# 🏗️ System Architecture

Frontend (HTML/CSS/JavaScript)
│
▼
Spring Boot REST API
│
▼
Spring Data JPA (Hibernate)
│
▼
MySQL Database


---

# 🛠 Tech Stack

### Backend
- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate
- REST APIs

### Frontend
- HTML5
- CSS3
- JavaScript (Fetch API)

### Database
- MySQL

### Tools
- Git
- GitHub
- Maven
- Postman

---

# ✨ Features

- Generate unique short URLs instantly
- Automatic redirection using generated short codes
- Real-time click tracking and analytics
- Persistent URL storage using MySQL
- Responsive frontend interface
- RESTful API architecture
- Layered backend architecture
- CORS enabled for frontend-backend communication

---

# 📂 Project Structure

src
├── controller
├── service
├── repository
├── entity
├── dto
└── config


---

# 📌 REST API Endpoints

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | `/shorten` | Generate a short URL |
| GET | `/{shortCode}` | Redirect to original URL |
| GET | `/analytics/{shortCode}` | Retrieve click analytics |

---

# 🗄 Database

MySQL stores:

- Original URL
- Short Code
- Click Count
- Created Timestamp

The application uses **Spring Data JPA** for object-relational mapping.

---

# ▶️ Getting Started

### Clone Repository

```bash
git clone [https://github.com/vivek65666/url-shortener.git](https://github.com/vivek65666/url-shortener.git)
Navigate
Bash
cd url-shortener
Configure Database
Update:

src/main/resources/application.yaml
with your MySQL credentials.

Run
Bash
mvn spring-boot:run
Application runs at

http://localhost:8081/index.html
🧪 Testing
REST APIs were tested using Postman.

Example request:

POST /shorten
Request Body

JSON
{
  "url": "[https://www.amazon.com](https://www.amazon.com)"
}
Response

JSON
{
  "shortUrl": "http://localhost:8081/abc123"
}
🚀 Future Enhancements
User Authentication (JWT)

Custom Short URLs

QR Code Generation

URL Expiration

Dashboard for Analytics

Docker Deployment

Redis Caching

Rate Limiting

👨‍💻 Author
Vivek C Raj

GitHub: https://github.com/vivek65666

LinkedIn: https://linkedin.com/in/vivek-c-raj

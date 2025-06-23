# 🛒 ProductList API

A secure product and category management REST API built with Spring Boot, secured via Keycloak (OAuth2/JWT), and integrated with MySQL.


## 🚀 Features

- ✅ **User registration** and **login** with JWT tokens  
- 🔐 **Role-based access** using Keycloak (roles: `ADMIN`, `SELLER`)  
- 📝 CRUD for **Products** and **Categories**  
- 🔒 BCrypt password hashing  
- 🗄️ MySQL database persistence  
- 🔑 JWT authentication via Keycloak


## 📦 Tech Stack

- Java 17+  
- Spring Boot (3.x)  
- Spring Security  
- Spring Data JPA  
- Keycloak (OAuth2 / JWT)  
- MySQL  
- Maven

---

## 🧩 Project Structure


src/
├── controller – REST API endpoints
├── dto – Request/response DTOs
├── entity – JPA entities (User, Product, Category)
├── repository – Spring Data JPA repositories
├── service – Business logic layer
└── security – JWT & Keycloak security configuration



---

## 🔧 Prerequisites

- JDK 17 or newer  
- Maven  
- MySQL  
- Keycloak (tested with 26.x)

---

⚙️ API Endpoints

Public (no auth)
Method	Endpoint	Description
POST	/user/register	Register a new user
POST	/user/login	Login to get JWT
GET	/api/products, /api/categories	Browse products/categories

Protected (Bearer token required)
Method	Endpoint	Roles Allowed
POST	/api/products	SELLER, ADMIN
PUT	/api/products/{id}	SELLER, ADMIN
DELETE	/api/products/{id}	SELLER, ADMIN
POST	/api/categories	ADMIN
GET	/api/categories/{id}	Authorized users
DELETE	/api/categories/{id}	ADMIN

🔒 Security Notes

Uses JWT tokens issued by Keycloak
Spring Security is set up to parse realm_access.roles from tokens
The KeyCloakRoleReader extracts roles and prefixes them with ROLE_
Tokens are validated on each request


Postman / Swagger

Import your Postman collection or visit:
http://localhost:8080/swagger-ui.html
(Enable Swagger via springdoc-openapi dependency if needed.)


🧪 Testing Flow Summary

Register and login user (get JWT)
Send JWT in Authorization header
Access protected endpoints based on user role


🛠 Troubleshooting

❗ Invalid signature: Ensure secret used matches Keycloak’s signing key
🐞 403 Forbidden: Check assigned roles vs. endpoint roles
🧪 MySQL errors: Recheck DB credentials in application.properties


🤝 Contributing

Fork the repo
Create a feature branch
Submit PRs or issues
Ensure naming conventions and commit linting

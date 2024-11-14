# Message Board Application

A Spring Boot based message board system that allows users to post and manage messages.

[中文文档](README_CN.md)

## Screenshots

### Frontend Interface
![Frontend Interface](docs/images/frontend.png)

### Admin Dashboard
![Admin Dashboard](docs/images/admin.png)

## Features

- User message posting
- Admin message management
- Message filtering and moderation
- RESTful API support
- Spring Security integration

## Technical Stack

- Java 17
- Spring Boot 3.x
- Spring Data JPA
- Spring Security
- MySQL/PostgreSQL
- Maven
- Docker

## Quick Start

### Option 1: Using Docker (Recommended)
```bash
# This will start all required containers
docker-compose up --build
```

### Option 2: Manual Deployment (Without Docker)
Requirements:
- JDK 17+
- Maven 3.8+
- MySQL 8.0+ (running locally)

Steps:
1. Configure MySQL database locally
2. Update application.properties with local database settings
3. Build the application:
```bash
mvn clean package
```
4. Run the JAR file:
```bash
java -jar target/message-board-1.0.0.jar
```

Note: Option 2 requires manual setup of MySQL and does not use containers.

## 📚 Usage Guide

### Regular Users
- Post messages
- Reply to messages
- Like messages
- Switch themes

### Administrators
- View statistics
- Manage messages
- Bulk delete
- Reply to messages

## 🔧 Configuration

### Environment Variables
```properties
# Database
SPRING_DATASOURCE_URL=jdbc:mysql://db:3306/message_board
SPRING_DATASOURCE_USERNAME=root
SPRING_DATASOURCE_PASSWORD=123456

# Port
SERVER_PORT=8081
```

### Data Storage
Using Docker volume:
```yaml
volumes:
  mysql_data:
```

## 🛡️ Security Notes

1. Change default passwords
2. Backup data
3. Use HTTPS
4. Restrict database access

## 🤝 Contributing

1. Fork the project
2. Create your feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request

## 📝 Changelog

### v1.0.0 (2024-01-14)
- 🎉 Initial release
- Basic features
- Admin dashboard
- Docker support
- Theme switching
- Demo data

## 📄 License

[MIT License](LICENSE)

## 🙏 Acknowledgments

- Spring Boot
- MySQL
- Docker
- Bootstrap
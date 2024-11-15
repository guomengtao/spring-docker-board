# Spring Boot Message Board

A message board system based on Spring Boot with Docker deployment and HTTPS support.

[中文文档](README_CN.md)

## Screenshots

### Frontend Interface
![Frontend](docs/images/frontend.png)

### Admin Dashboard
![Admin](docs/images/admin.png)

## Features
- Message posting and management
- Admin dashboard with moderation tools
- RESTful API support
- Spring Security integration
- HTTPS support with auto-renewed SSL certificates
- Nginx reverse proxy for production
- Dual access methods (IP and Domain)
- Containerized deployment with Docker

## Tech Stack
- Java 17
- Spring Boot 3.x
- Spring Data JPA
- Spring Security
- MySQL 8.0
- Maven
- Docker & Docker Compose
- Nginx
- Let's Encrypt SSL

## Quick Start

### Prerequisites
- Docker and Docker Compose
- Nginx
- Domain name (optional, for HTTPS)
- Oracle Cloud instance

### Access Methods

1. Direct IP Access:
   - URL: http://132.226.114.176:8081
   - Features:
     * Simple and direct access
     * No SSL certificate required
     * Port 8081 must be open in Oracle Cloud
     * Suitable for development/testing

2. Domain Access:
   - URL: https://board.1panel.rinuo.com
   - Features:
     * Automatic HTTP to HTTPS redirection
     * Secure SSL connection
     * Standard ports (80/443)
     * Recommended for production

### Installation

1. Clone repository:
```bash
git clone git@github.com:guomengtao/spring-docker-board.git
cd spring-docker-board
```

2. Configure environment:
```bash
cp .env.example .env
# Edit .env file with your settings:
# SERVER_IP=132.226.114.176
# PROJECT_PORT=8081
# PROJECT_DOMAIN=board.1panel.rinuo.com (optional)
# PROJECT_EMAIL=your@email.com (optional)
```

3. Launch application:
```bash
# For IP access only:
docker-compose up -d

# For domain access with HTTPS:
./deploy-nginx.sh
```

## Development

### Building from source
```bash
mvn clean package
```

### Running tests
```bash
mvn test
```

## Deployment

### Docker Compose Services
- Spring Boot application
- MySQL database
- Nginx reverse proxy

### Data Persistence
- MySQL data volume
- Application logs
- SSL certificates

### Security Notes
- HTTPS encryption (domain access)
- Spring Security integration
- Database password encryption
- Regular security updates

## Contributing
1. Fork the repository
2. Create your feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request

## License
MIT

## Acknowledgments
- Spring Boot
- Docker
- Nginx
- Let's Encrypt

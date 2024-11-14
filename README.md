# Message Board Application

[... previous content ...]

## Access Methods

### Dual Access Support
1. Direct IP Access
   - http://132.226.114.176:8081
   - Simple and direct access
   - No SSL certificate required
   - Requires port 8081 to be opened in Oracle Cloud

2. Domain Access (with HTTPS)
   - https://board.1panel.rinuo.com
   - Automatic HTTP to HTTPS redirection
   - Secure connection with SSL
   - Uses standard ports (80/443) only

### Port Configuration in Oracle Cloud

1. For IP Direct Access (8081)
   - Open Oracle Cloud Console
   - Navigate to Networking > Virtual Cloud Networks > Security Lists
   - Add Ingress Rule:
     ```
     Port Range: 8081
     Source CIDR: 0.0.0.0/0
     Description: Spring Boot Application Port
     ```

2. For Domain Access (80/443)
   - Standard HTTP/HTTPS ports (usually already open)
   - No need to expose 8081 (handled by Nginx reverse proxy)
   - If needed, ensure ports 80 and 443 are open

### Configuration
[... rest of the content ...]

# Spring Boot 留言板

基于 Spring Boot 的留言板系统，支持 Docker 部署和 HTTPS 配置。

[English](README.md)

## 截图演示

### 前端界面
![前端界面](docs/images/frontend.png)

### 管理后台
![管理后台](docs/images/admin.png)

## 功能特点
- 用户留言发布和管理
- 管理员后台和审核工具
- RESTful API 支持
- Spring Security 集成
- HTTPS 支持并自动更新 SSL 证书
- Nginx 反向代理生产环境部署
- 双重访问方式（IP和域名）
- Docker 容器化部署

## 技术栈
- Java 17
- Spring Boot 3.x
- Spring Data JPA
- Spring Security
- MySQL 8.0
- Maven
- Docker & Docker Compose
- Nginx
- Let's Encrypt SSL

## 快速开始

### 前置要求
- Docker 和 Docker Compose
- Nginx
- 域名（可选，用于 HTTPS）
- Oracle Cloud 实例

### 访问方式

1. IP 直接访问:
   - 地址: http://132.226.114.176:8081
   - 特点:
     * 简单直接的访问方式
     * 无需 SSL 证书
     * 需要在 Oracle Cloud 中开放 8081 端口
     * 适合开发和测试环境

2. 域名访问:
   - 地址: https://board.1panel.rinuo.com
   - 特点:
     * 自动从 HTTP 跳转到 HTTPS
     * SSL 安全连接
     * 使用标准端口（80/443）
     * 推荐用于生产环境

### 安装步骤

1. 克隆仓库:
```bash
git clone git@github.com:guomengtao/spring-docker-board.git
cd spring-docker-board
```

2. 配置环境:
```bash
cp .env.example .env
# 编辑 .env 文件:
# SERVER_IP=132.226.114.176
# PROJECT_PORT=8081
# PROJECT_DOMAIN=board.1panel.rinuo.com (可选)
# PROJECT_EMAIL=your@email.com (可选)
```

3. 启动应用:
```bash
# 仅 IP 访问:
docker-compose up -d

# 域名访问:
./deploy-nginx.sh
```

## 开发

### 从源码构建
```bash
mvn clean package
```

### 运行测试
```bash
mvn test
```

## 部署

### Docker Compose 服务
- Spring Boot 应用
- MySQL 数据库
- Nginx 反向代理

### 数据持久化
- MySQL 数据卷
- 应用日志
- SSL 证书

### 安全说明
- HTTPS 加密（域名访问）
- Spring Security 集成
- 数据库密码加密
- 定期安全更新

## 贡献指南
1. Fork 本仓库
2. 创建特性分支
3. 提交更改
4. 推送到分支
5. 创建 Pull Request

## 许可证
MIT

## 致谢
- Spring Boot
- Docker
- Nginx
- Let's Encrypt

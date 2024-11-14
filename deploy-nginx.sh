#!/bin/bash

# 加载环境变量
source .env

# 使用环境变量替换nginx配置
envsubst '${SERVER_IP} ${PROJECT_PORT} ${PROJECT_DOMAIN}' < nginx/board.conf.example > /tmp/board.conf

# 复制配置文件到nginx目录
sudo cp /tmp/board.conf /etc/nginx/conf.d/${PROJECT_DOMAIN}.conf

# 如果设置了域名，则申请SSL证书
if [ ! -z "$PROJECT_DOMAIN" ]; then
    sudo certbot --nginx -d ${PROJECT_DOMAIN} --email ${PROJECT_EMAIL} --agree-tos --non-interactive
fi

# 测试nginx配置
sudo nginx -t

# 重新加载nginx
sudo nginx -s reload

# 清理临时文件
rm /tmp/board.conf

echo "部署完成！"
echo "IP访问: http://${SERVER_IP}:${PROJECT_PORT}"
if [ ! -z "$PROJECT_DOMAIN" ]; then
    echo "域名访问: https://${PROJECT_DOMAIN}"
fi

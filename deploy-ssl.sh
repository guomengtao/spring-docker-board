#!/bin/bash

# 加载环境变量
set -a
source .env
set +a

# 检查必要的环境变量
if [ -z "$PROJECT_DOMAIN" ] || [ -z "$PROJECT_PORT" ] || [ -z "$PROJECT_EMAIL" ]; then
    echo "错误：请在 .env 文件中设置所有必要的环境变量"
    echo "PROJECT_DOMAIN: 域名（必填）"
    echo "PROJECT_PORT: 端口（必填）"
    echo "PROJECT_EMAIL: 邮箱（必填，用于证书通知）"
    exit 1
fi

# 检查证书是否已存在
CERT_PATH="/etc/letsencrypt/live/${PROJECT_DOMAIN}/fullchain.pem"
if [ -f "$CERT_PATH" ]; then
    echo "使用现有的 SSL 证书配置..."
    TEMPLATE="full_template.conf"
else
    echo "准备申请新的 SSL 证书..."
    TEMPLATE="basic_template.conf"
fi

# 应用配置
sudo -E bash -c "envsubst '\$PROJECT_DOMAIN \$PROJECT_PORT' < $TEMPLATE > /etc/nginx/conf.d/${PROJECT_DOMAIN}.conf"

# 重启 Nginx
sudo systemctl restart nginx

# 如果证书不存在，自动申请
if [ ! -f "$CERT_PATH" ]; then
    echo "正在申请 SSL 证书..."
    sudo certbot --nginx -d ${PROJECT_DOMAIN} --non-interactive --agree-tos --email ${PROJECT_EMAIL}
    
    if [ $? -eq 0 ]; then
        echo "SSL 证书申请成功！"
        sudo -E bash -c "envsubst '\$PROJECT_DOMAIN \$PROJECT_PORT' < full_template.conf > /etc/nginx/conf.d/${PROJECT_DOMAIN}.conf"
        sudo systemctl restart nginx
    else
        echo "SSL 证书申请失败，请检查配置和网络连接"
        exit 1
    fi
fi

echo "部署完成！"
echo "您可以通过以下地址访问："
echo "HTTP: http://${PROJECT_DOMAIN}"
echo "HTTPS: https://${PROJECT_DOMAIN}"

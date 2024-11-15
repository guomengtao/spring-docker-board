#!/bin/bash

# 使用 sed 替换 clearMessages 函数
sed -i '/function clearMessages/,/}/c\
function clearMessages() {\
    if (confirm('\''确定要清空所有留言吗？'\'')) {\
        fetch('\''/api/messages/clear'\'', {\
            method: '\''POST'\'',\
            headers: {\
                '\''Content-Type'\'': '\''application/json'\''\
            }\
        })\
        .then(response => {\
            if (response.ok) {\
                alert('\''所有留言已清空'\'');\
                location.reload();\
            } else {\
                console.error('\''清空失败:'\'', response.status);\
                alert('\''清空失败'\'');\
            }\
        })\
        .catch(error => {\
            console.error('\''Error:'\'', error);\
            alert('\''清空失败'\'');\
        });\
    }\
}' src/main/resources/static/js/admin.js

echo "函数更新完成"

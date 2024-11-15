#!/bin/bash

# 更新 admin.js 文件
cat > src/main/resources/static/js/admin.js << 'END'
// ... 其他代码保持不变 ...

function clearMessages() {
    if (confirm('确定要清空所有留言吗？')) {
        fetch('/api/messages/clear', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            }
        })
        .then(response => {
            if (response.ok) {
                alert('所有留言已清空');
                location.reload();
            } else {
                console.error('清空失败:', response.status);
                alert('清空失败');
            }
        })
        .catch(error => {
            console.error('Error:', error);
            alert('清空失败');
        });
    }
}

// ... 其他代码保持不变 ...
END

echo "前端代码已更新"

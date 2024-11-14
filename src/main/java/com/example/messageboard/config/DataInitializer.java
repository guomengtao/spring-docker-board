package com.example.messageboard.config;

import com.example.messageboard.entity.Message;
import com.example.messageboard.repository.MessageRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initData(MessageRepository messageRepository) {
        return args -> {
            // 只在数据库为空时初始化数据
            if (messageRepository.count() == 0) {
                // 问题1：如何使用留言板？
                Message q1 = new Message();
                q1.setContent("请问如何使用这个留言板系统？");
                q1.setCreatedAt(LocalDateTime.now());
                q1.setLikes(5);
                messageRepository.save(q1);

                Message a1 = new Message();
                a1.setContent("欢迎使用留言板！使用非常简单：\n1. 在输入框中输入内容并点击发表\n2. 可以对留言进行回复和点赞\n3. 管理员可以通过/admin登录后台管理");
                a1.setCreatedAt(LocalDateTime.now().plusMinutes(1));
                a1.setParentId(q1.getId());
                a1.setLikes(3);
                messageRepository.save(a1);

                // 问题2：管理员功能
                Message q2 = new Message();
                q2.setContent("管理员账号和密码是什么？有哪些功能？");
                q2.setCreatedAt(LocalDateTime.now().plusMinutes(2));
                q2.setLikes(4);
                messageRepository.save(q2);

                Message a2 = new Message();
                a2.setContent("管理员登录信息：\n- 网址：/admin\n- 用户名：admin\n- 密码：admin123\n\n管理功能包括：\n1. 查看统计数据\n2. 管理所有留言\n3. 回复和删除留言");
                a2.setCreatedAt(LocalDateTime.now().plusMinutes(3));
                a2.setParentId(q2.getId());
                a2.setLikes(6);
                messageRepository.save(a2);

                // 问题3：主题切换
                Message q3 = new Message();
                q3.setContent("看到有几种主题风格，如何切换？");
                q3.setCreatedAt(LocalDateTime.now().plusMinutes(4));
                q3.setLikes(3);
                messageRepository.save(q3);

                Message a3 = new Message();
                a3.setContent("页面右上角有主题切换按钮，提供三种风格：\n1. 默认主题：清爽简约\n2. 护眼模式：绿色护眼\n3. 新年风格：喜庆红色\n\n主题会自动保存，下次访问时保持上次的选择。");
                a3.setCreatedAt(LocalDateTime.now().plusMinutes(5));
                a3.setParentId(q3.getId());
                a3.setLikes(4);
                messageRepository.save(a3);

                // 问题4：Docker部署
                Message q4 = new Message();
                q4.setContent("如何使用Docker部署这个项目？");
                q4.setCreatedAt(LocalDateTime.now().plusMinutes(6));
                q4.setLikes(7);
                messageRepository.save(q4);

                Message a4 = new Message();
                a4.setContent("Docker部署非常简单：\n1. 确保安装了Docker和Docker Compose\n2. 克隆项目后在根目录执行：docker-compose up --build\n3. 访问 http://localhost:8081\n\n所有环境都已配置好，一键启动即可使用！");
                a4.setCreatedAt(LocalDateTime.now().plusMinutes(7));
                a4.setParentId(q4.getId());
                a4.setLikes(8);
                messageRepository.save(a4);

                // 问题5：数据安全
                Message q5 = new Message();
                q5.setContent("留言数据会保存在哪里？安全吗？");
                q5.setCreatedAt(LocalDateTime.now().plusMinutes(8));
                q5.setLikes(6);
                messageRepository.save(q5);

                Message a5 = new Message();
                a5.setContent("关于数据安全：\n1. 所有数据存储在MySQL数据库中\n2. 使用Docker volume持久化，重启不会丢失\n3. 建议定期备份数据\n4. 请及时修改默认管理员密码\n\n如有其他问题，随时在留言板询问！");
                a5.setCreatedAt(LocalDateTime.now().plusMinutes(9));
                a5.setParentId(q5.getId());
                a5.setLikes(5);
                messageRepository.save(a5);
            }
        };
    }
} 
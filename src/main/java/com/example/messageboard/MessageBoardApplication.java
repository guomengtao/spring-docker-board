package com.example.messageboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * 留言板应用程序入口类
 */
@SpringBootApplication
@EntityScan("com.example.messageboard.entity")
@EnableJpaRepositories("com.example.messageboard.repository")
public class MessageBoardApplication {
    public static void main(String[] args) {
        SpringApplication.run(MessageBoardApplication.class, args);
    }
}
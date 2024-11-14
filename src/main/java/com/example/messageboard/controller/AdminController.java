package com.example.messageboard.controller;

import com.example.messageboard.service.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 管理员控制器
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    private final MessageService messageService;

    public AdminController(MessageService messageService) {
        this.messageService = messageService;
    }

    /**
     * 管理员页面
     */
    @GetMapping
    public String adminPage() {
        return "forward:/admin.html";
    }

    /**
     * 清空所有留言
     */
    @DeleteMapping("/messages")
    @ResponseBody
    public ResponseEntity<Void> deleteAllMessages() {
        try {
            messageService.deleteAll();
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
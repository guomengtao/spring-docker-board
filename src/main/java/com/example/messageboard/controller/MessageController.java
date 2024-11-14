package com.example.messageboard.controller;

import com.example.messageboard.dto.MessageDTO;
import com.example.messageboard.service.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 留言控制器
 */
@RestController
@RequestMapping("/api/messages")
public class MessageController {
    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    /**
     * 获取所有留言
     */
    @GetMapping
    public ResponseEntity<List<MessageDTO>> getAllMessages() {
        return ResponseEntity.ok(messageService.getAllMessages());
    }

    /**
     * 发表新留言
     */
    @PostMapping
    public ResponseEntity<MessageDTO> createMessage(@RequestBody MessageDTO messageDTO) {
        return ResponseEntity.ok(messageService.createMessage(messageDTO));
    }

    /**
     * 管理员回复留言
     */
    @PostMapping("/{id}/reply")
    public ResponseEntity<MessageDTO> replyToMessage(@PathVariable Long id, @RequestBody MessageDTO replyDTO) {
        return ResponseEntity.ok(messageService.replyToMessage(id, replyDTO));
    }

    /**
     * 删除留言
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable Long id) {
        messageService.deleteMessage(id);
        return ResponseEntity.ok().build();
    }

    /**
     * 点赞留言
     */
    @PostMapping("/{id}/like")
    public ResponseEntity<MessageDTO> likeMessage(@PathVariable Long id) {
        return ResponseEntity.ok(messageService.likeMessage(id));
    }
}
package com.example.messageboard.service;

import com.example.messageboard.dto.MessageDTO;
import com.example.messageboard.entity.Message;
import com.example.messageboard.repository.MessageRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService {
    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    /**
     * 创建新消息
     */
    @Transactional
    public MessageDTO createMessage(MessageDTO messageDTO) {
        Message message = new Message();
        message.setContent(messageDTO.getContent());
        message.setCreatedAt(LocalDateTime.now());
        message.setParentId(messageDTO.getParentId());
        
        Message savedMessage = messageRepository.save(message);
        
        MessageDTO result = new MessageDTO();
        BeanUtils.copyProperties(savedMessage, result);
        return result;
    }

    /**
     * 获取所有消息
     */
    public List<MessageDTO> getAllMessages() {
        return messageRepository.findAll().stream()
            .map(message -> {
                MessageDTO dto = new MessageDTO();
                BeanUtils.copyProperties(message, dto);
                return dto;
            })
            .collect(Collectors.toList());
    }

    @Transactional
    public MessageDTO replyToMessage(Long parentId, MessageDTO replyDTO) {
        Message parentMessage = messageRepository.findById(parentId)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Message not found"));

        Message reply = new Message();
        reply.setContent(replyDTO.getContent());
        reply.setCreatedAt(LocalDateTime.now());
        reply.setParentId(parentId);

        Message savedReply = messageRepository.save(reply);
        
        MessageDTO result = new MessageDTO();
        BeanUtils.copyProperties(savedReply, result);
        return result;
    }

    @Transactional
    public void deleteMessage(Long id) {
        messageRepository.deleteById(id);
    }

    @Transactional
    public void deleteAll() {
        messageRepository.deleteAll();
    }

    @Transactional
    public MessageDTO likeMessage(Long id) {
        Message message = messageRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Message not found"));
        
        message.setLikes(message.getLikes() + 1);
        Message savedMessage = messageRepository.save(message);
        
        MessageDTO result = new MessageDTO();
        BeanUtils.copyProperties(savedMessage, result);
        return result;
    }
}
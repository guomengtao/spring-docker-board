package com.example.messageboard.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.time.LocalDateTime;

/**
 * 消息传输对象
 */
@Data
public class MessageDTO {
    private Long id;           // 消息ID

    @NotBlank(message = "留言内容不能为空")
    @Size(min = 1, max = 500, message = "留言内容长度必须在1-500字之间")
    private String content;    // 消息内容

    private LocalDateTime createdAt;  // 创建时间
    private Long parentId;    // 父消息ID（用于回复功能）
    private Integer likes = 0;  // 添加点赞数字段

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }
} 
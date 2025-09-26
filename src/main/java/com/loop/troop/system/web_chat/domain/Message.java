package com.loop.troop.system.web_chat.domain;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record Message(
        UUID id,
        ChatId chatId,
        UUID senderId,
        String content,
        LocalDateTime sentAt,
        List<Attachment> attachments
) {
    public static Message create(ChatId chatId, UUID senderId, String content) {
        return new Message(UUID.randomUUID(), chatId, senderId, content, LocalDateTime.now(), List.of());
    }

    public static Message createWithAttachments(ChatId chatId, UUID senderId, String content, List<Attachment> attachments) {
        return new Message(UUID.randomUUID(), chatId, senderId, content, LocalDateTime.now(), attachments);
    }
}

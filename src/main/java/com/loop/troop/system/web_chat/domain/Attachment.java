package com.loop.troop.system.web_chat.domain;

import java.util.UUID;

public record Attachment(
        UUID id,
        String fileName,
        String fileType,   // e.g., "image/png", "application/pdf"
        long fileSize,     // in bytes
        String url         // stored location (S3, DB, etc.)
) {
    public static Attachment create(String fileName, String fileType, long fileSize, String url) {
        return new Attachment(UUID.randomUUID(), fileName, fileType, fileSize, url);
    }
}

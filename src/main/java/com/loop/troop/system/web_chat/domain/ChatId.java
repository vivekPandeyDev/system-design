package com.loop.troop.system.web_chat.domain;

import java.util.UUID;

public record ChatId(UUID id) {
    public static ChatId of(UUID id) {
        return new ChatId(id);
    }
    @Override
    public String toString() {
        return id.toString();
    }
}

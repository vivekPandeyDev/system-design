package com.loop.troop.system.web_chat.domain;

import java.util.UUID;

public record UserId(UUID id) {

    public static UserId of(UUID id) {
        return new UserId(id);
    }

    @Override
    public String toString() {
        return id.toString();
    }
}
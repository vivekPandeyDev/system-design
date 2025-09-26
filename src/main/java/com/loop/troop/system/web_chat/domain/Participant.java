package com.loop.troop.system.web_chat.domain;

import java.time.LocalDateTime;
import java.util.UUID;

public record Participant(
        UUID id,
        UUID userId,
        LocalDateTime joinedAt,
        Role role,
        Status status,
        LocalDateTime lastReadAt,
        boolean pinned,
        String nickname
) {
    public static Participant of(UUID id, UUID userId, LocalDateTime joinedAt, Role role) {
        return new Participant(id, userId, joinedAt, role, Status.ACTIVE, null, false, null);
    }
}

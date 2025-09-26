package com.loop.troop.system.web_chat.domain;

import java.util.UUID;

public interface ChatPersistence {
    void saveMessageWithAttachments(Message message); // combined method

    void saveParticipant(Participant participant, ChatId chatId);
    void removeParticipant(UUID participantId, ChatId chatId);
}

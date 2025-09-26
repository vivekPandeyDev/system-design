package com.loop.troop.system.web_chat.domain;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Log4j2
@RequiredArgsConstructor

public class ChatService {

    private final ChatPersistence persistence;

    /**
     * Send a message in any Chat
     */
    public void sendMessage(Chat chat, Message message) {
        chat.postMessage(message);  // domain handles business rules
        log.info("Message posted to chat {}", chat.id());

        persistence.saveMessageWithAttachments(message);  // persistence handled separately
    }

    /**
     * Add a participant (GroupChat only internally via Null Object)
     */
    public void addParticipant(Chat chat, Participant participant) {
        chat.participantManagement().addParticipant(participant);
        log.info("Attempted to add participant in chat {}", chat.id());

        persistence.saveParticipant(participant, chat.id());
    }

    /**
     * Remove a participant (GroupChat only internally via Null Object)
     */
    public void removeParticipant(Chat chat, Participant participant) {
        chat.participantManagement().removeParticipant(participant);
        log.info("Attempted to remove participant in chat {}", chat.id());

        persistence.removeParticipant(participant.id(), chat.id());
    }
}

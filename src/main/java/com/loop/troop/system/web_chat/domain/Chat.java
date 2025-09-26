package com.loop.troop.system.web_chat.domain;

import java.util.Set;

public interface Chat {
    ChatId id();
    Set<Participant> participants();
    void postMessage(Message message);
    ParticipantManageable participantManagement();
}
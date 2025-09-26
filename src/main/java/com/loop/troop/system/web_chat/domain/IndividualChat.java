package com.loop.troop.system.web_chat.domain;

import java.util.Set;

public final class IndividualChat implements Chat {

    private final ChatId id;
    private final Participant userA;
    private final Participant userB;

    public IndividualChat(ChatId id, Participant userA, Participant userB) {
        this.id = id;
        this.userA = userA;
        this.userB = userB;
    }

    @Override
    public void postMessage(Message message) { /* logic */ }

    @Override
    public ParticipantManageable participantManagement() { 
        return new NullParticipantManageable(); 
    }

    @Override
    public Set<Participant> participants() { return Set.of(userA, userB); }

    @Override
    public ChatId id() { return id; }
}

package com.loop.troop.system.web_chat.domain;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public final class GroupChat implements Chat, ParticipantManageable {

    private final ChatId id;
    private final UserId owner;
    private final Set<Participant> participants = new HashSet<>();

    public GroupChat(ChatId id, UserId owner) {
        this.id = id;
        this.owner = owner;
        participants.add(new Participant(UUID.randomUUID(), owner.id(), LocalDateTime.now(), Role.OWNER, Status.ACTIVE, null, false, null));
    }

    @Override
    public void postMessage(Message message) { /* logic */ }

    @Override
    public ParticipantManageable participantManagement() { return this; }

    @Override
    public void addParticipant(Participant p) { participants.add(p); }

    @Override
    public void removeParticipant(Participant p) { participants.remove(p); }

    @Override
    public ChatId id() { return id; }

    @Override
    public Set<Participant> participants() {
        return Collections.unmodifiableSet(participants);
    }
}

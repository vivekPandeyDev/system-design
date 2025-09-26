package com.loop.troop.system.web_chat.domain;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class NullParticipantManageable implements ParticipantManageable {

    @Override
    public void addParticipant(Participant p) {
        log.warn("Attempted to add participant {} to an IndividualChat. Operation ignored.", p.userId());
    }

    @Override
    public void removeParticipant(Participant p) {
        log.warn("Attempted to remove participant {} from an IndividualChat. Operation ignored.", p.userId());
    }
}

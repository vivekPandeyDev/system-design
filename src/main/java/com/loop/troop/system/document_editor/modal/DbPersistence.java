package com.loop.troop.system.document_editor.modal;

import lombok.extern.log4j.Log4j2;

@Log4j2
public record DbPersistence() implements Persistence{
    @Override
    public void save(String data) {
        log.info("saving data to db");
    }
}

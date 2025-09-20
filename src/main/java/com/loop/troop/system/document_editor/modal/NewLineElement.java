package com.loop.troop.system.document_editor.modal;


import lombok.extern.log4j.Log4j2;


@Log4j2
public record NewLineElement() implements DocumentElement {
    @Override
    public String render() {
        return "\n";
    }
}

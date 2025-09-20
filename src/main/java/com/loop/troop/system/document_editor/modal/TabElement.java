package com.loop.troop.system.document_editor.modal;

public record TabElement() implements DocumentElement{
    @Override
    public String render() {
        return "\t";
    }
}

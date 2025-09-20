package com.loop.troop.system.document_editor.modal;


import lombok.extern.log4j.Log4j2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



@Log4j2
public class Document implements DocumentEditor {
    private final List<DocumentElement> elementList = new ArrayList<>();
    @Override
    public void add(DocumentElement element) {
        elementList.add(element);
    }

    @Override
    public void remove(DocumentElement documentElement) {
        elementList.remove(documentElement);
    }


    @Override
    public List<DocumentElement> getElements() {
        return Collections.unmodifiableList(elementList);
    }
}

package com.loop.troop.system.document_editor.modal;

import java.util.List;

public interface DocumentEditor {
    void add(DocumentElement element);
    void remove(DocumentElement documentElement);
    List<DocumentElement> getElements();
}

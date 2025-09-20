package com.loop.troop.system.document_editor.modal;

import java.util.Map;

public interface DocumentElementFactory {
    DocumentElement create(ElementType type, Map<String, Object> params);
}

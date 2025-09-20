package com.loop.troop.system.document_editor.modal;

import java.util.Map;

public record DefaultDocumentElementFactory() implements DocumentElementFactory {

    @Override
    public DocumentElement create(ElementType type, Map<String, Object> params) {
        return switch (type) {
            case TEXT -> new TextElement((String) params.get("text"));

            case IMAGE -> {
                String path = (String) params.get("path");
                yield new ImageElement(path);
            }

            case NEW_LINE -> new NewLineElement();

            case TAB -> new TabElement();

            case CODE_BLOCK -> new CodeBlockElement(
                    (String) params.get("code"),
                    (String) params.get("language")
            );

        };
    }
}

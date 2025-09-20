package com.loop.troop.system.document_editor.modal;


/**
 * @param language e.g., "java", "python", "javascript"
 */
public record CodeBlockElement(String code, String language) implements DocumentElement {

    @Override
    public String render() {
        String lang = language == null ? "" : language;
        return """
                ```
                %s
                %s
                ```
                """.formatted(lang, code);
    }
}
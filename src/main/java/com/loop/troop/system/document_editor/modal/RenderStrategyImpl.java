package com.loop.troop.system.document_editor.modal;

public record RenderStrategyImpl() implements RenderStrategy {

    @Override
    public String render(DocumentEditor document) {
        StringBuilder result = new StringBuilder();
        for (var element : document.getElements()){
            result.append(element.render());
        }
        return result.toString();
    }
}

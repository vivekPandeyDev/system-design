package com.loop.troop.system.document_editor.modal;


import lombok.extern.log4j.Log4j2;

import java.util.HashMap;
import java.util.Map;


@Log4j2
public record DocumentManager(DocumentEditor documentEditor, Persistence persistence, RenderStrategy renderStrategy,DocumentElementFactory elementFactory) {

    public void addElement(ElementType type, Map<String,Object> params) {
        DocumentElement element = elementFactory.create(type, params);
        documentEditor.add(element);
    }

    public DocumentElement getImageElement(String path) {
        String[] split = path.split("\\.");
        if (split.length >= 2){
            return new ImageElement(split[0]);
        }
        return null;
    }

    public void addText(String text){
        addElement(ElementType.TEXT, Map.of("text", text));
    }
    public void addTextWithNewLine(String text){
        addText(text);
        addNewLine();
    }

    public void addImage(String path){
        String[] split = path.split("\\.");
        if (split.length >= 2){
            DocumentElement documentElement = new ImageElement(split[0]);
            documentEditor.add(documentElement);
        }
        addNewLine();
    }

    public void addNewLine(){
        addElement(ElementType.NEW_LINE,new HashMap<>());
    }

    public void addTab(){
        addElement(ElementType.TAB,new HashMap<>());
    }

    public void addCodeBlock(String language,String code){
        addElement(ElementType.CODE_BLOCK, Map.of("language", language, "code", code));
    }
    public void remove(DocumentElement documentElement){
        documentEditor.remove(documentElement);
    }

    public void renderDocument(){
       log.info("\n{}", renderStrategy.render(documentEditor));
    }

    public void save(){
        persistence.save(renderStrategy.render(documentEditor));
    }

}

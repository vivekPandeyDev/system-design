package com.loop.troop.system.document_editor.modal;


import lombok.extern.log4j.Log4j2;


@Log4j2
public record DocumentManager(DocumentEditor documentEditor, Persistence persistence, RenderStrategy renderStrategy) {

    public void addText(String text){
        DocumentElement documentElement = new TextElement(text);
        documentEditor.add(documentElement);
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
    }

    public void addNewLine(){
        DocumentElement newLineElement = new NewLineElement();
        documentEditor.add(newLineElement);
    }

    public void addTab(){
        DocumentElement tabElement = new TabElement();
        documentEditor.add(tabElement);
    }

    public void addCodeBlock(String language,String code){
        DocumentElement codeBlockElement = new CodeBlockElement(code,language);
        documentEditor.add(codeBlockElement);
    }

    public void renderDocument(){
       log.info("\n{}", renderStrategy.render(documentEditor));
    }

    public void save(){
        persistence.save(renderStrategy.render(documentEditor));
    }

}

package com.loop.troop.system.document_editor;

import com.loop.troop.system.document_editor.modal.*;


public class Runner {
    public static void main(String[] args) {
        Persistence persistence = new DbPersistence();
        DocumentEditor documentEditor = new Document();
        RenderStrategy renderStrategy = new RenderStrategyImpl();
        DocumentElementFactory elementFactory = new DefaultDocumentElementFactory();
        DocumentManager documentManager = new DocumentManager(documentEditor,persistence, renderStrategy,elementFactory);
        documentManager.addTextWithNewLine("Hello world");
        documentManager.addTab();
        documentManager.addText("This is real world document editor example");
        documentManager.addImage("picture.jpg");
        documentManager.addCodeBlock(
                "public static void main(String[] args) {\n    System.out.println(\"Hello World\");\n}",
                "java"
        );
        documentManager.remove(documentManager.getImageElement("picture.jpg"));
        documentManager.addImage("sample-image.jpg");
        documentManager.renderDocument();
        documentManager.save();
    }


}

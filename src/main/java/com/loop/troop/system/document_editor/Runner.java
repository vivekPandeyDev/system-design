package com.loop.troop.system.document_editor;

import com.loop.troop.system.document_editor.modal.*;

public class Runner {
    public static void main(String[] args) {
        Persistence persistence = new DbPersistence();
        DocumentEditor documentEditor = new Document();
        RenderStrategy renderStrategy = new RenderStrategyImpl();
        DocumentManager documentManager = new DocumentManager(documentEditor,persistence, renderStrategy);
        documentManager.addTextWithNewLine("Hello world");
        documentManager.addTab();
        documentManager.addText("This is real world document editor example");
        documentManager.addNewLine();
        documentManager.addImage("picuture.jpg");
        documentManager.addNewLine();
        documentManager.addCodeBlock(
                "public static void main(String[] args) {\n    System.out.println(\"Hello World\");\n}",
                "java"
        );
        documentManager.renderDocument();
        documentManager.save();
    }
}

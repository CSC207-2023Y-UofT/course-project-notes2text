package com.example.fileeditor_notes2text;

import org.w3c.dom.Text;

import java.io.File;

public class OpenTextEditorInteracter {
    File lastFile;

    String lastFileRoot;

    public OpenTextEditorInteracter(File file) {
        this.lastFile = file;
        this.lastFileRoot = file.getAbsolutePath();
    }

    public boolean isTextFile(File file) {
        String fileName = file.getName();
        if (fileName.endsWith(".txt")) {
            TextFile newFile = new TextFile(file);
            return true;
        } else {
            return false;
        }
    }

    public String returnRootAddress(File file) {
        String rootAddress = file.getAbsolutePath();
        this.lastFileRoot = rootAddress;
        return rootAddress;
    }

    public File getLastOpened() {
        return this.lastFile;
    }
}

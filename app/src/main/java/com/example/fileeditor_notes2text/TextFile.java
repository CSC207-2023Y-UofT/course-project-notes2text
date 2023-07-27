package com.example.fileeditor_notes2text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TextFile {
    private String content;

    private final String rootAddress;

    private final File file;

    // returns text from a text file
    public TextFile(File file) {
        this.rootAddress = file.getAbsolutePath();
        this.file = file;
    }

    public String extractText() {
        StringBuilder stringBuilder = new StringBuilder();
        String filePath = this.rootAddress;

        try {
            if (this.file.exists() && filePath.endsWith(".txt")) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line);
                    stringBuilder.append("\n"); // Add a newline character for each line
                }

                bufferedReader.close();

            } else {
                // Handle the case when the file does not exist
                return "File not found";
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Error reading the file";
        }
        this.content = stringBuilder.toString();
        return this.content;
    }
}

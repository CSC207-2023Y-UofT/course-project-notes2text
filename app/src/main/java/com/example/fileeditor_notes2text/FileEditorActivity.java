package com.example.fileeditor_notes2text;

import androidx.appcompat.app.AppCompatActivity;
import java.io.File;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.EditText;


public class FileEditorActivity extends AppCompatActivity {

    private EditText textToEdit;

    private File file;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.file_editor_main);

        textToEdit = findViewById(R.id.editTextTextMultiLine);

        // Display text from txt file
//        File initialFile = (File)getIntent().getSerializableExtra("file");
//        TextFile fileToOpen = new TextFile(initialFile);
//        String fileContent = fileToOpen.extractText();
//        textToEdit.setText(new SpannableString(fileContent));
//
//        file = initialFile;


    }

    public void buttonCapitalize(View view) {

        Spannable text = new SpannableStringBuilder(textToEdit.getText());
        text.setSpan(new StyleSpan(Typeface.BOLD),
                textToEdit.getSelectionStart(),
                textToEdit.getSelectionEnd(), 0);


        textToEdit.setText(text);

    }

    public void buttonLowercase(View view) {

        Spannable text = new SpannableStringBuilder(textToEdit.getText());
        text.setSpan(new StyleSpan(Typeface.ITALIC),
                textToEdit.getSelectionStart(),
                textToEdit.getSelectionEnd(), 0);

        textToEdit.setText(text);
    }

    public void buttonReset(View view) {
        String text = textToEdit.getText().toString();
        textToEdit.setText(text);
    }

    public void buttonHome(View view) {
//        Intent switchToHome = new Intent(FileEditorActivity.this,
//                ActivitySwitchController.class);
//        String path = file.getAbsolutePath();
//        String fileName = file.getName();
//        String actualPath = path.replace(fileName, "");
//        switchToHome.putExtra("path", actualPath);
//        startActivity(switchToHome);
     }

    public void buttonSave(View view) {
        // passes the file path when switching to save screen
        Intent switchToSave = new Intent(FileEditorActivity.this, SavePopUp.class);
        String path = file.getAbsolutePath();
        String fileName = file.getName();
        String actualPath = path.replace(fileName, "");
        switchToSave.putExtra("path", actualPath);

        // passes the text when switching to save screen
        String text = textToEdit.getText().toString();
        switchToSave.putExtra("text", text);
        startActivity(switchToSave);
    }



//    // implement home, save, and join
//    // don't forget to bind to when clicked
//    // on the way back to activityswitchcontroller you need to pass the file path with the
//    // file name strip
}

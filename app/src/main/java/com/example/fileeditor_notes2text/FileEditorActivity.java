package com.example.fileeditor_notes2text;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.EditText;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.widget.Toast;


public class FileEditorActivity extends AppCompatActivity {

    private EditText textToEdit;
    private static final String FILE_NAME = "filename.txt";
    private Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textToEdit = findViewById(R.id.editTextTextMultiLine);
        textToEdit.setText(new SpannableString("hello there"));


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

    public void buttonSave(View view) {

        String text = textToEdit.getText().toString();
        FileOutputStream fos = null;

        try {
            fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
            fos.write(text.getBytes());

            Toast.makeText(this, "Saved to " + getFilesDir() + "/" + FILE_NAME,
                    Toast.LENGTH_LONG).show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    // public void openSavePopUp() {
        // SavePopUp savePopUp = new SavePopUp();
        // savePopUp.show(getSupportFragmentManager(), "file name");
        // }
    }
    // implement home, save, and join
    // don't forget to bind to when clicked
}

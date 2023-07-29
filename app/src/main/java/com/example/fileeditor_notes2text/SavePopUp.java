package com.example.fileeditor_notes2text;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialogFragment;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SavePopUp extends AppCompatActivity {
    private EditText fileName;
    private String filePath;
    private String content;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.save_file_name);

        fileName = findViewById(R.id.set_file_name);

        filePath = getIntent().getStringExtra("path");
        content = getIntent().getStringExtra("text");

    }

    public void buttonCancel(View view) {
        Intent switchToEditor = new Intent(SavePopUp.this, FileEditorActivity.class);
        startActivity(switchToEditor);
    }

    public void buttonConfirm(View view) {
        FileOutputStream fos = null;
        String newName = fileName.getText().toString();

        try {
            fos = openFileOutput(newName, MODE_PRIVATE);
            fos.write(content.getBytes());

            Toast.makeText(this, "Saved to " + filePath + "/" + newName + ".txt",
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

    }

}

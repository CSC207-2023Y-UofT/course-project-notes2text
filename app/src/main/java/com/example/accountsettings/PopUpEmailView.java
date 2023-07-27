package com.example.accountsettings;

import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class PopUpEmailView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_email_view);

        EditText input = (EditText) findViewById(R.id.editTextEmail);
    }
}
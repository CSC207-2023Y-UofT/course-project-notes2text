package com.example.accountsettings;

import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class PopUpPasswordView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_password_view);

        EditText input = (EditText) findViewById(R.id.editTextTextPassword);
        EditText input2 = (EditText) findViewById(R.id.editTextTextPassword2);

    }
}
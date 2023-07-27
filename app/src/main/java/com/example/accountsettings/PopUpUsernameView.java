package com.example.accountsettings;

import Adaptors.PopUpUsernameController;
import Adaptors.PopUpUsernamePresenter;
import UseCase.UserUpdateInfo;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Bundle;

public class PopUpUsernameView extends SettingsActivity {

    UserUpdateInfo user = new UserUpdateInfo("ok", "ok", "ok");
    PopUpUsernameController controller = new PopUpUsernameController();
    PopUpUsernamePresenter presenter = new PopUpUsernamePresenter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_username_view);

        TextView text = (TextView) findViewById(R.id.CurrentUsername);
        EditText input = (EditText) findViewById(R.id.editTextTextPersonName);

        presenter.showUsername(user, text);

        Button submit = (Button) findViewById(R.id.Submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.buttonPressed(user, input, text);
            }
        });

    }
}
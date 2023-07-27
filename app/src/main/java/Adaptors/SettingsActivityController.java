package Adaptors;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceFragmentCompat;
import com.example.accountsettings.PopUpEmailView;
import com.example.accountsettings.PopUpPasswordView;
import com.example.accountsettings.PopUpUsernameView;
import com.google.android.material.chip.Chip;
import com.example.accountsettings.SettingsActivity;
public class SettingsActivityController extends AppCompatActivity {

    public SettingsActivityController(){}
    public void checkButtonClick(Button b, Button c, Button d){

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), PopUpUsernameView.class));
            }
        });

        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), PopUpPasswordView.class));
            }
        });

        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(), PopUpEmailView.class));
            }
        });
    }



}

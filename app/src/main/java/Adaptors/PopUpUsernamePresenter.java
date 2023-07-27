package Adaptors;

import UseCase.UserUpdateInfo;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class PopUpUsernamePresenter extends AppCompatActivity {

    public PopUpUsernamePresenter(){}

    public void showUsername(UserUpdateInfo user, TextView text){
        text.setText(user.getUsername());
    }
}

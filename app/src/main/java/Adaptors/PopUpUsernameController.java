package Adaptors;

import UseCase.UserUpdateInfo;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class PopUpUsernameController extends AppCompatActivity {
    PopUpUsernamePresenter presenter = new PopUpUsernamePresenter();
    public PopUpUsernameController(){}

    public void buttonPressed(UserUpdateInfo user, EditText input, TextView text){
        user.changeUsername(input.getText().toString());
        presenter.showUsername(user, text);
    }


}

package app.switchingscreens.whilchy.com.switchingscreens;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by daniel on 30/11/14.
 */
public class SecondScreen extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.second_layout);

        Intent activityThatCalled = getIntent();     // Get the intents that opened this activity
        String previousActivity = activityThatCalled.getExtras().getString("callingActivity");

        TextView callingActivityMessage = (TextView) findViewById(R.id.calling_activity_info_text_view);
        callingActivityMessage.append(" " + previousActivity);
    }

    public void onSendUserNameClick(View view) {
        EditText usersNameEditText = (EditText) findViewById(R.id.users_name_edit_text);
        String usersName = String.valueOf(usersNameEditText.getText());

        Intent goingBack = new Intent();
        goingBack.putExtra("usersName", usersName);

        setResult(RESULT_OK, goingBack);
        finish();
    }
}

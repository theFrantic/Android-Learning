package app.multipanefragments.whilchy.com.multipanefragment;

import android.content.res.Configuration;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int screenOrientation = getResources().getConfiguration().orientation;

        if(screenOrientation == Configuration.ORIENTATION_PORTRAIT) {
            hideSidePanel();
        }
    }

    private void hideSidePanel() {
        View sidePanel = findViewById(R.id.side_panel);
        if (sidePanel.getVisibility() == View.VISIBLE) {
            sidePanel.setVisibility(View.GONE);
        }
    }

}

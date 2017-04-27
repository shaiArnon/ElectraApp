package group91.hackathon2017.idc.electrachallenge;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class SplashActivity extends Activity {

    Handler handler = new Handler();
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        /*if (savedInstanceState == null) {
            Preferences.initializeMissions();
            Preferences.setMission(0);
        }*/

        textView = (TextView) findViewById(R.id.textView_splash);
        textView.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in));

        handler.postDelayed(mLaunchTask, 5000);
    }

    private Runnable mLaunchTask = new Runnable() {
        public void run() {
            Intent i = new Intent(getApplicationContext(), MainMenuActivity.class);
            startActivityForResult(i, 0);

            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == -1) {
            finish();
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
package group91.hackathon2017.idc.electrachallenge;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class WelcomeActivity extends Activity implements View.OnTouchListener {

    Drawable drawableStartScan, drawableStartScan_pressed;
    ImageView buttonStartScan, buttonHelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Config.setStatusBarColor(this, R.color.colorOrange);

        drawableStartScan = Config.getDrawable(getApplicationContext(), R.drawable.start_scan_button);
        drawableStartScan_pressed = Config.getDrawable(getApplicationContext(), R.drawable.start_scan_button_pressed);

        buttonStartScan = (ImageView) findViewById(R.id.imageView_welcomeButtonStartScan);
        buttonHelp = (ImageView) findViewById(R.id.imageView_welcomeHelpButton);

        buttonStartScan.setOnTouchListener(this);

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imageView_welcomeButtonStartScan:
                startActivityForResult(new Intent(getApplicationContext(), CaptureLabelActivity.class), 0);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                break;
        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if(motionEvent.getAction() == MotionEvent.ACTION_UP){
            if (buttonStartScan.getDrawable() != drawableStartScan) {
                buttonStartScan.setImageDrawable(drawableStartScan);
            }
        } else {
            if (buttonStartScan.getDrawable() != drawableStartScan_pressed) {
                buttonStartScan.setImageDrawable(drawableStartScan_pressed);
            }
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        setResult(-1);
    }
}

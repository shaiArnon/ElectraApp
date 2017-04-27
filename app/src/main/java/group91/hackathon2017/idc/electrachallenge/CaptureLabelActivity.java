package group91.hackathon2017.idc.electrachallenge;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class CaptureLabelActivity extends Activity implements View.OnTouchListener {

    Drawable drawableOpenCamera, drawableOpenCamera_pressed;
    ImageView buttonOpenCamera, buttonHelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capture_label);

        Config.setStatusBarColor(this, R.color.colorOrange);

        drawableOpenCamera = Config.getDrawable(getApplicationContext(), R.drawable.open_camera_button);
        drawableOpenCamera_pressed = Config.getDrawable(getApplicationContext(), R.drawable.open_cammera_button_pressed);

        buttonOpenCamera = (ImageView) findViewById(R.id.imageView_captureLabelOpenCamera);
        buttonHelp = (ImageView) findViewById(R.id.imageView_captureLabelHelp);

        buttonOpenCamera.setOnTouchListener(this);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imageView_captureLabelOpenCamera:
                startActivityForResult(new Intent(getApplicationContext(), CaptureLedActivity.class), 0);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                break;
        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if(motionEvent.getAction() == MotionEvent.ACTION_UP){
            if (buttonOpenCamera.getDrawable() != drawableOpenCamera) {
                buttonOpenCamera.setImageDrawable(drawableOpenCamera);
            }
        } else {
            if (buttonOpenCamera.getDrawable() != drawableOpenCamera_pressed) {
                buttonOpenCamera.setImageDrawable(drawableOpenCamera_pressed);
            }
        }
        return false;
    }
}

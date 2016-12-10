package edu.gatech.atmauth;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

public class NFCActivity extends AppCompatActivity {

    ProgressBar progressBar;
    ImageButton button_nfc;
    float x1, x2;
    static final int MIN_DISTANCE = 150;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nfc);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        // enable swipe listener
        button_nfc = (ImageButton) findViewById(R.id.imageButton_scan);
        button_nfc.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        //Button pressed
                        x1 = event.getX();
                        return true;

                    case MotionEvent.ACTION_UP:
                        //Button released
                        x2 = event.getX();
                        float deltaX = x2 - x1;
                        if (Math.abs(deltaX) > MIN_DISTANCE) {
                            swipe_nfc(v);
                        } else {
                            // Fail if swipe not long enough
                            Toast.makeText(NFCActivity.this, "Reading NFC failed. Need a longer left-to-right swipe.", Toast.LENGTH_LONG).show();
                            click_fail(v);
                        }
                        return true;
                }
                return false;
            }
        });
    }

    public void swipe_nfc(View view) {
        //show loading progress bar for some delay period
        Toast.makeText(NFCActivity.this, "Reading NFC...", Toast.LENGTH_SHORT).show();
        progressBar.setVisibility(View.VISIBLE);
        new CountDownTimer(2000, 1000) {
            public void onFinish() {
                progressBar.setVisibility(View.INVISIBLE);
                Intent intent = new Intent(getApplicationContext(), SuccessActivity.class);
                startActivity(intent);
            }

            public void onTick(long millisUntilFinished) {
            }
        }.start();
    }

    public void click_fail(View view) {
        Intent intent = new Intent(this, FailActivity.class);
        startActivity(intent);
    }
}

package edu.gatech.atmauth;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

public class FingerprintActivity extends AppCompatActivity {
    ImageButton button_fingerprint;
    ProgressBar progressBar;
    boolean premature_lift = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fingerprint);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        button_fingerprint = (ImageButton) findViewById(R.id.imageButton_scan);
        button_fingerprint.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // Button pressed
                        click_fingerprint(v);
                        return true;

                    case MotionEvent.ACTION_UP:
                        // Button released
                        // fail if hold lifted prematurely
                        premature_lift = true;
                        return true;
                }
                return false;
            }
        });
    }

    public void click_fingerprint(View view) {
        //show loading progress bar for some delay period
        Toast.makeText(FingerprintActivity.this, "Reading fingerprint...", Toast.LENGTH_SHORT).show();
        progressBar.setVisibility(View.VISIBLE);
        new CountDownTimer(2000, 1000) {
            public void onFinish() {
                progressBar.setVisibility(View.INVISIBLE);
                Intent intent = new Intent(getApplicationContext(), SuccessActivity.class);
                if (premature_lift) {
                    Toast.makeText(FingerprintActivity.this, "Reading fingerprint failed. Need to hold button press longer.", Toast.LENGTH_LONG).show();
                    intent = new Intent(getApplicationContext(), FailActivity.class);
                    premature_lift = false;
                }
                startActivity(intent);
            }

            public void onTick(long millisUntilFinished) {
            }
        }.start();
    }
}

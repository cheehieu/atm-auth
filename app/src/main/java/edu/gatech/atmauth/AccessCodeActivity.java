package edu.gatech.atmauth;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

public class AccessCodeActivity extends AppCompatActivity {

    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_access_code);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

    }

    public void click_access_code(View view) {
        //show loading progress bar for some delay period
        Toast.makeText(AccessCodeActivity.this, "Reading access code...", Toast.LENGTH_SHORT).show();
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
}

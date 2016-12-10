package edu.gatech.atmauth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SuccessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        // show timer result


//        Toast.makeText(SuccessActivity.this, "Stay on this screen. PROCTOR: record value before proceeding.", Toast.LENGTH_LONG).show();
    }

    public void click_home(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}

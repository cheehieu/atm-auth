package edu.gatech.atmauth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AuthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
    }

    public void click_fingerprint(View view) {
        Intent intent = new Intent(this, FingerprintActivity.class);
        startActivity(intent);
    }

    public void click_access_code(View view) {
        Intent intent = new Intent(this, AccessCodeActivity.class);
        startActivity(intent);
    }

    public void click_nfc(View view) {
        Intent intent = new Intent(this, NFCActivity.class);
        startActivity(intent);
    }

    public void click_card(View view) {
        Intent intent = new Intent(this, CardActivity.class);
        startActivity(intent);
    }
}

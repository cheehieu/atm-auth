package edu.gatech.atmauth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Remove title bar
        setContentView(R.layout.activity_main);
    }

    public void click_logon(View view) {
        Intent intent = new Intent(this,HomeActivity.class);
        startActivity(intent);
    }

    //Main: login (email, password, create new account, forgot password)
    //ATM transactions (set up withdrawal)
    //ATM authenticate (dialog with QR code, 6-digit PIN, 7-digit access code, 2-factor authentication, fingerprint
    //instructions to physically interact with ATM
    //fail page
    //success page
    //loading page with delay
    //cash raining animation
    //SW logging timer from Home action selection to success screen with different authentication methods

}

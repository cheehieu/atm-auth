package edu.gatech.atmauth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void click_withdraw(View view) {
        Intent intent = new Intent(this, WithdrawActivity.class);
        startActivity(intent);
    }

    public void click_auth(View view) {
        Intent intent = new Intent(this, AuthActivity.class);
        startActivity(intent);
    }

    public void click_null(View view) {
        Toast.makeText(HomeActivity.this, "Function not yet supported.",
                Toast.LENGTH_SHORT).show();
    }
}

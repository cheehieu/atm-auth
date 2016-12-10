package edu.gatech.atmauth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class WithdrawActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withdraw);
    }

    public void click_auth(View view) {
        Intent intent = new Intent(this, AuthActivity.class);
        startActivity(intent);
    }

    public void click_null(View view) {
        Toast.makeText(WithdrawActivity.this, "Function not yet supported.",
                Toast.LENGTH_SHORT).show();
    }
}

package com.shopping.app.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.shopping.app.R;

import java.util.Objects;

public class ThankYouActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thank_you);

        findViewById(R.id.view_profile_btn_id).setOnClickListener(v -> {
            onBackPressed();
        });

        // return cart button
        findViewById(R.id.return_cart_btn_id).setOnClickListener(v -> {
            // Set the flags to clear the activity stack and bring the main activity to the top
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        });

    }
}
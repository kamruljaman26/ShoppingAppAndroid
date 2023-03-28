package com.shopping.app.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;

import com.shopping.app.R;
import com.shopping.app.model.User;

import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {

    private EditText mNameEditText;
    private EditText mPhoneEditText;
    private EditText mEmailEditText;
    private Button mRegisterButton;
    private static User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mNameEditText = findViewById(R.id.name_txt_id);
        mPhoneEditText = findViewById(R.id.phone_txt_id);
        mEmailEditText = findViewById(R.id.email_txt_id);
        mRegisterButton = findViewById(R.id.register_btn_id);

        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });

        // updated if have any saved data
        updateUserData();

        // Set up the back button
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Back");
    }

    private void register() {
        // Get user input
        String name = mNameEditText.getText().toString().trim();
        String phone = mPhoneEditText.getText().toString().trim();
        String email = mEmailEditText.getText().toString().trim();

        // Validate input
        if (name.isEmpty()) {
            // Name field is empty
            showToast("Please enter your name");
            return;
        }
        if (!isValidName(name)) {
            // Name contains numbers
            showToast("Name can't contain numbers");
            return;
        }
        if (phone.isEmpty()) {
            // Phone field is empty
            showToast("Please enter your phone number");
            return;
        }
        if (!isValidPhone(phone)) {
            // Invalid phone number format
            showToast("Invalid phone number format");
            return;
        }
        if (email.isEmpty()) {
            // Email field is empty
            showToast("Please enter your email address");
            return;
        }
        if (!isValidEmail(email)) {
            // Invalid email address format
            showToast("Invalid email address format");
            return;
        }

        // Save user information
        user = new User(name, phone, email);

        // Display success message and move to thank you activity
        showToast("Registration successful");
        Intent intent = new Intent(getApplicationContext(), ThankYouActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        updateUserData();
    }

    // update saved data in filed
    private void updateUserData() {
        if (user != null) {
            mNameEditText.setText(user.getName());
            mEmailEditText.setText(user.getEmail());
            mPhoneEditText.setText(user.getPhone());
        }
    }

    private boolean isValidName(String name) {
        // Name can't contain numbers
        return !Pattern.matches(".*\\d.*", name);
    }

    private boolean isValidPhone(String phone) {
        // Phone number must be a valid phone number format
        return Patterns.PHONE.matcher(phone).matches();
    }

    private boolean isValidEmail(String email) {
        // Email address must be a valid email address format
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}

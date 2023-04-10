package com.inventory.mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    private TextView encryptedTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        encryptedTextView = findViewById(R.id.encrypted_text_view);

        // Get the encrypted text from the intent
        String encryptedText = getIntent().getStringExtra("encryptedText");

        // Display the encrypted text in the TextView
        encryptedTextView.setText(encryptedText);
    }

}
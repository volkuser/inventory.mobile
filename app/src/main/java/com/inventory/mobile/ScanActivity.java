package com.inventory.mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import android.widget.Toast;

public class ScanActivity extends AppCompatActivity {
    private Button scanButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);

        scanButton = findViewById(R.id.scan_button);

        scanButton.setOnClickListener(view -> {
            if (view.getId() == R.id.scan_button) {
                // Initialize the IntentIntegrator and start scanning
                IntentIntegrator integrator = new IntentIntegrator(ScanActivity.this);
                integrator.setOrientationLocked(true)
                        .setDesiredBarcodeFormats(IntentIntegrator.QR_CODE).setPrompt("Наведите камеру на QR-код единицы оборудования")
                        .setCameraId(0)
                        .setCaptureActivity(CaptureActivityPortrait.class)
                        .setBeepEnabled(false)
                        .setBarcodeImageEnabled(false)
                        .initiateScan();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
                Toast.makeText(this, "Сканирование приостановлено", Toast.LENGTH_LONG).show();
            } else {
                // Get the encrypted text from the QR code
                String encryptedText = result.getContents();

                // Create a new intent to start the next activity
                Intent intent = new Intent(this, InfoActivity.class);
                intent.putExtra("encryptedText", encryptedText);
                startActivity(intent);
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

}
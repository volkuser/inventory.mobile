package com.inventory.mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.inventory.mobile.model.EquipmentUnit;

import java.io.IOException;
import java.util.UUID;

public class InfoActivity extends AppCompatActivity {
    private TextView invNumberTextView, modelTextView, typeTextView, manufacturerTextView, locationTextView, statusTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        invNumberTextView = findViewById(R.id.inv_number_txt_view);
        modelTextView = findViewById(R.id.model_txt_view);
        typeTextView = findViewById(R.id.type_txt_view);
        manufacturerTextView = findViewById(R.id.manufacturer_txt_view);
        locationTextView = findViewById(R.id.location_txt_view);
        statusTextView = findViewById(R.id.status_txt_view);

        // Get the encrypted text from the intent
        String encryptedText = getIntent().getStringExtra("encryptedText");
        EquipmentUnit current;
        try {
            current = EquipmentUnitApiService.getEquipmentUnitByGuidCode(UUID.fromString(encryptedText));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Display the encrypted text in the TextView
        invNumberTextView.setText("Инвентарный номер: " + current.getInventoryNumber());
        typeTextView.setText("Тип: " + current.getEquipment().getEquipmentType().getEquipmentTypeName());
        modelTextView.setText("Модель: " + current.getEquipment().getModelName());
        manufacturerTextView.setText("Производитель: " + current.getEquipment().getManufacturer());
        locationTextView.setText("Местоположение: " + current.getLocation().getLocationNumber() + " (" + current.getLocation().getTrainingCenter().getCenterAddress() + ")");
        statusTextView.setText("Статус: " + (current.isOnState() ? "на месте" : "нет на месте"));

        ImageView backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(view -> onBackPressed());
    }
}
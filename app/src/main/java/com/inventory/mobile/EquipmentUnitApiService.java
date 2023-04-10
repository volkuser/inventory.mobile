package com.inventory.mobile;

import android.os.StrictMode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.UUID;

import com.google.gson.Gson;
import com.inventory.mobile.model.EquipmentUnit;

public class EquipmentUnitApiService {

    public static EquipmentUnit getEquipmentUnitByGuidCode(UUID guidCode) throws IOException {
        URL url = new URL("http://192.168.1.67:8081/equipment-units/guid/" + guidCode.toString());
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        /// TODO delete this 2 lines, if realize https
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        // Read the response as an InputStream
        InputStream inputStream = connection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        // Convert the response to a String
        StringBuilder responseBuilder = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            responseBuilder.append(line);
        }
        String response = responseBuilder.toString();

        // Parse the response as an EquipmentUnit object using Gson
        Gson gson = new Gson();
        EquipmentUnit equipmentUnit = gson.fromJson(response, EquipmentUnit.class);

        return equipmentUnit;
    }
}


package com.example.listcity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    // declare variables for later use
    ListView cityList;
    ArrayAdapter<String> cityAdapter;
    ArrayList<String> dataList;

    EditText inputCityText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button_add_city = findViewById(R.id.button_add_city);
        Button button_delete_city = findViewById(R.id.button_delete_city);

        inputCityText = findViewById(R.id.editText_city_name_userin);

        cityList = findViewById(R.id.city_list);

//        String []cities = {"Edmonton", "Vancouver", "Moscow", "Sydney", "Berlin", "Vienna", "Tokyo", "Beijing", "Osaka", "New Delhi"};
        String []cities = {"Edmonton"};
        dataList = new ArrayList<>();
        dataList.addAll(Arrays.asList(cities));

        cityAdapter = new ArrayAdapter<>(this, R.layout.content, dataList);
        cityList.setAdapter(cityAdapter);

        button_add_city.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // this is the code that is executed when the button is clicked
                addCity();
            }
        });

        button_delete_city.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // this is the code that is executed when the button is clicked
                deleteCity();
            }
        });
    }

    public void addCity() {
        String city = inputCityText.getText().toString();
        dataList.add(city);
        cityList.setAdapter(cityAdapter);
    }

    public void deleteCity() {
        String city = inputCityText.getText().toString();
        dataList.remove(city);
        cityList.setAdapter(cityAdapter);
    }
}
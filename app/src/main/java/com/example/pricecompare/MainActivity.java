package com.example.pricecompare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

     RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button exitBtn =findViewById(R.id.exitBtn);
        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });

        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                 radioButton= findViewById(checkedId);
                Toast.makeText(getApplicationContext(),"Selected " + radioButton.getText(), Toast.LENGTH_SHORT).show();
            }
        });

        Button searchBtn = findViewById(R.id.buttonSearch);
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sendText = radioButton.getText().toString();
                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                intent.putExtra("SelectedCheckbox", sendText);
                startActivity(intent);
                finish();
            }
        });
    }
}
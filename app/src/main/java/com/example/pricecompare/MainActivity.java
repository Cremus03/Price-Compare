package com.example.pricecompare;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    RadioButton radioButton;
    Button searchBtn;
    String produs;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radioButton= findViewById(checkedId);
                Toast.makeText(getApplicationContext(),"Selected " + radioButton.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        searchBtn = findViewById(R.id.buttonSearch);
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                produs = radioButton.getText().toString();
                intent = new Intent(MainActivity.this, SearchActivity.class);
                intent.putExtra("SelectedCheckbox", produs);
                startActivity(intent);
            }
        });
    }
}
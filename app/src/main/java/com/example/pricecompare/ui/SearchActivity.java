package com.example.pricecompare.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.pricecompare.MainActivity;
import com.example.pricecompare.R;
import com.example.pricecompare.SearchingActivity;

public class SearchActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_search);

        Button backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SearchActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        textView = findViewById(R.id.textRadioBtn);
        Intent intent=getIntent();
        String value = intent.getStringExtra("SelectedCheckbox");
        textView.setText(value);


    }
}
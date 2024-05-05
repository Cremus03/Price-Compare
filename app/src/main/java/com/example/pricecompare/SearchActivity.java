package com.example.pricecompare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class SearchActivity extends AppMain {

    public SearchActivity(){
        setLayout(R.layout.activity_search);
    }

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ImageView backImg = findViewById(R.id.imageDelete);
        backImg.setOnClickListener(new View.OnClickListener() {
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
        textView.setText("Search for " + value );


    }
}
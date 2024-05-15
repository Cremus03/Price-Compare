package com.example.pricecompare;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.pricecompare.R;

public class ShowItemActivity extends AppCompatActivity {

    ScrollView scrollView;
    TextView textView;
    Uri url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_item);

        textView = findViewById(R.id.listItemView);
        Intent intent=getIntent();
        String value = intent.getStringExtra("SelectedItem");
        String model = intent.getStringExtra("SelectedListModel");
        model= model.toLowerCase();
        textView.setText("Search for " + value + " - " + model);


        switch (value){
            case "Phone":
                url = Uri.parse("http://www.emag.ro/telefoane-mobile/brand/"+model+"/c?ref=ceva");
                break;
            case "Tablet":
                url= Uri.parse("http://www.emag.ro/tablete/brand/"+model+"/c?ref=ceva");
                break;
            case "Watch":
                url = Uri.parse("http://www.emag.ro/smartwatch/brand/"+model+"/c?ref=ceva");
                break;
            case "Headphone":
                 url = Uri.parse("http://www.emag.ro/casti-bluetooth-telefoane/brand/"+model+"/c?ref=ceva");
                break;
            case "Laptop":
                 url = Uri.parse("http://www.emag.ro/laptopuri/brand/"+model+"/c?ref=ceva");
                break;
        }
        startActivity(new Intent(Intent.ACTION_VIEW,url));

    }
}
package com.example.pricecompare;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.net.MalformedURLException;
import java.net.URL;

public class ShowItemActivity extends AppCompatActivity {
    ScrollView scrollView;
    TextView textView;
    Uri url;
    Specifications listaProduse;
    static String marca, marcaUrl, produs;
    String model="P30 pro";
    String culoare="Blue";
    int memorieRom = 128, memorieRam =8;
    double pret= 2399.99;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_item);
        textView = findViewById(R.id.listItemView);
        Intent intent=getIntent();
        produs = intent.getStringExtra("SelectedItem");
        marca = intent.getStringExtra("SelectedListModel");
        marcaUrl= marca.toLowerCase();
        listaProduse = new Specifications(produs, marca, model, culoare, memorieRom, memorieRam, pret);
        textView.setText("Search for " + listaProduse);
        switch (produs){
            case "Phone":
//                url = Uri.parse("http://www.emag.ro/telefoane-mobile/brand/"+marcaUrl+"/c?ref=ceva");
                buildURL("http://www.emag.ro/telefoane-mobile/brand/") ;
                break;
            case "Tablet":
//                url= Uri.parse("http://www.emag.ro/tablete/brand/"+marcaUrl+"/c?ref=ceva");
                buildURL("http://www.emag.ro/tablete/brand/") ;
                break;
            case "Watch":
//                url = Uri.parse("http://www.emag.ro/smartwatch/brand/"+marcaUrl+"/c?ref=ceva");
                buildURL("http://www.emag.ro/smartwatch/brand/") ;
                break;
            case "Headphone":
//                 url = Uri.parse("http://www.emag.ro/casti-bluetooth-telefoane/brand/"+marcaUrl+"/c?ref=ceva");
                buildURL("http://www.emag.ro/casti-bluetooth-telefoane/brand/") ;
                break;
            case "Laptop":
//                 url = Uri.parse("http://www.emag.ro/laptopuri/brand/"+marcaUrl+"/c?ref=ceva");
                 buildURL("http://www.emag.ro/laptopuri/brand/") ;
                break;
        }
        startActivity(new Intent(Intent.ACTION_VIEW,url));
    }
    public static URL buildURL (String nume){
        URL urlFinal = null;
        try{
            urlFinal = new URL(nume+marcaUrl+"/c?ref=ceva");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return urlFinal;
    }
}
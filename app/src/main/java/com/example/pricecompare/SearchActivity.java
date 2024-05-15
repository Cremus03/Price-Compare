package com.example.pricecompare;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class SearchActivity extends AppMain {

    public SearchActivity(){
        setLayout(R.layout.activity_search);
    }

    TextView textView;
    ListView listView;
    ArrayAdapter<String> arrayAdapter;
    String[] modelList = {"Apple", "Samsung", "Huawei", "Xiaomi"};

    SearchView searchView;

    String marca, model, memorieRom, memorieRam, culoare, pret;
    private static String Json_URL = "http://www.emag.ro";
    ArrayList<HashMap<String, String>>  itemsList;


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

        listView= findViewById(R.id.listViewItems);
        if ("Phone".equals(value))
        {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.emag.ro/telefoane-mobile"));
            startActivity(browserIntent);
        }
        arrayAdapter = new ArrayAdapter<String>(this, R.layout.list_items, modelList);
        listView.setAdapter(arrayAdapter);



        searchView = findViewById(R.id.searchView);
        searchView.setQueryHint("Insert model here");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                arrayAdapter.getFilter().filter(newText);
                return false;
            }
        });
    }
}
package com.example.pricecompare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class SearchActivity extends AppCompatActivity {
    TextView textView;
    ListView listView;
    ImageView backImg;
    ArrayAdapter<String> arrayAdapter;
    String[] newList, phoneModelList = {"Apple", "Samsung", "Huawei", "Xiaomi", "Oppo","Motorola","Nokia","Realme","Ulefone","Poco"},
            tabletModelList = {"Apple", "Samsung","Lenovo","Microsoft","Blackview", "Huawei", "Xiaomi"},
            watchModelList = {"Apple", "Samsung", "Huawei", "Garnite"},
            headPhoneModelList = {"Apple", "Samsung", "Huawei", "Xiaomi"},
            laptopModelList = {"Apple", "Samsung", "Huawei", "Lenovo", "Microsoft"};
    SearchView searchView;
    String produs;
    static String marca;
    Intent intent;

//    private static final String Json_URL = "http://www.emag.ro";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        backImg = findViewById(R.id.imageDelete);
        backImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent = new Intent(SearchActivity.this, MainActivity.class);
                System.exit(0);
                startActivity(intent);
            }
        });
        textView = findViewById(R.id.textRadioBtn);
        intent = getIntent();
        produs = intent.getStringExtra("SelectedCheckbox");
        textView.setText("Search for " + produs);
        listView = findViewById(R.id.listViewItems);
        switch (produs) {
            case "Phone":
                newList = phoneModelList;
                break;
            case "Tablet":
                newList = tabletModelList;
                break;
            case "Watch":
                newList = watchModelList;
                break;
            case "Headphone":
                newList = headPhoneModelList;
                break;
            case "Laptop":
                newList = laptopModelList;
                break;
        }
        arrayAdapter = new ArrayAdapter<String>(this, R.layout.list_items, newList);
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
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        marca = (String) listView.getItemAtPosition(position);
                        intent = new Intent(SearchActivity.this, ShowItemActivity.class);
                        intent.putExtra("SelectedListItem", marca);
                        startActivity(intent);
                    }
                });
                return false;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                marca = (String) listView.getItemAtPosition(position);
                intent = new Intent(SearchActivity.this, ShowItemActivity.class);
                intent.putExtra("SelectedItem", produs);
                intent.putExtra("SelectedListModel", marca);
                startActivity(intent);
            }
        });

    }

    public static URL buildURL ( String nume){
        URL urlFinal = null;
        try{
            urlFinal = new URL("http://www.emag.ro/telefoane-mobile/brand/"+marca+"/c?ref=ceva");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return urlFinal;
    }
}

//public class JsonTask extends AsyncTask<String, String, String> {
//
//    ProgressDialog pd;
//    protected void onPreExecute(){
//        super.onPreExecute();
//
//        pd= new ProgressDialog(SearchActivity.this);
//        pd.setMessage("Please wait");
//        pd.setCancelable(false);
//        pd.show();
//    }
//
//    @Override
//    protected String doInBackground(String... strings) {
//
//        HttpURLConnection connection = null;
//        BufferedReader reader= null;
//
//        try{
//            URL url = new URL(strings[0]);
//            connection = (HttpURLConnection) url.openConnection();
//            connection.connect();
//
//            InputStream stream = connection.getInputStream();
//
//            reader = new BufferedReader(new InputStreamReader(stream));
//
//            StringBuffer buffer = new StringBuffer();
//            String line = "";
//
//            while ((line = reader.readLine()) != null){
//                buffer.append(line+"\n");
//                Log.d("Response: ", "> " + line);
//            }
//            return buffer.toString();
//
//        }catch (MalformedURLException e){
//            e.printStackTrace();
//        }catch (IOException e){
//            e.printStackTrace();
//        }finally {
//            if ( connection != null)
//                connection.disconnect();
//            try{
//                if (reader != null)
//                    reader.close();
//            }catch (IOException e){
//                e.printStackTrace();
//            }
//        }
//        return null;
//    }
//
//    protected void onPostExecute (String result){
//        super.onPostExecute(result);
//        if ( pd.isShowing())
//            pd.dismiss();
//        arrayAdapter.getFilter().filter(result);
//    }
//
//    }

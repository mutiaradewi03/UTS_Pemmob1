package com.example.utspemogramanmobile1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class DashBoardActivity extends Activity {

    ListView listView;

    // Data dummy
    String[] titles = {
            "Aviary",
            "Karnivora",
            "Nokturnal",
            "Reptil",
            "Zona Africa"
    };

    String[] descriptions = {
            "Kandang besar untuk burung",
            "Hewan pemakan daging",
            "Satwa yang tidur pada siang hari dan aktif pada malam hari",
            "Binatang merayap",
            "Satwa yang hidup di benua Afrika"
    };

    int[] images = {
            R.drawable.aviary,
            R.drawable.karnivora,
            R.drawable.nokturnal,
            R.drawable.reptil,
            R.drawable.jerapah
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board); // pastikan nama layout-nya sesuai

        listView = findViewById(R.id.newsListView);

        ItemList adapter = new ItemList(this, titles, descriptions, images);
        listView.setAdapter(adapter);
    }
}
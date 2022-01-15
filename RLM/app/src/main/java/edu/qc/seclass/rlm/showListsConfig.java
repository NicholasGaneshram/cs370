package edu.qc.seclass.rlm;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class showListsConfig extends AppCompatActivity {

    List<String> lists;
    ListView list;
    ArrayAdapter<String> adapter;
    DatabaseConfig db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_lists);

        db = new DatabaseConfig(getApplicationContext());
        lists = db.getLists();
        list = findViewById(R.id.listOfListsXML);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_activated_1, lists);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String temp = parent.getItemAtPosition(position).toString();
                Intent intent = new Intent (showListsConfig.this, viewListConfig.class);
                intent.putExtra("Name", temp);
                startActivity(intent);
            }
        });
        updateLists();
    }
    protected void updateLists(){
        db = new DatabaseConfig(getApplicationContext());

        lists = db.getLists();
        list = findViewById(R.id.listOfListsXML);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_activated_1, lists);
        list.setAdapter(adapter);
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        updateLists();
    }
}

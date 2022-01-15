package edu.qc.seclass.rlm;

import android.content.DialogInterface;
import android.widget.*;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button newList;
    Button newReminder;
    Button deleteList;
    Button showReminders;
    Button showLists;
    Button searchReminder;
    Spinner spinner3;
    String selectedList;
    DatabaseConfig db;
    List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner3 = (Spinner) findViewById(R.id.spinner4);
        selectedList = "";
        db = new DatabaseConfig(this);
        spinner3.setPrompt("Most recent created reminder list");
        list = db.getListsForMain();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter);
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (parent.getItemAtPosition(position).equals("Select a list ")) {

                }
                else{
                    selectedList = parent.getItemAtPosition(position).toString();
                        Toast.makeText(parent.getContext(), "Selected List: " + selectedList, Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        newReminder = (Button) findViewById(R.id.makeReminder);
        newReminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchCreatedReminder();
            }
        });
        deleteList = (Button) findViewById(R.id.deleteList);
        deleteList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteList();
            }
        });
        showReminders = (Button) findViewById(R.id.showReminders);
        showReminders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(spinner3.getSelectedItemPosition() != 0)
                    switchShowedReminders();
                else
                    Toast.makeText(getApplicationContext(),"A list has not been choosen", Toast.LENGTH_SHORT).show();
            }
        });
        newList = (Button) findViewById(R.id.makeList);
        newList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchCreatedList();
            }
        });
        showLists = (Button) findViewById(R.id.showLists);
        showLists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchShowLists();
            }
        });
        searchReminder = (Button) findViewById(R.id.searchReminder);
        searchReminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchSearchReminder();
            }
        });
    }
    public String getSelectedText (){
       return selectedList;
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        updatedSpinner();
    }
    public void updatedSpinner () {

        list = db.getListsForMain();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter);
    }
    public void switchCreatedList() {
        Intent intent = new Intent(this, newListConfig.class);
        startActivity(intent);
        updatedSpinner();
    }
    public void switchCreatedReminder() {
        Intent intent = new Intent(this, newReminderConfig.class);
        startActivity(intent);
    }
    public void switchShowedReminders(){
        Bundle bundleReminders = new Bundle();
        bundleReminders.putString("list",spinner3.getSelectedItem().toString());
        Intent intent = new Intent(this, showRemindersConfig.class);

        intent.putExtra("list",spinner3.getSelectedItem().toString());
        startActivity(intent);
    }
    public void deleteList(){
        if(spinner3.getSelectedItemPosition() == 0) {Toast.makeText(this,"No List was selected", Toast.LENGTH_LONG).show();}
        else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Confirm you want to delete " + getSelectedText() + "list?");
            builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    db.deleteList(selectedList);
                    updatedSpinner();
                }
            });
            builder.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            builder.show();
        }
    }
    public void switchShowLists() {
        Intent intent = new Intent (this, showListsConfig.class);

        if(list.size() <= 1) {Toast.makeText(this,"No lists have been created!", Toast.LENGTH_LONG).show();}
        else
            startActivity(intent);
    }
    public void switchSearchReminder() {
        Intent intent = new Intent (this, searchReminderConfig.class);
        startActivity(intent);
        updatedSpinner();
    }
}

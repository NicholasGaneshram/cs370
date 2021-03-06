package edu.qc.seclass.rlm;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class viewListConfig extends AppCompatActivity {

    Button back;
    Button editButton;
    Button deleteButton;
    Button clearButton;
    String listName;
    EditText listNameInput;
    ArrayAdapter adapter;
    List<List<String>> reminders;
    ListView reminderList;
    DatabaseConfig helper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_list);
        helper = new DatabaseConfig(getApplicationContext());
        listNameInput = (EditText) findViewById(R.id.listNameInputXML);
        String temp = getIntent().getStringExtra("Name");
        listNameInput.setText(temp);

        back = findViewById(R.id.backXML);
        editButton = findViewById(R.id.editButtonXML);
        deleteButton = findViewById(R.id.deleteButtonXML);
        clearButton = findViewById(R.id.clearButtonXML);


        listName = listNameInput.getText().toString();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newName = listNameInput.getText().toString();
                helper.updateList(listName, newName);
                Toast.makeText(viewListConfig.this, "List edited successfully", Toast.LENGTH_LONG).show();
                finish();
            }
        });
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                helper.deleteList(listName);
                Toast.makeText(viewListConfig.this, listName + " list deleted successfully", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        reminders = helper.showReminders(listName);
        final List<String> reminderNames = new ArrayList<>();
        for(List<String> reminderValue:reminders){
            reminderNames.add(reminderValue.get(0));
        }
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_checked, reminderNames);
        reminderList = findViewById(R.id.uncheckedList);
        reminderList.setAdapter(adapter);

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reminderList.setAdapter(adapter);
                Toast.makeText(viewListConfig.this, "Check-off marks cleared", Toast.LENGTH_LONG).show();
            }
        });

        reminderList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String rName = reminderNames.get(position);
                CheckedTextView textView = (CheckedTextView) view;
                textView.setChecked(!textView.isChecked());
                helper.checkReminder(rName);
                adapter.notifyDataSetChanged();
            }
        });
    }
}

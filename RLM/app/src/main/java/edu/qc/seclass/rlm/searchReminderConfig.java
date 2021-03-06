package edu.qc.seclass.rlm;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class searchReminderConfig extends AppCompatActivity {

    String reminderName;
    List<List<String>> reminders;
    List<String> reminderNames;
    ListView searchResults;
    ArrayAdapter<String> adapter;
    EditText reminderNameInput;
    Button searchReminder;
    DatabaseConfig helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_reminder);
        helper = new DatabaseConfig(getApplicationContext());
        searchReminder = findViewById(R.id.searchReminder);
        searchResults = findViewById(R.id.searchResults);
        searchReminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reminderNameInput = (EditText) findViewById(R.id.searchReminderInput);
                reminderName = reminderNameInput.getText().toString();
                if (reminderName.equals("")) {
                    Toast.makeText(searchReminderConfig.this, "Please input a letter or word ", Toast.LENGTH_LONG).show();

                } else {
                    reminders = helper.searchReminders(reminderName);
                    reminderNames = new ArrayList<>();
                    for (List l : reminders)
                        reminderNames.add(l.get(0).toString());
                    Toast.makeText(searchReminderConfig.this, "Results for reminders that begins with " + reminderName + ".", Toast.LENGTH_LONG).show();
                    if (reminders.isEmpty()) {
                        Toast.makeText(searchReminderConfig.this, "There are no reminders that begins with " + reminderName + ".", Toast.LENGTH_LONG).show();
                    } else {
                        showResults();
                    }

                }
                closeKeyboard();
            }

        });

    }
    public void closeKeyboard(){
        View view = this.getCurrentFocus();
        if(view != null){
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
    public void showResults() {
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_activated_1, reminderNames);
        searchResults.setAdapter(adapter);
        searchResults.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String reminderName = parent.getItemAtPosition(position).toString();
                String reminderType = reminders.get(position).get(2);
                String listName = reminders.get(position).get(1);
                Intent intent = new Intent(searchReminderConfig.this, viewReminderConfig.class);
                intent.putExtra("Name", reminderName);
                intent.putExtra("Type", reminderType);
                intent.putExtra("List", listName);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        reminders = helper.searchReminders(reminderName);
        reminderNames = new ArrayList<>();
        for(List l : reminders)
            reminderNames.add(l.get(0).toString());
        showResults();
    }
}

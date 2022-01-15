package edu.qc.seclass.rlm;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import java.util.ArrayList;
import java.util.List;

public class showRemindersConfig extends AppCompatActivity {

    List<List<String>> reminders;
    List<String> reminderNames;
    ListView list;
    ArrayAdapter<String> adapter;
    DatabaseConfig db;
    Spinner spinner;
    String listName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_reminders);

        Bundle bundleReminder = getIntent().getExtras();
        listName = bundleReminder.getString("list");
        updateReminders();
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String reminderName = parent.getItemAtPosition(position).toString();
                String reminderType = reminders.get(position).get(2);
                Intent intent = new Intent(showRemindersConfig.this, viewReminderConfig.class);
                intent.putExtra("Name", reminderName);
                intent.putExtra("Type", reminderType);
                intent.putExtra("List", listName);
                startActivity(intent);
            }
        });
    }
    protected void updateReminders(){
        db = new DatabaseConfig(getApplicationContext());
        spinner = findViewById(R.id.spinner4);
        reminders = db.showReminders(listName);
        reminderNames = new ArrayList<>();
        for(List l : reminders)
            reminderNames.add(l.get(0).toString());

        list = findViewById(R.id.listOfRemindersXML);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_activated_1, reminderNames);
        list.setAdapter(adapter);
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        updateReminders();
    }
}

package edu.qc.seclass.rlm;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class viewReminderConfig extends AppCompatActivity {

    Button back;
    Button editButton;
    Button deleteButton;
    String reminderName, listName, reminderType;
    EditText reminderNameInput, listNameInput, reminderTypeInput;
    DatabaseConfig helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_reminder);

        helper = new DatabaseConfig(getApplicationContext());
        reminderTypeInput = (EditText) findViewById(R.id.reminderTypeInputXML);
        reminderNameInput = (EditText) findViewById(R.id.reminderNameInputXML);
        listNameInput = (EditText) findViewById(R.id.listNameInputXML);

        reminderNameInput.setText(getIntent().getStringExtra("Name"));
        reminderTypeInput.setText(getIntent().getStringExtra("Type"));
        listNameInput.setText(getIntent().getStringExtra("List"));

        back = findViewById(R.id.backXML);
        editButton = findViewById(R.id.editButtonXML);
        deleteButton = findViewById(R.id.deleteButtonXML);


        reminderName = reminderNameInput.getText().toString();
        listName = listNameInput.getText().toString();
        reminderType = reminderTypeInput.getText().toString();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String newName = reminderNameInput.getText().toString();
                String newType = reminderTypeInput.getText().toString();
                helper.updateReminder(reminderName, reminderType, listName, newName);
                helper.updateType(newName, newType);
                Toast.makeText(viewReminderConfig.this, "Reminder edited successfully", Toast.LENGTH_LONG).show();
                finish();
            }
        });
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                helper.deleteReminder(reminderName);
                Toast.makeText(viewReminderConfig.this, reminderName + " reminder deleted successfully", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        listNameInput.setInputType(InputType.TYPE_NULL);
        listNameInput.setKeyListener(null);
    }

}

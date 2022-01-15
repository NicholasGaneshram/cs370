package edu.qc.seclass.rlm;

import android.app.TimePickerDialog;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import java.util.Calendar;
import java.util.List;

public class newReminderConfig extends AppCompatActivity {

    Button back, confirm, time;
    RadioGroup ampm, alertGroup, repeatGroup;
    RadioButton alert, noalert;
    RadioButton am, pm, repeat, noRepeat;
    CheckBox monday, tuesday, wednesday, thursday, friday, saturday, sunday;
    String reminderName;
    String reminderType;
    String listName;
    TextView listSelected;
    EditText reminderNameInput, reminderTypeInput;
    Spinner spinner;
    int day;
    TextView colon;
    EditText hour;
    EditText minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_reminder);

        alertGroup = findViewById(R.id.alertGroup);
        repeatGroup = findViewById(R.id.repeatGroup);
        colon = findViewById(R.id.alertColon);
        hour = findViewById(R.id.hourInput);
        minute = findViewById(R.id.minuteInput);
        ampm = findViewById(R.id.ampmToggle);
        am = findViewById(R.id.amToggle);
        pm = findViewById(R.id.pmToggle);
        repeat = findViewById(R.id.repeatToggle);
        monday = findViewById(R.id.mondayBox);
        tuesday = findViewById(R.id.tuesdayBox);
        wednesday = findViewById(R.id.wednesdayBox);
        thursday = findViewById(R.id.thursdayBox);
        friday = findViewById(R.id.fridayBox);
        saturday = findViewById(R.id.saturdayBox);
        sunday = findViewById(R.id.sundayBox);
        colon.setVisibility(View.GONE);
        hour.setVisibility(View.GONE);
        minute.setVisibility(View.GONE);
        ampm.setVisibility(View.GONE);
        repeatGroup.setVisibility(View.GONE);
        monday.setVisibility(View.GONE);
        tuesday.setVisibility(View.GONE);
        wednesday.setVisibility(View.GONE);
        thursday.setVisibility(View.GONE);
        friday.setVisibility(View.GONE);
        saturday.setVisibility(View.GONE);
        sunday.setVisibility(View.GONE);

        back = findViewById(R.id.backXML);
        confirm = findViewById(R.id.confirmXML);
        time = findViewById(R.id.selecttime);

        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mcurrTime = Calendar.getInstance();
                int calculateHour = mcurrTime.get(Calendar.HOUR_OF_DAY);
                int calulateMinute = mcurrTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(newReminderConfig.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        if(selectedHour>=12){
                            ampm.check(pm.getId());
                            if(selectedHour!=12)selectedHour = selectedHour - 12;
                        }
                        else {
                            ampm.check(am.getId());
                            if(selectedHour == 0) selectedHour+=12;
                        }
                        hour.setText(""+selectedHour);
                        minute.setText(""+selectedMinute);
                    }
                }, calculateHour, calulateMinute, false);
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();
            }
        });
        time.setVisibility(View.GONE);
        alert = findViewById(R.id.alertToggle);
        alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                colon.setVisibility(View.VISIBLE);
                hour.setVisibility(View.VISIBLE);
                minute.setVisibility(View.VISIBLE);
                ampm.setVisibility(View.VISIBLE);
                repeatGroup.setVisibility(View.VISIBLE);
                monday.setVisibility(View.VISIBLE);
                tuesday.setVisibility(View.VISIBLE);
                wednesday.setVisibility(View.VISIBLE);
                thursday.setVisibility(View.VISIBLE);
                friday.setVisibility(View.VISIBLE);
                saturday.setVisibility(View.VISIBLE);
                sunday.setVisibility(View.VISIBLE);
                time.setVisibility(View.VISIBLE);
            }
        });
        noalert = findViewById(R.id.noAlertToggle);
        noalert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                colon.setVisibility(View.GONE);
                hour.setVisibility(View.GONE);
                minute.setVisibility(View.GONE);
                ampm.setVisibility(View.GONE);
                repeatGroup.setVisibility(View.GONE);
                time.setVisibility(View.GONE);
                monday.setVisibility(View.GONE);
                tuesday.setVisibility(View.GONE);
                wednesday.setVisibility(View.GONE);
                thursday.setVisibility(View.GONE);
                friday.setVisibility(View.GONE);
                saturday.setVisibility(View.GONE);
                sunday.setVisibility(View.GONE);
            }
        });

        spinner = findViewById(R.id.newReminderSpin);
        listName = "";
        final DatabaseConfig db = new DatabaseConfig(getApplicationContext());
        List<String> list = db.getLists();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                listName = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                reminderNameInput = (EditText) findViewById(R.id.reminderNameInputXML);
                reminderTypeInput = (EditText) findViewById(R.id.reminderTypeInputXML);
                reminderName = reminderNameInput.getText().toString();//These will return an empty string if nothing was input
                reminderType = reminderTypeInput.getText().toString();// ^

                if(listName.equals("")) {Toast.makeText(newReminderConfig.this,"No List was chosen", Toast.LENGTH_LONG).show();}
                else if(reminderName.equals("")){ Toast.makeText(newReminderConfig.this,"No Reminder was entered", Toast.LENGTH_LONG).show();}
                else if(reminderType.equals("")) {Toast.makeText(newReminderConfig.this,"No Type was entered", Toast.LENGTH_LONG).show();}
                else {

                    db.addReminder(reminderName,reminderType,listName, false);
                    Toast.makeText(newReminderConfig.this, reminderName + " - " + reminderType + " reminder saved to " + listName + " list", Toast.LENGTH_LONG).show();
                    finish();
                }
            }
        });

    }
}

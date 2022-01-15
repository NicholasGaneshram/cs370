package edu.qc.seclass.rlm;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class newListConfig extends AppCompatActivity {

    String listName;
    EditText listNameInput;
    Button createList;
    DatabaseConfig helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_list);

        createList =  findViewById(R.id.confirmXML);
        createList.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                listNameInput = (EditText) findViewById(R.id.nameInput);
                listName = listNameInput.getText().toString();
                if(listName.equals("")) {Toast.makeText(newListConfig.this, "No text was inputed", Toast.LENGTH_LONG).show();}
                else {
                    helper = new DatabaseConfig(getApplicationContext());
                    helper.insertList(listName);
                    Toast.makeText(newListConfig.this, listName + " list created!", Toast.LENGTH_LONG).show();
                    finish();
                }

            }

        });

    }


}
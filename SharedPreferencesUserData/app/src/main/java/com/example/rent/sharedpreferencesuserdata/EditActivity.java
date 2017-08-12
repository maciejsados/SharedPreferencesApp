package com.example.rent.sharedpreferencesuserdata;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.rent.sharedpreferencesuserdata.MainActivity.PREFERENCES_PATH;
import static com.example.rent.sharedpreferencesuserdata.MainActivity.PREFERENCE_NAME;
import static com.example.rent.sharedpreferencesuserdata.MainActivity.PREFERENCE_SURNAME;

public class EditActivity extends AppCompatActivity {

    private EditText name_input;
    private EditText surname_input;

    private Button saveBtn, cancelBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        name_input = (EditText) findViewById(R.id.editor_name);
        surname_input = (EditText) findViewById(R.id.editor_surname);

        saveBtn = (Button) findViewById(R.id.save);
        cancelBtn = (Button) findViewById(R.id.cancel);

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnToMainActivity(RESULT_CANCELED);


            }
        });

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savePreferences();
                returnToMainActivity(RESULT_OK);
            }
        });

        checkIfEmptyFields();

        View.OnKeyListener listener = new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                checkIfEmptyFields();
                return false;
            }
        };

        name_input.setOnKeyListener(listener);
        surname_input.setOnKeyListener(listener);
    }

    private void checkIfEmptyFields() {
        if (name_input.getText().toString().isEmpty() || surname_input.getText().toString().isEmpty()) {
            cancelBtn.setEnabled(false);
        } else {
            cancelBtn.setEnabled(true);
        }
    }

    private void savePreferences() {
        SharedPreferences prefs = getSharedPreferences(PREFERENCES_PATH, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        editor.putString(PREFERENCE_NAME, name_input.getText().toString());
        editor.putString(PREFERENCE_SURNAME, surname_input.getText().toString());

        editor.commit();
    }

    private void returnToMainActivity(int result) {
        Intent i = new Intent();

        setResult(result, i);
        finish();
    }




}

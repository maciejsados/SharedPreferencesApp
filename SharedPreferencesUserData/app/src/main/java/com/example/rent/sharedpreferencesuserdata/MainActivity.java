package com.example.rent.sharedpreferencesuserdata;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static String PREFERENCE_NAME = "key_name";
    public static String PREFERENCE_SURNAME = "key_surname";

    public static final String PREFERENCES_PATH = "our.preferences.file";

    private TextView text_name;
    private TextView text_surname;
    private TextView text_lang;
    private TextView text_country;
    private Spinner language;
    private Spinner country;

    private Button btn;

    private String name, surname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text_name = (TextView) findViewById(R.id.text_name);
        text_surname = (TextView) findViewById(R.id.text_surname);
        text_country = (TextView) findViewById(R.id.text_surname);
        language = (Spinner) findViewById(R.id.spinn_lang);
        country = (Spinner) findViewById(R.id.spinn_country);

        addListenerOnSpinnerItemSelection();


        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startSecondActivity();
            }
        });
    }

    private void addListenerOnSpinnerItemSelection() {
        language.setOnItemSelectedListener(new CustomOnItemSelectedListener());
        country.setOnItemSelectedListener(new CustomOnItemSelectedListener());

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            Toast.makeText(getApplicationContext(), "OK", Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(getApplicationContext(), "Not", Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    protected void onResume() {
        loadSharedPreferences();

        if (name.isEmpty() || surname.isEmpty()) {
            startSecondActivity();
        }

        text_name.setText(name);
        text_surname.setText(surname);

        super.onResume();
    }

    private void loadSharedPreferences() {
        SharedPreferences preferences = getSharedPreferences(PREFERENCES_PATH, MODE_PRIVATE);

        name = preferences.getString(PREFERENCE_NAME, "");
        surname = preferences.getString(PREFERENCE_SURNAME, "");
    }

    private void startSecondActivity() {
        Intent i = new Intent(this, EditActivity.class);

        i.putExtra(PREFERENCE_NAME, name);
        i.putExtra(PREFERENCE_SURNAME, surname);

        startActivityForResult(i, 1);
    }
}

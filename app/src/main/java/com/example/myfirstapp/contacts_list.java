package com.example.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class contacts_list extends AppCompatActivity {

    String name;
    TextView txtV;
    Spinner spinner;
    String[] contacts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_list);

        spinner = findViewById(R.id.Wybor);
        name="";

        txtV = findViewById(R.id.name);
        spinner = findViewById(R.id.Wybor);
        contacts = getResources().getStringArray(R.array.names);
        ArrayAdapter<String> aa = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_spinner_dropdown_item, contacts );
        spinner.setAdapter(aa);

    }

    public void Cancel(View view) {
        /*Intent currentIntent = getIntent();
        name = currentIntent.getStringExtra("USER_NAME");
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        Bundle extras = new Bundle();
        extras.putInt("FLAG", 1);
        extras.putString("USER_NAME", name);
        intent.putExtras(extras);
        startActivity(intent);*/
        finish();
    }

    public void Ok(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        int position = spinner.getSelectedItemPosition();
        name = contacts[position];
        intent.putExtra("userName", name);
        setResult(1,intent);
        finish();
        //startActivity(intent);
    }
}



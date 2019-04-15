package com.example.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class sounds_list extends AppCompatActivity {


    boolean checked;
    int soundID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sounds_list);

        soundID = R.raw.mario;
        checked = false;
    }
    public void ok (View view ) {
        Intent intent = new Intent();
        intent.putExtra("SOUND_ID", soundID);
        setResult(1,intent);
        finish();
    }

    public void cancel (View view) {
        finish();
    }
    public void choose(View view) {
        checked = ((RadioButton) view).isChecked();

        if(checked) {
            switch (view.getId()) {
                case R.id.Sound1:
                    soundID = R.raw.mario;
                    break;
                case R.id.Sound2:
                    soundID = R.raw.ring01;
                    break;
                case R.id.Sound3:
                    soundID = R.raw.ring02;
                    break;
                case R.id.Sound4:
                    soundID = R.raw.ring03;
                    break;
                case R.id.Sound5:
                    soundID = R.raw.ring04;
                    break;
                case R.id.Sound6:
                    soundID = R.raw.ringd;
                    break;
            }
        }
    }
}

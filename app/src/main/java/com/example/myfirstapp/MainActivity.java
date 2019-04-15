package com.example.myfirstapp;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mp;
    int soundID;
    String currentName ;
    TextView txtV ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        txtV = findViewById(R.id.name);
        soundID =0;
        setSupportActionBar(toolbar);

        FloatingActionButton floatingActionButton = findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(soundID != 0) {
                    if (mp == null) {
                        mp = MediaPlayer.create(MainActivity.this, soundID);
                        mp.start();
                    }else{
                        mp.stop();
                        mp = null;
                    }
                }else {
                    Toast.makeText(getApplicationContext(), "Choose sound", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void changeText() {
        txtV.setText(currentName);
        Random rand = new Random() ;
        int avatarID = rand.nextInt(4)+1 ;

        //Toast.makeText(getApplicationContext(),""+avatarID,Toast.LENGTH_SHORT).show();
        switch(avatarID){
            case 1:
                avatarID = R.drawable.avatar_1;
                break;
            case 2:
                avatarID = R.drawable.avatar_2;
                break;
            case 3:
                avatarID = R.drawable.avatar_3;
                break;
            case 4:
                avatarID = R.drawable.avatar_4;
                break;
            case 5:
                avatarID = R.drawable.avatar_5;
                break;
            default:
                avatarID = R.drawable.avatar_1;
                Toast.makeText(getApplicationContext(),""+avatarID,Toast.LENGTH_SHORT).show();
        }
        ImageView imgV = findViewById(R.id.image_v);
        imgV.setImageResource(avatarID);

    }

    public void changeContact(View view) {

        Intent intent1 = new Intent(getApplicationContext(), contacts_list.class);
        startActivityForResult(intent1, 1);
    }

    public void changeSound(View view) {
        Intent intent2 = new Intent(getApplicationContext(), sounds_list.class);
        startActivityForResult(intent2, 2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == 1 && resultCode==1){
            currentName = data != null ? data.getStringExtra("userName") : null;


            changeText();
        }else if(requestCode==2 && resultCode==1){
            soundID = data != null ? data.getIntExtra("SOUND_ID", 0) : 0;
        }
    }
}

package com.example.intelligentdaily;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ActivityAnasayfa extends Activity {

    Button btnCalendar;
    Button btnCamera;
    Button btnHealth;
    Button btnSport;
    Button btnGps;
    Button btnShare;
    Button btnNote;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference myRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anasayfa);

        btnCalendar = (Button) findViewById(R.id.button_calendar);
        btnCamera = (Button) findViewById(R.id.button_camera);
        btnHealth = (Button) findViewById(R.id.button_health);
        btnSport = (Button) findViewById(R.id.button_sport);
        btnGps = (Button) findViewById(R.id.button_gps);
        btnShare = (Button) findViewById(R.id.button_share);
        btnNote = (Button) findViewById(R.id.button_note);

        btnCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        btnHealth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        btnSport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        btnGps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        btnNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
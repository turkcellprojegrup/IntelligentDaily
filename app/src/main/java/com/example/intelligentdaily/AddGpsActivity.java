package com.example.intelligentdaily;


import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddGpsActivity extends Activity {

    Button findAdressBtn;
    Button gotoNotesBtn;
    Button gotoEtkinlikBtn;
    Button gotoHotelBtn;
    Button gotoTrafficBtn;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_gps);

        findAdressBtn = (Button) findViewById(R.id.find_adress_btn);
        gotoNotesBtn = (Button) findViewById(R.id.go_to_notes_btn);
        gotoEtkinlikBtn = (Button) findViewById(R.id.goto_etkinlik_btn);
        gotoHotelBtn = (Button) findViewById(R.id.goto_hotel_btn);
        gotoTrafficBtn = (Button) findViewById(R.id.goto_traffic_btn);

        findAdressBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addGps();
            }
        });
        gotoNotesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        gotoEtkinlikBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        gotoHotelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        gotoTrafficBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

    private void addGps() {

        firebaseDatabase = FirebaseDatabase.getInstance();

        myRef = firebaseDatabase.getReference().child("Adres");

        String notesId = myRef.push().getKey();

        String findAdress = findAdressBtn.getText().toString();

        if (findAdress.length() > 0) {
            myRef.child(notesId).child("adresBilgisi").setValue(findAdress);
            showDialog("İşlem başarılı", "Notunuz kaydedildi");
        } else {
            showDialog("İşlem başarısız", "Not alanı boş bırakılamaz!");
        }
        findAdressBtn.setText("");
    }
    private void showDialog (String title, String message){
        final AlertDialog.Builder builder = new AlertDialog.Builder(AddGpsActivity.this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setNegativeButton("TAMAM", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.show(); //kullanıcı görebilsin diye eklenir

    }
}






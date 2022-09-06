package com.example.intelligentdaily;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class AddSportActivity extends AppCompatActivity {

    EditText userSport;
    Button addSportsBtn;
    Button gotoNotePage;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference myRef;

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate (savedInstanceState);
        setContentView(R.layout.activity_add_sport);

        userSport=(EditText) findViewById(R.id.user_sport_button);
        addSportsBtn=(Button) findViewById(R.id.add_sports_btn);
        gotoNotePage=(Button) findViewById(R.id.go_to_notes_btn);

        addSportsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSports();
            }
        });

        gotoNotePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void addSports() {

        firebaseDatabase = FirebaseDatabase.getInstance();

        myRef=firebaseDatabase.getReference().child("SporBilgilerim");

        String notesId = myRef.push().getKey();

        String userSport = addSportsBtn.getText().toString();

        if (userSport.length() > 0) {
            myRef.child(notesId).child("sporAdi").setValue(userSport);
            showDialog("İşlem başarılı", "Notunuz kaydedildi");

        } else {
            showDialog("İşlem başarısız", "Not alanı boş bırakılamaz!");
        }
        addSportsBtn.setText("");
    }


    private void showDialog (String title, String message){
    final AlertDialog.Builder builder = new AlertDialog.Builder(AddSportActivity.this);
    builder.setTitle(title);
    builder.setMessage(message);
    builder.setNegativeButton("TAMAM", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }

        });

    builder.show();

    }
}
package com.example.intelligentdaily;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddHealthActivity extends Activity {

    EditText userNotEt;
    Button addHealthBtn;
    Button gotoNotePage;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference myRef;


    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate (savedInstanceState);
        setContentView(R.layout.activity_add_health);

        userNotEt=(EditText) findViewById(R.id.user_notes_et);
        addHealthBtn=(Button) findViewById(R.id.add_health_btn);
        gotoNotePage=(Button) findViewById(R.id.go_to_notes_btn);

        addHealthBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addHealth();
            }
        });

        gotoNotePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void addHealth() {

        firebaseDatabase = FirebaseDatabase.getInstance();

        myRef = firebaseDatabase.getReference().child("Sağlık bilgilerim");

        String notesId = myRef.push().getKey();

        String userNote = userNotEt.getText().toString();

        if (userNote.length() > 0) {
            myRef.child(notesId).child("saglikBilgisi").setValue(userNote);
            showDialog("İşlem başarılı", "Notunuz kaydedildi!");

        } else {
            showDialog("İşlem başarısız", "Not alanı boş bırakılamaz!");
        }
        userNotEt.setText("");
    }


    private void showDialog (String title, String message){
        final AlertDialog.Builder builder = new AlertDialog.Builder(AddHealthActivity.this);
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

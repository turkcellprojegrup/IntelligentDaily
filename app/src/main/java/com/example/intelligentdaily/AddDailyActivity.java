package com.example.intelligentdaily;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddDailyActivity extends AppCompatActivity {

    EditText userNotEt;
    Button addNoteBtn;
    Button gotoNotePage;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference myRef;


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_daily);

        userNotEt=(EditText)findViewById(R.id.user_notes_et);
        addNoteBtn=(Button) findViewById(R.id.add_notes_btn);
        gotoNotePage=(Button) findViewById(R.id.go_to_notes_btn);


        addNoteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { addNote();
            }
        });

        gotoNotePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
    private void addNote(){

        firebaseDatabase = FirebaseDatabase.getInstance();

        myRef=firebaseDatabase.getReference().child("Gunlugum");

        String notesId = myRef.push().getKey();

        String userNote=userNotEt.getText().toString();

        if (userNote.length()>0){
            myRef.child(notesId).child("gunluk").setValue(userNote);
            showDialog("İşlem başarılı", "Günlüğünüz kaydedildi");

        }
        else {
            showDialog("İşlem başarısız", "Not alanı boş bırakılamaz!");
        }
        userNotEt.setText("");
    }



    private void showDialog (String title, String message){
        final AlertDialog.Builder builder = new AlertDialog.Builder(AddDailyActivity.this);
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

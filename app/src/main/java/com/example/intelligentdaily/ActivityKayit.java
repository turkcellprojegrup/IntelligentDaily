package com.example.intelligentdaily;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ActivityKayit extends Activity {

    EditText kayitİsimSoyisim;
    EditText kayitEmail;
    EditText kayitGoogleHesabi;
    EditText kayitAdres;
    EditText kayitYasDogumTarihi;
    EditText kayitCinsiyet;
    Button kayitButton;
    Button loginBtn;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference myRef;


    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate (savedInstanceState);
        setContentView(R.layout.activity_kayit);

        kayitİsimSoyisim=(EditText) findViewById(R.id.kayit_isim_soyisim);
        kayitEmail=(EditText) findViewById(R.id.kayit_email);
        kayitGoogleHesabi=(EditText) findViewById(R.id.kayit_google_hesabi);
        kayitAdres=(EditText) findViewById(R.id.kayit_adres);
        kayitYasDogumTarihi =(EditText) findViewById(R.id.kayit_yas_dogumtarihi);
        kayitCinsiyet=(EditText) findViewById(R.id.kayit_cinsiyet);
        kayitButton=(Button) findViewById(R.id.go_to_kayit_button);
        loginBtn=(Button) findViewById(R.id.login_button);

        kayitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { onBackPressed();
            }
        });

    }
}

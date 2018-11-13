package com.example.ahmed.vecamanja;


import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.security.PublicKey;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText probniBroj;
    Random rnd;
    int broj;
    int brojac;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rnd = new Random();
        probniBroj = (EditText) findViewById(R.id.probniBroj);


        broj = rnd.nextInt(20)+1;
    }

    public void restart(){

        broj = rnd.nextInt(20)+1;
        brojac=0;
    }

    public void dugme(View view) {

        brojac++;


        String userBrojString = probniBroj.getText().toString();
        if (userBrojString.matches("")) {
            Toast.makeText(this, "Unesi broj", Toast.LENGTH_SHORT).show();
            return;
        }

        int userBrojInteger = Integer.parseInt(userBrojString);


        if (broj > userBrojInteger) {
            Toast.makeText(this, "Broj je veci", Toast.LENGTH_LONG).show();
            probniBroj.setText("");
        } else if (broj < userBrojInteger) {
            Toast.makeText(this, "Broj je manji", Toast.LENGTH_LONG).show();
            probniBroj.setText("");
        } else {
            Toast.makeText(this, "Pogodili ste broj. Trebalo vam je " + brojac + " pokusaja", Toast.LENGTH_LONG).show();
            probniBroj.setText("");
            restart();
        }

    }
}

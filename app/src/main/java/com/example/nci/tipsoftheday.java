package com.example.nci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class tipsoftheday extends AppCompatActivity {

    Random random = new Random();
    TextView textQuote;
    Button nextQuote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipsoftheday);


        textQuote = findViewById(R.id.textView);
        nextQuote = findViewById(R.id.button);

        nextQuote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayQuote();
            }
        });
    }

    public void displayQuote(){
        int randNum = random.nextInt((14+1)-1)+1;
        String randQuote = "";

        switch (randNum){
            case 1:
                randQuote = getString(R.string.Quote1);
                break;
            case 2:
                randQuote = getString(R.string.Quote2);
                break;
            case 3:
                randQuote = getString(R.string.Quote3);
                break;
            case 4:
                randQuote = getString(R.string.Quote4);
                break;
            case 5:
                randQuote = getString(R.string.Quote5);
                break;
            case 6:
                randQuote = getString(R.string.Quote6);
                break;
            case 7:
                randQuote = getString(R.string.Quote7);
                break;
            case 8:
                randQuote = getString(R.string.Quote8);
                break;
            case 9:
                randQuote = getString(R.string.Quote9);
                break;
            case 10:
                randQuote = getString(R.string.Quote10);
                break;
            case 11:
                randQuote = getString(R.string.Quote11);
                break;
            case 12:
                randQuote = getString(R.string.Quote12);
                break;
            case 13:
                randQuote = getString(R.string.Quote13);
                break;
            case 14:
                randQuote = getString(R.string.Quote14);
                break;
            case 15:
                randQuote = getString(R.string.Quote15);
                break;
            case 16:
                randQuote = getString(R.string.Quote16);
                break;
            case 17:
                randQuote = getString(R.string.Quote17);
                break;
            case 18:
                randQuote = getString(R.string.Quote18);
                break;
            case 19:
                randQuote = getString(R.string.Quote19);
                break;
            case 20:
                randQuote = getString(R.string.Quote20);
                break;

        }
        textQuote.setText(randQuote);


    }
}

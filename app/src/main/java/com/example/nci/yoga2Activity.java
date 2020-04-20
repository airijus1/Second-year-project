package com.example.nci;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;
import android.widget.Toast;

public class yoga2Activity extends AppCompatActivity {

    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga2);

        t1 = findViewById(R.id.textView);


        final CountDownTimer countDownTimer;

        countDownTimer = new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                t1.setText(millisUntilFinished / 1000 + " ");


            }


            @Override
            public void onFinish() {
                Intent intent = new Intent(yoga2Activity.this, yoga3Activity.class);
                startActivity(intent);


                t1.setText("GO");
                Toast.makeText(yoga2Activity.this, "G0", Toast.LENGTH_SHORT).show();


            }
        };

        countDownTimer.start();


    }

}




package com.example.nci;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class yoga1Activity extends AppCompatActivity {

    //Declare a variable to hold count down timer's paused status
    private boolean isPaused = false;
    //Declare a variable to hold count down timer's paused status
    private boolean isCanceled = false;

    //Declare a variable to hold CountDownTimer remaining time
    private long timeRemaining = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga1);


        //Get reference of the XML layout's widgets
        final TextView tView = (TextView) findViewById(R.id.textView2);

        final ImageButton btnPause = (ImageButton) findViewById(R.id.btn_pause);
        final ImageButton btnResume = (ImageButton) findViewById(R.id.btn_resume);
        final Button btnCancel = (Button) findViewById(R.id.btn_cancel);

        //Initially disabled the pause, resume and cancel button
        btnPause.setEnabled(false);
        btnResume.setEnabled(false);
        btnCancel.setEnabled(false);





        isPaused = false;
        isCanceled = false;



        btnResume.setEnabled(false);
        //Enabled the pause and cancel button
        btnPause.setEnabled(true);
        btnPause.setVisibility(View.VISIBLE);
        btnCancel.setEnabled(true);

        CountDownTimer timer;
        long millisInFuture = 20000; //30 seconds
        long countDownInterval = 1000; //1 second


        //Initialize a new CountDownTimer instance
        timer = new CountDownTimer(millisInFuture,countDownInterval){
            public void onTick(long millisUntilFinished){
                //do something in every tick
                if(isPaused || isCanceled)
                {
                    //If the user request to cancel or paused the
                    //CountDownTimer we will cancel the current instance
                    cancel();
                }
                else {
                    //Display the remaining seconds to app interface
                    //1 second = 1000 milliseconds
                    tView.setText("" + millisUntilFinished / 1000);
                    //Put count down timer remaining time in a variable
                    timeRemaining = millisUntilFinished;
                }
            }
            public void onFinish(){
                //Do something when count down finished
                tView.setText("Done");
                Intent intent = new Intent(yoga1Activity.this, yoga2Activity.class);
                startActivity(intent);



            }
        }.start();


        //Set a Click Listener for pause button
        btnPause.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //When user request to pause the CountDownTimer
                isPaused = true;

                //Enable the resume and cancel button
                btnResume.setEnabled(true);
                btnResume.setVisibility(View.VISIBLE);
                btnCancel.setEnabled(true);
                //Disable the start and pause button

                btnPause.setEnabled(false);
                btnPause.setVisibility(View.INVISIBLE);
            }
        });

        //Set a Click Listener for resume button
        btnResume.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Disable the start and resume button

                btnResume.setEnabled(false);
                btnResume.setVisibility(View.INVISIBLE);
                //Enable the pause and cancel button
                btnPause.setEnabled(true);
                btnPause.setVisibility(View.VISIBLE);
                btnCancel.setEnabled(true);

                //Specify the current state is not paused and canceled.
                isPaused = false;
                isCanceled = false;

                //Initialize a new CountDownTimer instance
                long millisInFuture = timeRemaining;
                long countDownInterval = 1000;
                new CountDownTimer(millisInFuture, countDownInterval){
                    public void onTick(long millisUntilFinished){
                        //Do something in every tick
                        if(isPaused || isCanceled)
                        {
                            //If user requested to pause or cancel the count down timer
                            cancel();
                        }
                        else {
                            tView.setText("" + millisUntilFinished / 1000);
                            //Put count down timer remaining time in a variable
                            timeRemaining = millisUntilFinished;
                        }
                    }

                    public void onFinish(){
                        //Do something when count down finished
                        tView.setText("Done");
                        Intent intent = new Intent(yoga1Activity.this, yoga2Activity.class);
                        startActivity(intent);

                        //Disable the pause, resume and cancel button
                        btnPause.setEnabled(false);
                        btnResume.setEnabled(false);
                        btnCancel.setEnabled(false);
                        //Enable the start button


                    }
                }.start();

                //Set a Click Listener for cancel/stop button
                btnCancel.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        //When user request to cancel the CountDownTimer
                        isCanceled = true;

                        //Disable the cancel, pause and resume button
                        btnPause.setEnabled(false);
                        btnResume.setEnabled(false);
                        btnCancel.setEnabled(false);

                        //Notify the user that CountDownTimer is canceled/stopped
                        tView.setText("CountDownTimer Canceled/stopped.");
                    }
                });
            }
        });

        //Set a Click Listener for cancel/stop button
        btnCancel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //When user request to cancel the CountDownTimer
                isCanceled = true;

                //Disable the cancel, pause and resume button
                btnPause.setEnabled(false);
                btnResume.setEnabled(false);
                btnCancel.setEnabled(false);
                //Enable the start button


                //Notify the user that CountDownTimer is canceled/stopped
                tView.setText("CountDownTimer Canceled/stopped.");
            }
        });

    }



}












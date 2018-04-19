package com.example.edison.myapplication;

import android.content.DialogInterface;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button mProcess;
    private SeekBar mSeekBar;
    private int speed;
    private TextView mWords;
    private EditText mWordsGiven;
    private long mSeconds;
    private CountDownTimer countDownTimer;
    private boolean isRunning;
    private  List<String> myList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mProcess = findViewById(R.id.button2);
        mWords = findViewById(R.id.words);
        mWordsGiven = findViewById(R.id.wordsGiven);



        mSeekBar = findViewById(R.id.seekBar2);
        mSeekBar.setMax(100);
        mSeekBar.setMin(5);
        speed =(100 - mSeekBar.getProgress()) * 10;

    }

    public void startProcessing(View view) {



        String theText = mWordsGiven.getText().toString();
        myList = new ArrayList<String>(Arrays.asList(mWordsGiven.getText().toString().split(" ")));
        mSeconds = myList.size() * speed ;

        countDownTimer = new CountDownTimer(mSeconds, speed) {
            @Override
            public void onTick(long millisUntilFinished) {
                mSeconds = millisUntilFinished;
                updateWords();

            }

            @Override
            public void onFinish() {
                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch(which){
                        case DialogInterface.BUTTON_POSITIVE:

                            break;
                        case DialogInterface.BUTTON_NEGATIVE:

                            break;}
                    }
                };
            }
        }.start();
        isRunning = true;

    }

    private void updateWords() {
        myList = new ArrayList<String>(Arrays.asList(mWordsGiven.getText().toString().split(" ")));
        Collections.reverse(myList);
        int seconds =(int) mSeconds / speed;


        mWords.setText(myList.get(seconds));
        //Toast.makeText(this, Integer.valueOf(myList.size()), Toast.LENGTH_SHORT).show();
    }
}

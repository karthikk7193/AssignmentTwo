package com.example.assignment2;
/*
 * CSE41246 - Android Java Fundamentals
 * Fall 2019
 * Assignment Two
 * Kumar, Karthik
 */


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int minNumber = 1;
    private int maxNumber = 6;

    private TextView resultTextView = null;
    private EditText minEditText = null;
    private EditText maxEditText = null;
    private Button generateButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.resultTextView = (TextView) findViewById(R.id.textViewResult);
        this.minEditText = (EditText) findViewById(R.id.editTextMin);
        this.maxEditText = (EditText) findViewById(R.id.editTextMax);

        setDefaultMinMax();

        this.generateButton = (Button) findViewById(R.id.buttonGen);
        this.generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchValuesFromFields();
                generateRandomNumber();
            }
        });
    }

    private void setDefaultMinMax() {
        minEditText.setText(Integer.toString(minNumber));
        maxEditText.setText(Integer.toString(maxNumber));
    }

    private void fetchValuesFromFields() {
        this.minNumber =  Integer.parseInt(this.minEditText.getText().toString());
        this.maxNumber =  Integer.parseInt(this.maxEditText.getText().toString());
    }

    private void generateRandomNumber() {
        int randomNum = getRandomInt(minNumber, maxNumber);
        String randomNumStr = Integer.toString(randomNum);
        resultTextView.setText(randomNumStr);
    }

    private int getRandomInt(int min, int max) {
        Random rand = new Random();
        return rand.nextInt(max - min + 1) + min;
    }
}


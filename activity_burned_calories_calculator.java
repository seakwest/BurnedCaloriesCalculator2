package com.evaristo.burnedcaloriescalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;

public class activity_burned_calories_calculator extends AppCompatActivity {

    //variable declaration for widgts
    private EditText weightEditText;
    private EditText nameEditText;
    private TextView milesTextView;
    private TextView caloriesTextView;
    private TextView bMITextView;
    private SeekBar milesSeekBar;
    private Spinner feetSpinner;
    private Spinner inchesSpinner;

    //instance variables
    private int weight;
    private String weightString;
    private int miles;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get references to widgets
        weightEditText = (EditText) findViewById(R.id.weightEditText);
        nameEditText = (EditText) findViewById(R.id.nameEditText);
        milesTextView = (TextView) findViewById(R.id.milesTextView);
        caloriesTextView = (TextView) findViewById(R.id.caloriesTextView);
        bMITextView = (TextView) findViewById(R.id.bMITextView);
        milesSeekBar = (SeekBar) findViewById(R.id.milesSeekBar);
        feetSpinner = (Spinner) findViewById(R.id.feetSpinner);
        inchesSpinner = (Spinner) findViewById(R.id.inchesSpinner);

        //set the listeners

        weightEditText.setOnEditorActionListener(this);
        weightEditText.setOnKeyListener(this);
        milesSeekBar.setOnSeekBarChangeListener(this);
        milesSeekBar.setOnKeyListener(this);
        feetSpinner.setOnItemSelectedListener(this);
        inchesSpinner.setOnItemSelectedListener(this);



        //event handler for editor action
    public void calculateAndDisplay() {
        // get the weight amount
        weightString = weightEditText .getText().toString();
        float weight;
        if (weightString.equals("")) {
            weight = 0;
        }
            else {
             weight = Float.parseFloat(weightString);
        }

        }

        //get seekbar progress in miles
        int progress = milesSeekBar.getProgress();
        miles = (float) progress/10;

        //array adapter for feet spinner
        ArrayAdapter feetAdapter = ArrayAdapter.createFromResource(this, R.array.feet_Array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        feetSpinner.setAdapter(feetAdapter);

        //adapter for inches
        ArrayAdapter incesAdapter = ArrayAdapter.createFromResource(this, R.array, android.R.layout.simple_spinner_item);
        adapter.setDropDowViewResource(android.R.layout.simple_spinner_dropdown_item);
        inchesSPinner.setAdapter(inchesAdapter);








    }
}

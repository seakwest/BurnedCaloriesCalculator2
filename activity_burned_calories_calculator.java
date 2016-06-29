package com.evaristo.burnedcaloriescalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
    private float caloriesBurned;
    private int bmi;
    private int feet;
    private int inches;
    private int height;






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
        weightString = weightEditText.getText().toString();
        float weight;
        if (weightString.equals("")) {
            weight = 0;
        } else {
            weight = Float.parseFloat(weightString);
        }


        //get seekbar progress in miles
        int progress = milesSeekBar.getProgress();
        miles =  progress / 10;

        //array adapter for feet spinner
        ArrayAdapter feetAdapter = ArrayAdapter.createFromResource(this, R.array.feet_Array, android.R.layout.simple_spinner_item);
        feetAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        feetSpinner.setAdapter(feetAdapter);

        //adapter for inches
        ArrayAdapter inchesAdapter = ArrayAdapter.createFromResource(this, R.array, android.R.layout.simple_spinner_item);
        inchesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        inchesSpinner.setAdapter(inchesAdapter);







        /*//calculate calories
        caloriesBurned = 0.75 * weight * miles;
        bmi = weight * 703 / 12 * feetSpinner + inchesSpinner * (12*feet*inches);
        */




    }





    //seek bar event handlers
    @Override
    public void onStartTrackingTouch(SeekBar mileSeekBar) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onProgressChanged(SeekBar mileSeekBar, int progress,
                                  boolean fromUser) {
        milesTextView.setText(progress + 1);
    }

    @Override
    public void onStopTrackingTouch(SeekBar mileSeekBar) {
        calculateAndDisplay();
    }


    //Event Handlers for spinners
    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position,
                               long id) {
        height = position;
        calculateAndDisplay();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // Do nothing
    }







}

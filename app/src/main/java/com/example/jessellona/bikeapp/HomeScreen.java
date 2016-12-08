package com.example.jessellona.bikeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
    }

    //------------------------------goToCalcTools(View view)------------------------------
    // Description: Called when the Calculator tools button is pressed. Opens the
    // calculator tools activity
    //------------------------------------------------------------------------------------
    public void goToCalcTools(View view)
    {
        Intent intent = new Intent(this, CalcTools.class);
        startActivity(intent);
    }
}

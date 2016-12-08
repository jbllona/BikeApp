package com.example.jessellona.bikeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

public class CalcTools extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_tools);
    }

    public void goToChainWrap(View view)
    {
        Intent intent = new Intent(this, ChainWrap.class);
        startActivity(intent);
    }
}

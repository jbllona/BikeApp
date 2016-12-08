package com.example.jessellona.bikeapp;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.Shape;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ChainWrap extends AppCompatActivity {

    EditText[] inputData = new EditText[4];


    ShapeDrawableView shapeDrawableView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chain_wrap);

        inputData[0] = (EditText) findViewById(R.id.BigRing);
        inputData[1] = (EditText) findViewById(R.id.SmallRing);
        inputData[2] = (EditText) findViewById(R.id.BigCog);
        inputData[3] = (EditText) findViewById(R.id.SmallCog);

        inputData[0].setOnTouchListener(new View.OnTouchListener()
        {
            public boolean onTouch(View arg0, MotionEvent arg1)
            {
                selectBigRing();
                return false;
            }
        });

        inputData[1].setOnTouchListener(new View.OnTouchListener()
        {
            public boolean onTouch(View arg0, MotionEvent arg1)
            {
                selectSmallRing();
                return false;
            }
        });

        inputData[2].setOnTouchListener(new View.OnTouchListener()
        {
           public boolean onTouch(View arg0, MotionEvent arg1)
           {
               selectBigCog();
               return false;
           }
        });

        inputData[3].setOnTouchListener(new View.OnTouchListener()
        {
            public boolean onTouch(View arg0, MotionEvent arg1)
            {
                selectSmallCog();
                return false;
            }
        });

        inputData[3].setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                    calculate(v);
                    return true;

            }
        });
        ViewGroup mainView = (ViewGroup) findViewById(R.id.activity_chain_wrap);
        shapeDrawableView = new ShapeDrawableView(this);
        mainView.addView(shapeDrawableView);


    }

    public void selectBigRing()
    {
        shapeDrawableView.selectBigRing();
        shapeDrawableView.invalidate();
    }

    public void selectSmallRing()
    {
        shapeDrawableView.selectSmallRing();
        shapeDrawableView.invalidate();
    }

    public void selectBigCog()
    {
        shapeDrawableView.selectBigCog();
        shapeDrawableView.invalidate();
    }

    public void selectSmallCog()
    {
        shapeDrawableView.selectSmallCog();
        shapeDrawableView.invalidate();
    }

    public void calculate(View view)
    {
        /*
         * EditText objects were created in an array (inputData) so that I could then parse them
         * into ints within a loop for simplicity's sake
         */

        /*
         * like the inputData, the numeric data is in an array for simplicity's sake
         *  key:
         *  0 = big ring
         *  1 = small ring
         *  2 = big cog
         *  3 = small cog
         */

            int[] numericData = new int[4];
            for (int i = 0; i < 4; i++) {
                try {
                    if (!inputData[i].getText().toString().equals(""))
                        numericData[i] = Integer.parseInt(inputData[i].getText().toString());
                } catch (Exception e) {
                    numericData[i] = 0; // data set to 0 by default. (may be usefull for single ring setups)
                }
                //if(numericData[i] < 0) throw new Exception();
            }
            TextView textView = (TextView) findViewById(R.id.solution);
            int result = (numericData[0] - numericData[1]) + (numericData[2]-numericData[3]);
            String answer;
            if(numericData[0] < numericData[1])
            {
                answer = "The smallest chainring must be less than or equal to the size of the bigest chainring";
            }
            else if(numericData[2] <= numericData[3])
            {
                answer = "The smallest cog must be smaller than the largest cog";
            }
            else if(numericData[2] < 1 || numericData[3] < 1)
            {
                answer = "Please enter values for the both the biggest and smallest cog";
            }
            answer = Integer.toString(result);
            textView.setText(answer);
    }
    
}
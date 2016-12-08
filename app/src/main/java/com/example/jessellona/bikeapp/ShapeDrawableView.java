package com.example.jessellona.bikeapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class ShapeDrawableView extends View {

    int startX, startY, endX, endY;
    Paint paint = new Paint();

    private List<ShapeDrawable> shapeDrawables =
            new ArrayList<ShapeDrawable>();

    public ShapeDrawableView(Context context) {
        super(context);
        paint.setStrokeWidth(5);
        /*
         * create small chainring
         */
        Shape smallRing = new OvalShape();
        ShapeDrawable smallRingDrawable = new ShapeDrawable(smallRing);
        smallRingDrawable.setBounds(975, 675, 1125, 825);
        smallRingDrawable.getPaint().setStyle(Paint.Style.STROKE);
        smallRingDrawable.getPaint().setStrokeWidth(5);

        /*
         * create large chainring
         */
        Shape bigRing = new OvalShape();
        ShapeDrawable bigRingDrawable = new ShapeDrawable(bigRing);
        bigRingDrawable.setBounds(925, 625, 1175, 875);
        bigRingDrawable.getPaint().setStyle(Paint.Style.STROKE);
        bigRingDrawable.getPaint().setStrokeWidth(5);

        /*
         * create big cog
         */
        Shape bigCog = new OvalShape();
        ShapeDrawable bigCogDrawable = new ShapeDrawable(bigCog);
        bigCogDrawable.setBounds(280, 680, 420, 820);
        bigCogDrawable.getPaint().setStyle(Paint.Style.STROKE);
        bigCogDrawable.getPaint().setStrokeWidth(5);

        /*
         * create small cog
         */
        Shape smallCog = new OvalShape();
        ShapeDrawable smallCogDrawable = new ShapeDrawable(smallCog);
        smallCogDrawable.setBounds(330, 730, 370, 770);
        smallCogDrawable.getPaint().setStyle(Paint.Style.STROKE);
        smallCogDrawable.getPaint().setStrokeWidth(5);

        /*
         * create upper jockey wheel
         */
        //Shape upperJockey= new OvalShape();
        ShapeDrawable upperJockey = new ShapeDrawable(new OvalShape());
        upperJockey.setBounds(315, 830, 345, 860);
        upperJockey.getPaint().setStyle(Paint.Style.STROKE);
        upperJockey.getPaint().setStrokeWidth(5);

        /*
         * create lower jockey wheel
         */
        ShapeDrawable lowerJockey = new ShapeDrawable(new OvalShape());
        lowerJockey.setBounds(320, 895, 350, 925);
        lowerJockey.getPaint().setStyle(Paint.Style.STROKE);
        lowerJockey.getPaint().setStrokeWidth(5);

        /*
         * add all of the drawables
         */
        shapeDrawables.add(lowerJockey);
        shapeDrawables.add(upperJockey);
        shapeDrawables.add(smallCogDrawable);
        shapeDrawables.add(bigCogDrawable);
        shapeDrawables.add(bigRingDrawable);
        shapeDrawables.add(smallRingDrawable);
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(350, 680, 1050, 625, paint); // upper chain
        canvas.drawLine(335, 925, 1050, 875, paint); // lower chain
        canvas.drawLine(320, 910, 345, 845, paint); // upper jockey to lower jockey
        canvas.drawLine(345, 840, 305, 805, paint); // big cog to upper jockey
        for(ShapeDrawable shapeDrawable: shapeDrawables) {
            shapeDrawable.draw(canvas);
        }

    }

    public void selectBigRing()
    {
        for(ShapeDrawable shapeDrawable: shapeDrawables)
        {
            shapeDrawable.getPaint().setColor(Color.BLACK);
        }
        shapeDrawables.get(4).getPaint().setColor(Color.RED);
    }

    public void selectSmallRing()
    {
        for(ShapeDrawable shapeDrawable: shapeDrawables)
        {
            shapeDrawable.getPaint().setColor(Color.BLACK);
        }
        shapeDrawables.get(5).getPaint().setColor(Color.RED);
    }

    public void selectBigCog()
    {
        for(ShapeDrawable shapeDrawable: shapeDrawables)
        {
            shapeDrawable.getPaint().setColor(Color.BLACK);
        }
        shapeDrawables.get(3).getPaint().setColor(Color.RED);
    }

    public void selectSmallCog()
    {
        for(ShapeDrawable shapeDrawable: shapeDrawables)
        {
            shapeDrawable.getPaint().setColor(Color.BLACK);
        }
        shapeDrawables.get(2).getPaint().setColor(Color.RED);
    }
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//
//        if (event.getAction() == MotionEvent.ACTION_DOWN) {
//            startX = (int)event.getX();
//            startY = (int)event.getY();
//            return true;
//        } else if (event.getAction() == MotionEvent.ACTION_UP){
//            endX = (int)event.getX();
//            endY = (int)event.getY();
//            if (startX > endX) {
//                int tmp = startX;
//                startX = endX;
//                endX = tmp;
//            }
//            if (startY > endY) {
//                int tmp = startY;
//                startY = endY;
//                endY = tmp;
//            }
//
//            Shape shape = new RectShape();
//            ShapeDrawable shapeDrawable = new ShapeDrawable(shape);
//            shapeDrawable.setBounds(startX, startY, endX, endY);
//            shapeDrawable.getPaint().setColor(Color.BLUE);
//            shapeDrawables.add(shapeDrawable);
//            invalidate();
//
//            return true;
//        }
//        return false;
//    }
}
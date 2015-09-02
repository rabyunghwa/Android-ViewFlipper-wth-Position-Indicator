package com.byunghwa.demo.viewflipperwithindicator;

/**
 * Created by ByungHwa on 8/19/2014.
 */

import android.app.Activity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;


public class MyActivity extends Activity implements GestureDetector.OnGestureListener {

    ViewFlipper flipper;
    private GestureDetector detector = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        Animation lInAnim = AnimationUtils.loadAnimation(this, R.anim.push_left_in);
        Animation lOutAnim = AnimationUtils.loadAnimation(this, R.anim.push_left_out);

        flipper = (ViewFlipper) findViewById(R.id.viewFlipper);
        flipper.setInAnimation(lInAnim);
        flipper.setOutAnimation(lOutAnim);
        flipper.setAutoStart(true);
        flipper.setFlipInterval(3000);
        if(flipper.isAutoStart()&&flipper.isFlipping()){
            flipper.startFlipping();
        }
        detector = new GestureDetector(this, this);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //flipper.stopFlipping();
        //flipper.setAutoStart(true);
        return detector.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

        // you can change this value
        float sensitivity = 50;

        // TODO Auto-generated method stub
        if((e1.getX() - e2.getX()) > sensitivity){
            Animation lInAnim = AnimationUtils.loadAnimation(this, R.anim.push_left_in);
            Animation lOutAnim = AnimationUtils.loadAnimation(this, R.anim.push_left_out);
            flipper.setInAnimation(lInAnim);
            flipper.setOutAnimation(lOutAnim);
            flipper.showNext();
            flipper.setAutoStart(true);
            return true;
        }else if((e2.getX() - e1.getX()) > sensitivity){
            Animation rInAnim = AnimationUtils.loadAnimation(this, R.anim.push_right_in);
            Animation rOutAnim = AnimationUtils.loadAnimation(this, R.anim.push_right_out);
            flipper.setInAnimation(rInAnim);
            flipper.setOutAnimation(rOutAnim);
            flipper.showPrevious();
            flipper.setAutoStart(true);
            return true;
        }

        return true;
    }
}

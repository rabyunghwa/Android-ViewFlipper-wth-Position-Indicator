package com.byunghwa.demo.viewflipperwithindicator;

/**
 * Created by ByungHwa on 8/19/2014.
 */

import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;


public class MyActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {

    private ViewFlipperIndicator flipper;
    private Animation lInAnim;
    private Animation lOutAnim;
    
    private String KEY_FLIPPER_POSITION = "flipper_position";

    private GestureDetector detector = null;

    private Handler myHandler = new Handler();

    // flipper restarts flipping
    private Runnable flipController = new Runnable() {
        @Override
        public void run() {
            flipper.setInAnimation(lInAnim);
            flipper.setOutAnimation(lOutAnim);
            flipper.showNext();
            flipper.startFlipping();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        lInAnim = AnimationUtils.loadAnimation(this, R.anim.push_left_in);
        lOutAnim = AnimationUtils.loadAnimation(this, R.anim.push_left_out);

        flipper = (ViewFlipperIndicator) findViewById(R.id.viewFlipper);

        // set values radius and margin for view flipper indicators
        flipper.setRadius(10);
        flipper.setMargin(10);

        // set colors for the indicators
        Paint paint = new Paint();
        paint.setColor(getResources().getColor(android.R.color.white));
        flipper.setPaintCurrent(paint);

        paint = new Paint();
        paint.setColor(getResources().getColor(R.color.pink_a200));
        flipper.setPaintNormal(paint);

        flipper.setInAnimation(lInAnim);
        flipper.setOutAnimation(lOutAnim);
        flipper.setAutoStart(true);
        flipper.setFlipInterval(3000);
        
        // flipper has a previous position. we should restore it
        if (savedInstanceState != null) {
            flipper.setDisplayedChild(savedInstanceState.getInt(KEY_FLIPPER_POSITION));
        }
        
        flipper.startFlipping();

        detector = new GestureDetector(this, this);

    }
    
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(KEY_FLIPPER_POSITION, flipper.getDisplayedChild());
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
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

        if ((e1.getX() - e2.getX()) > sensitivity) {

            flipper.showNext();

            // first stops flipping
            flipper.stopFlipping();

            // then flipper restarts flipping in 3 seconds
            myHandler.postDelayed(flipController, 3000);

            return true;
        } else if ((e2.getX() - e1.getX()) > sensitivity) {
            Animation rInAnim = AnimationUtils.loadAnimation(this, R.anim.push_right_in);
            Animation rOutAnim = AnimationUtils.loadAnimation(this, R.anim.push_right_out);
            flipper.setInAnimation(rInAnim);
            flipper.setOutAnimation(rOutAnim);
            flipper.showPrevious();

            // first stops flipping
            flipper.stopFlipping();

            // then flipper restarts flipping in 3 seconds
            myHandler.postDelayed(flipController, 3000);

            return true;
        }

        return true;
    }
}

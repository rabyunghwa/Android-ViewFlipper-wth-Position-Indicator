package com.byunghwa.demo.viewflipperwithindicator;

/**
 * Created by ByungHwa on 8/19/2014.
 */

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ViewFlipper;


public class ViewFlipperIndicator extends ViewFlipper {

    Paint paint = new Paint();

    public ViewFlipperIndicator(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int width = getWidth();

        float margin = 2;
        float radius = 8;
        float cx = width / 2 - ((radius + margin) * 2 * getChildCount() / 2);
        float cy = getHeight() - 15;

        canvas.save();

        for (int i = 0; i < getChildCount(); i++) {
            if (i == getDisplayedChild()) {
                paint.setColor(Color.WHITE);
                canvas.drawCircle(cx, cy, radius, paint);

            } else {
                paint.setColor(Color.BLACK);
                canvas.drawCircle(cx, cy, radius, paint);
            }
            cx += 2 * (radius + margin);
        }
        canvas.restore();
    }

}




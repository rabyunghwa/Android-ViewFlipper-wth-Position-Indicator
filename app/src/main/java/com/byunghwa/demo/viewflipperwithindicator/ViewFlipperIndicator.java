package com.byunghwa.demo.viewflipperwithindicator;

/**
 * Created by ByungHwa on 8/19/2014.
 */

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ViewFlipper;


public class ViewFlipperIndicator extends ViewFlipper {

    private Paint paint = new Paint();
    private Context mContext;

    public ViewFlipperIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int width = getWidth();

        float margin = 2;
        float radius = 6;
        float cx = width / 2 - ((radius + margin) * 2 * getChildCount() / 2);
        float cy = getHeight() - 15;

        canvas.save();

        for (int i = 0; i < getChildCount(); i++) {
            if (i == getDisplayedChild()) {
                paint.setColor(mContext.getResources().getColor(android.R.color.white));
                canvas.drawCircle(cx, cy, radius, paint);
            } else {
                paint.setColor(mContext.getResources().getColor(R.color.pink_a200));
                canvas.drawCircle(cx, cy, radius, paint);
            }
            cx += 2 * (radius + margin);
        }
        canvas.restore();
    }

}




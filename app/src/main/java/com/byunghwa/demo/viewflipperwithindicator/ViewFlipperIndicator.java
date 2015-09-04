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

    private Paint paintCurrent, paintNormal;

    private int radius;
    private int margin;

    public ViewFlipperIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getMargin() {
        return margin;
    }

    public void setMargin(int margin) {
        this.margin = margin;
    }

    public Paint getPaintCurrent() {
        return paintCurrent;
    }

    public void setPaintCurrent(Paint paintCurrent) {
        this.paintCurrent = paintCurrent;
    }

    public Paint getPaintNormal() {
        return paintNormal;
    }

    public void setPaintNormal(Paint paintNormal) {
        this.paintNormal = paintNormal;
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int width = getWidth();

        float cx = width / 2 - ((radius + margin) * 2 * getChildCount() / 2);
        float cy = getHeight() - 15;

        canvas.save();

        for (int i = 0; i < getChildCount(); i++) {
            if (i == getDisplayedChild()) {
                canvas.drawCircle(cx, cy, getRadius(), getPaintCurrent());
            } else {
                canvas.drawCircle(cx, cy, getRadius(), getPaintNormal());
            }
            cx += 2 * (getRadius() + getMargin());
        }
        canvas.restore();
    }

}




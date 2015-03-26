package com.naw.joystick;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by fs on 2015-03-15.
 */
public class JoyStickView extends View {

    private Paint paintThumbStick;
    private Paint paintOutline;
    private ThumbStickV2 thumbStick;

    private MyCircle outerCircle;

    private int width;
    private int height;

    private float greenCircleRadius;


    public JoyStickView(final Context ct) {
        super(ct);
        init(ct);
    }

    public JoyStickView(final Context ct, final AttributeSet attrs) {
        super(ct, attrs);
        init(ct);
    }

    public JoyStickView(final Context ct, final AttributeSet attrs, final int defStyle) {
        super(ct, attrs, defStyle);
        init(ct);
    }

    private void init(final Context context) {

        paintThumbStick = new Paint();
        paintThumbStick.setColor(Color.BLUE);
        paintThumbStick.setStrokeWidth(40);
        paintThumbStick.setStyle(Paint.Style.FILL);

        paintOutline = new Paint();
        paintOutline.setColor(Color.GREEN);
        paintOutline.setStrokeWidth(10);


        this.width = context.getResources().getDisplayMetrics().widthPixels;
        this.height = context.getResources().getDisplayMetrics().heightPixels;

        Log.d("ThumbStick", "width = " + width);
        Log.d("ThumbStick", "height = " + height);

        this.greenCircleRadius = (float) 0.75*width/2;

        thumbStick = new ThumbStickV2(width/2, height/2,100, width, height);

        outerCircle = new MyCircle(width/2, height/2,(int) greenCircleRadius);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawLine((float) width/2,0, (float) width/2, (float)height, paintOutline);
        canvas.drawCircle(width/2, height/2, greenCircleRadius, paintOutline);
        canvas.drawCircle(thumbStick.getX(), thumbStick.getY(), ThumbStick.RADIUS, paintThumbStick);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int touchX = (int) event.getX(0);
        int touchY = (int) event.getY(0);

        Boolean bound = thumbStick.checkCollision(outerCircle);
       // Log.d("ThumbStick", "outer circle width: " + greenCircleRadius);

       // Log.d("ThumbStick", String.format("x=%d y=%d", touchX, touchY).toString());

        Log.d("ThumbStick", "is bound: " + bound);
        switch(event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                if (thumbStick.isTouched(touchX, touchY)) {
                    thumbStick.setFocused(true);
                    thumbStick.setX(touchX);
                    thumbStick.setY(touchY);
                }

                break;
            case MotionEvent.ACTION_MOVE:
                if (thumbStick.isFocused() && bound) {
                    thumbStick.setX(touchX);
                    thumbStick.setY(touchY);

                    invalidate();
                }
                break;

            case MotionEvent.ACTION_UP:
                thumbStick.setFocused(false);

        }
        return true;
    }
}
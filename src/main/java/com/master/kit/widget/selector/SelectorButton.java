package com.master.kit.widget.selector;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.master.kit.R;

/**
 * Created by master on 2016/2/26.
 */
public class SelectorButton extends Button {
    public SelectorButton(Context context) {
        super(context);
        init();
    }

    public SelectorButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        handleTypedArray(context, attrs);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public SelectorButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        handleTypedArray(context, attrs);
        init();
    }

    public SelectorButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        handleTypedArray(context, attrs);
        init();
    }

    int normal;
    int selected;

    private void handleTypedArray(Context context, AttributeSet attrs) {
        if (attrs == null) {
            return;
        }

        TypedArray typedArray = context.obtainStyledAttributes(attrs,
                R.styleable.SelectorBitmap);

        normal = typedArray.getResourceId(
                R.styleable.SelectorBitmap_normal,
                -1);
        selected = typedArray.getResourceId(
                R.styleable.SelectorBitmap_selected,
                -1);
        typedArray.recycle();
    }

    /*private void init() {
        setBackgroundResource(normal);
        setOnTouchListener(new OnTouchListener() {
            boolean isCancel = false;
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        setBackgroundResource(selected);
                        break;
                    case MotionEvent.ACTION_UP:
                        if(!isCancel){

                            setBackgroundResource(normal);
                            SelectorButton.this.performClick();
                        }
                        isCancel = false;
                        break;
                    case MotionEvent.ACTION_MOVE:
                        if (event.getX() > getMeasuredWidth()
                                || event.getY() > getMeasuredHeight()
                                || event.getX() < 0 || event.getY() < 0) {
                            setBackgroundResource(normal);
                            isCancel = true;
                        }
                        break;
                }
                return false;
            }
        });
    }*/
    private void init() {
        setBackgroundResource(normal);
        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        setBackgroundResource(selected);
                        break;
                    case MotionEvent.ACTION_UP:
                        setBackgroundResource(normal);
                        break;
                }
                return false;
            }
        });
    }
}

package com.example.sunzhongyang.dragtest;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class MainActivity extends Activity implements View.OnTouchListener, View.OnDragListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.green_ball).setOnTouchListener(this);
        findViewById(R.id.blue_ball).setOnTouchListener(this);
        findViewById(R.id.top_container).setOnDragListener(this);
//        findViewById(R.id.bottom_container).setOnDragListener(this);
        //ooii噢噢哦
        findViewById(R.id.red_ball).setOnTouchListener(this);
        findViewById(R.id.ll1).setOnDragListener(this);
        findViewById(R.id.ll2).setOnDragListener(this);
        findViewById(R.id.ll3).setOnDragListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent e) {
        if (e.getAction() == MotionEvent.ACTION_DOWN) {
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
            v.startDrag(null, shadowBuilder, v, 0);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean onDrag(View v, DragEvent e) {
        if (e.getAction() == DragEvent.ACTION_DROP) {
            View view = (View) e.getLocalState();
            ViewGroup from = (ViewGroup) view.getParent();
            LinearLayout to = (LinearLayout) v;
            if (to.getId() == R.id.ll1||to.getId() == R.id.ll2|| to.getId() == R.id.ll3|| to.getId() == R.id.top_container) {
                if (to.getChildCount()==1|| to.getId() == R.id.top_container) {
                    from.removeView(view);
                    to.addView(view);
                    view.setVisibility(View.VISIBLE);
                }
            }

        }
        return true;
    }

}

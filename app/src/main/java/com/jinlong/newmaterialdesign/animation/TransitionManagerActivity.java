package com.jinlong.newmaterialdesign.animation;

import android.os.Build;
import android.support.constraint.ConstraintLayout;
import android.support.transition.Transition;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Scene;
import android.transition.Slide;
import android.transition.TransitionManager;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.jinlong.newmaterialdesign.R;
import com.transitionseverywhere.Recolor;

/**
 * 这个适用于展示TransitionManager的动画效果
 */
public class TransitionManagerActivity extends AppCompatActivity {

    private ConstraintLayout mCl_root;
    private TextView mTvText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition_manager);

        initView();
    }

    private void initView() {
        mCl_root = findViewById(R.id.cl_root);
        mTvText = findViewById(R.id.tv_text);
    }


    public void animation(View view) {
        //首先这里beginDelayedTransition开启的是一个默认的动画，若果你想用别的可以用Go那个方法
//        if (Build.VERSION.SDK_INT > 19) {
//            Slide slide = new Slide(Gravity.RIGHT);
//            TransitionManager.beginDelayedTransition(mCl_root, slide);
//        } else {
//            android.support.transition.Slide slide = new android.support.transition.Slide()
//            com.transitionseverywhere.TransitionManager.beginDelayedTransition(mCl_root,fade);
//        }
        android.support.transition.Slide slide = new android.support.transition.Slide(Gravity.BOTTOM);
        slide.setDuration(2000);
        android.support.transition.TransitionManager.beginDelayedTransition(mCl_root, slide);

        if (mTvText.getVisibility() == View.VISIBLE) {
            mTvText.setVisibility(View.GONE);
        } else {
            mTvText.setVisibility(View.VISIBLE);
        }
    }
}

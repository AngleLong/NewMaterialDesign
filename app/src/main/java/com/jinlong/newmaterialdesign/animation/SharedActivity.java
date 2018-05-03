package com.jinlong.newmaterialdesign.animation;

import android.animation.Animator;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.transition.TransitionManager;
import android.support.v7.app.AppCompatActivity;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.util.Log;
import android.view.ViewAnimationUtils;
import android.widget.LinearLayout;

import com.jinlong.newmaterialdesign.R;

public class SharedActivity extends AppCompatActivity {

    private static final String TAG = SharedActivity.class.getSimpleName();
    private LinearLayout mImage_bg;
    private FloatingActionButton mFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared);

        mImage_bg = findViewById(R.id.fl_top);
        mFab = findViewById(R.id.fab);

        if (Build.VERSION.SDK_INT > 20) {
            //设置进入动画
            getWindow().setEnterTransition(TransitionInflater.from(this).inflateTransition(R.transition.enter_animation));
            //设置退出动画
            getWindow().setReturnTransition(TransitionInflater.from(this).inflateTransition(R.transition.exit_animation));
        }
    }
}

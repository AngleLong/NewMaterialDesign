package com.jinlong.newmaterialdesign.animation;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.transition.AutoTransition;
import android.support.transition.ChangeBounds;
import android.support.transition.ChangeClipBounds;
import android.support.transition.Scene;
import android.support.transition.Slide;
import android.support.transition.TransitionManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jinlong.newmaterialdesign.R;

/**
 * 这个适用于展示TransitionManager的动画效果
 */
public class TransitionManagerActivity extends AppCompatActivity {

    private ConstraintLayout mCl_root;
    private TextView mTvText;
    private Scene mScene1;
    private Scene mScene2;
    private boolean isScene2;//这个标识是显示的是否是Scene2的页面

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition_manager);

        initView();
        initScene();
    }

    private void initView() {
        mCl_root = findViewById(R.id.cl_root);
        mTvText = findViewById(R.id.tv_text);
    }

    /**
     * 初始化Scene
     */
    private void initScene() {
        FrameLayout layout = findViewById(R.id.rl_root);
        mScene1 = Scene.getSceneForLayout(layout, R.layout.scene1, this);
        mScene2 = Scene.getSceneForLayout(layout, R.layout.scene2, this);
        TransitionManager.go(mScene1);
    }

    public void animation(View view) {
        Slide slide = new Slide(Gravity.BOTTOM);
        TransitionManager.beginDelayedTransition(mCl_root, slide);

        if (mTvText.getVisibility() == View.VISIBLE) {
            mTvText.setVisibility(View.GONE);
        } else {
            mTvText.setVisibility(View.VISIBLE);
        }
    }

    public void scene(View view) {
        TransitionManager.go(isScene2 ? mScene1 : mScene2,new ChangeBounds());
        isScene2 = !isScene2;
    }
}

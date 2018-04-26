package com.jinlong.newmaterialdesign.animation;

import android.support.constraint.ConstraintLayout;
import android.support.transition.Transition;
import android.support.transition.TransitionManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.jinlong.newmaterialdesign.R;

/**
 * 操作View的动画
 */
public class HandleViewActivity extends AppCompatActivity {

    private ConstraintLayout mClRoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handle_view);

        initView();
    }

    private void initView() {
        mClRoot = findViewById(R.id.cl_root);
    }


    /**
     * fade动画
     *
     * @param view
     */
    public void fadeTransition(View view) {
        TransitionManager.beginDelayedTransition(mClRoot);
    }
}

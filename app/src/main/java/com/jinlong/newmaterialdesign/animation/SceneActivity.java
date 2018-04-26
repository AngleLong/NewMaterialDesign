package com.jinlong.newmaterialdesign.animation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.transition.Transition;
import android.support.transition.TransitionInflater;
import android.support.v7.app.AppCompatActivity;

import com.jinlong.newmaterialdesign.R;

/**
 * 展示布局的过渡动画
 */
public class SceneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scene);

//        Transition sharedTransition = android.support.transition.TransitionInflater.from(this).inflateTransition(R.transition.changebounds_with_arcmotion);

    }
}

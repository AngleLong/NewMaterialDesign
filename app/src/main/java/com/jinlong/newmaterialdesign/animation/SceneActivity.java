package com.jinlong.newmaterialdesign.animation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.transition.ChangeBounds;
import android.support.transition.ChangeScroll;
import android.support.transition.Explode;
import android.support.transition.Fade;
import android.support.transition.Scene;
import android.support.transition.Slide;
import android.support.transition.Transition;
import android.support.transition.TransitionInflater;
import android.support.transition.TransitionManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;

import com.jinlong.newmaterialdesign.R;

/**
 * 展示布局的过渡动画
 */
public class SceneActivity extends AppCompatActivity {

    private Scene mScene1;
    private Scene mScene2;
    private boolean isScene2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scene);


        initScene();
    }

    private void initScene() {
        FrameLayout layout = findViewById(R.id.rl_root);
        mScene1 = Scene.getSceneForLayout(layout, R.layout.scene1, this);
        mScene2 = Scene.getSceneForLayout(layout, R.layout.scene2, this);
        TransitionManager.go(mScene1);
    }

    /**
     * 操作Scene动画
     */
    public void scene(View view) {
        TransitionManager.go(isScene2 ? mScene1 : mScene2, new ChangeBounds());
        isScene2 = !isScene2;
    }
}

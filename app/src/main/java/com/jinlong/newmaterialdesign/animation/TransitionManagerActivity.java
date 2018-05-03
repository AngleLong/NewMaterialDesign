package com.jinlong.newmaterialdesign.animation;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.transition.AutoTransition;
import android.support.transition.ChangeBounds;
import android.support.transition.ChangeClipBounds;
import android.support.transition.ChangeScroll;
import android.support.transition.Explode;
import android.support.transition.Fade;
import android.support.transition.Scene;
import android.support.transition.Slide;
import android.support.transition.TransitionManager;
import android.support.transition.TransitionSet;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jinlong.newmaterialdesign.R;

import de.hdodenhof.circleimageview.CircleImageView;

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
    }

    /**
     * 操作单独View的
     */
    public void handleView(View view) {
        Intent intent = new Intent(this, HandleViewActivity.class);
        startActivity(intent);
    }

    /**
     * 操作Scene的
     */
    public void handleScene(View view) {
        Intent intent = new Intent(this, SceneActivity.class);
        startActivity(intent);
    }

    /**
     * 共享动画
     */
    public void sharedAnimation(View view) {
        CircleImageView civHead = findViewById(R.id.civ_heard);
        TextView tvTitle = findViewById(R.id.tv_title);

        Intent intent = new Intent(this, SharedActivity.class);
        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this,
                new Pair<View, String>(civHead, "shared_image"),
                new Pair<View, String>(tvTitle, "shared_textview"));

        startActivity(intent, optionsCompat.toBundle());
    }
}

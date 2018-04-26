package com.jinlong.newmaterialdesign.animation;

import android.animation.Animator;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.ViewAnimationUtils;
import android.widget.LinearLayout;

import com.jinlong.newmaterialdesign.R;

public class SharedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared);

        final LinearLayout image_bg = findViewById(R.id.fl_top);

        if (Build.VERSION.SDK_INT > 21) {
            final Transition sharedTransition = TransitionInflater.from(this).inflateTransition(R.transition.changebounds_with_arcmotion);
            sharedTransition.addListener(new Transition.TransitionListener() {
                @Override
                public void onTransitionStart(@NonNull Transition transition) {
                    Animator circularReveal = ViewAnimationUtils.createCircularReveal(image_bg, image_bg.getWidth() / 2, image_bg.getHeight() / 2
                            , image_bg.getWidth() / 4, Math.max(image_bg.getWidth(), image_bg.getHeight()));
                    image_bg.setBackgroundColor(Color.BLACK);
                    circularReveal.setDuration(600);
                    circularReveal.start();
                }

                @Override
                public void onTransitionEnd(@NonNull Transition transition) {
                    sharedTransition.removeListener(this);
                }

                @Override
                public void onTransitionCancel(@NonNull Transition transition) {

                }

                @Override
                public void onTransitionPause(@NonNull Transition transition) {

                }

                @Override
                public void onTransitionResume(@NonNull Transition transition) {

                }
            });

            getWindow().setEnterTransition(sharedTransition);
        }
    }
}

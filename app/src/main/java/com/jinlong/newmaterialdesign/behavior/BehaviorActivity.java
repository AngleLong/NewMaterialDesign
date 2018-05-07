package com.jinlong.newmaterialdesign.behavior;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.SwipeDismissBehavior;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jinlong.newmaterialdesign.R;

/**
 * Behavior的初始页面
 */
public class BehaviorActivity extends AppCompatActivity {

    private LinearLayout mLlBottomSheet;//底部展示的Behavior
    private SwipeDismissBehavior<View> mSwipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_behavior);
        initView();
        initSwipeDismiss();
    }

    private void initSwipeDismiss() {
        TextView tvTitle = findViewById(R.id.tv_title);

        SwipeDismissBehavior<View> mSwipe = new SwipeDismissBehavior();

        /*
         * SWIPE_DIRECTION_START_TO_END 只能从左向右滑动
         * SWIPE_DIRECTION_END_TO_START 只能从右向左滑动
         * SWIPE_DIRECTION_ANY 左右滑动都可以
         */
        mSwipe.setSwipeDirection(SwipeDismissBehavior.SWIPE_DIRECTION_ANY);

        mSwipe.setListener(new SwipeDismissBehavior.OnDismissListener() {
            @Override
            public void onDismiss(View view) {
                //View消失的回调
            }

            @Override
            public void onDragStateChanged(int state) {
                /*
                 * STATE_IDLE 空闲状态
                 * STATE_DRAGGING 滑动中
                 * STATE_SETTLING 消失
                 */
            }
        });

        CoordinatorLayout.LayoutParams coordinatorParams = (CoordinatorLayout.LayoutParams) tvTitle.getLayoutParams();

        coordinatorParams.setBehavior(mSwipe);
    }

    private void initView() {
        mLlBottomSheet = findViewById(R.id.ll_bottom);
    }

    /**
     * 展示BottomSheet
     */
    public void bottomSheet(View view) {
        BottomSheetBehavior<LinearLayout> bottomSheetBehavior = BottomSheetBehavior.from(mLlBottomSheet);
        if (bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        } else {
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        }
    }

    /**
     * 展示BottomSheetDialog
     */
    public void bottomSheetDialog(View view) {
        BottomSheetDialog sheetDialog = new BottomSheetDialog(this);
        sheetDialog.setContentView(R.layout.sheet_dialog);
        sheetDialog.show();
    }

    /**
     * BottomSheetFragment
     */
    public void bottomSheetFragment(View view) {
        new BottomSheetFragment().show(getSupportFragmentManager(), "tag");
    }

    /**
     * 底部跟随ActionBarLayout移动的演示
     */
    public void bottomBehavior(View view) {
        Intent intent = new Intent(this, TwoBehaviorActivity.class);
        startActivity(intent);
    }

    /**
     * 顶部头部保持不动的Behavior
     */
    public void oneBehavior(View view) {
        Intent intent = new Intent(this, OneBehaviorActivity.class);
        startActivity(intent);
    }
}

package com.jinlong.newmaterialdesign.behavior;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.jinlong.newmaterialdesign.R;

/**
 * 实现一个FAB的behavior
 */

public class OneBehavior extends CoordinatorLayout.Behavior {

    private String TAG = OneBehavior.class.getSimpleName();

    public OneBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public void onStopNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull View target, int type) {
        super.onStopNestedScroll(coordinatorLayout, child, target, type);
    }

    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull View directTargetChild, @NonNull View target, int axes, int type) {
        //如果是水平移动的话响应响应的事件
        return axes == ViewCompat.SCROLL_AXIS_VERTICAL || super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, axes, type);
    }

    @Override
    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type);
        // 在这个方法里只处理向下滑动
        if(dyUnconsumed >0){
            return;
        }

        float transY = child.getTranslationY() - dyUnconsumed;
        Log.i(TAG,"------>transY:"+transY+"****** child.getTranslationY():"+child.getTranslationY()+"--->dyUnconsumed"+dyUnconsumed);
        if(transY > 0 && transY < getHeaderHeight()){
            child.setTranslationY(transY);
        }
    }




    @Override
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull View target, int dx, int dy, @NonNull int[] consumed, int type) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed, type);
        // 在这个方法里面只处理向上滑动
        if(dy < 0){
            return;
        }

        float transY =  child.getTranslationY() - dy;
        Log.i(TAG,"transY:"+transY+"++++child.getTranslationY():"+child.getTranslationY()+"---->dy:"+dy);
        if(transY > 0){
            child.setTranslationY(transY);
            consumed[1]= dy;
        }
    }

    @Override
    public boolean onLayoutChild(CoordinatorLayout parent, View child, int layoutDirection) {
        //设置了behavior的布局
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) child.getLayoutParams();
        if(params!=null && params.height == CoordinatorLayout.LayoutParams.MATCH_PARENT){
            child.layout(0,0,parent.getWidth(),parent.getHeight());
            child.setTranslationY(getHeaderHeight());
            return true;
        }

        return super.onLayoutChild(parent, child, layoutDirection);
    }

    /**
     * 这里是Header的高度，可以设置成任何你想的高度
     */
    public int getHeaderHeight(){
//        当你设置到相应的清单文件的时候，你就这么弄
//        return Context.getResources().getDimensionPixelOffset(R.dimen.header_height);
        return 500;
    }
}

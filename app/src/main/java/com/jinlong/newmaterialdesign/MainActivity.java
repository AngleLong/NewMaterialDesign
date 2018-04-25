package com.jinlong.newmaterialdesign;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.jinlong.newmaterialdesign.animation.TransitionManagerActivity;
import com.jinlong.newmaterialdesign.navigation.NavigationActivity;
import com.jinlong.newmaterialdesign.toolbar.DefaultToolbarActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * Toolbar的使用展示
     */
    public void toolbar(View view) {
        Intent toolbarIntent = new Intent(this, DefaultToolbarActivity.class);
        startActivity(toolbarIntent);
    }

    /**
     * NavigationAndDrawer的联合使用
     */
    public void NavigationAndDrawer(View view) {
        Intent navigationIntent = new Intent(this, NavigationActivity.class);
        startActivity(navigationIntent);
    }

    /**
     * 作者 贺金龙
     * <p>
     * 方法描述: 动画的演示
     * 创建时间: 2018/4/25 1659
     */
    public void animation(View view) {
        Intent transitionAnimation = new Intent(this, TransitionManagerActivity.class);
        startActivity(transitionAnimation);
    }
}

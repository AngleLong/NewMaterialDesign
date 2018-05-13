package com.jinlong.newmaterialdesign;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;

import com.jinlong.newmaterialdesign.animation.TransitionManagerActivity;
import com.jinlong.newmaterialdesign.behavior.BehaviorActivity;
import com.jinlong.newmaterialdesign.fab.FABActivity;
import com.jinlong.newmaterialdesign.material.AppBarLayoutActivity;
import com.jinlong.newmaterialdesign.material.MaterialActivity;
import com.jinlong.newmaterialdesign.material.SupperMaterialActivity;
import com.jinlong.newmaterialdesign.navigation.NavigationActivity;
import com.jinlong.newmaterialdesign.tablayout.NewTabLayoutActivity;
import com.jinlong.newmaterialdesign.tablayout.TabLayoutActivity;
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
     * 创建时间: 2018/4/25
     */
    public void animation(View view) {
        Intent transitionAnimation = new Intent(this, TransitionManagerActivity.class);
        startActivity(transitionAnimation);
    }

    /**
     * Fab的使用演示
     */
    public void fab(View view) {
        Intent intent = new Intent(this, FABActivity.class);
        startActivity(intent);
    }

    /**
     * behavior的演示
     */
    public void behavior(View view) {
        Intent intent = new Intent(this, BehaviorActivity.class);
        startActivity(intent);
    }

    /**
     * materialDesign的联动
     */
    public void materialDesign(View view) {
        Intent intent = new Intent(this, MaterialActivity.class);
        startActivity(intent);
    }

    /**
     * materialDesign更酷炫的联动
     */
    public void supperMaterialDesign(View view) {
        Intent intent = new Intent(this, SupperMaterialActivity.class);
        startActivity(intent);
    }

    /**
     * materialDesign更酷炫的联动
     */
    public void AppBarLayout(View view) {
        Intent intent = new Intent(this, AppBarLayoutActivity.class);
        startActivity(intent);
    }

    /**
     * TabLayout的使用
     */
    public void tabLayout(View view) {
        Intent intent = new Intent(this, TabLayoutActivity.class);
        startActivity(intent);
    }

    /**
     * TabLayout自定义布局的使用
     */
    public void newTabLayout(View view) {
        Intent intent = new Intent(this, NewTabLayoutActivity.class);
        startActivity(intent);
    }
}

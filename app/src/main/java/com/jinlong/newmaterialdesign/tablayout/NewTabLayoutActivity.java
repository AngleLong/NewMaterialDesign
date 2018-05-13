package com.jinlong.newmaterialdesign.tablayout;

import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.jinlong.newmaterialdesign.R;
import com.jinlong.newmaterialdesign.toolbar.MainVPAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 动态改变标签的TabLayout
 */
public class NewTabLayoutActivity extends AppCompatActivity {

    private TabLayout mTb;
    private ViewPager mVp;
    private TabLayout mTbTop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_tab_layout);


        mTb = findViewById(R.id.tb);
        mTbTop = findViewById(R.id.tb_top);
        mVp = findViewById(R.id.vp_content);

        initTabVP();
        initListener();
    }

    private void initListener() {
        mTb.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void initTabVP() {
        List<Fragment> list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            ItemFragment itemFragment = new ItemFragment();
            list.add(itemFragment);
        }
        MainVPAdapter vpAdapter = new MainVPAdapter(getSupportFragmentManager(), list);
        mVp.setAdapter(vpAdapter);

        mTb.setupWithViewPager(mVp);
//        如果添加这句话的话，内部条目会变成20个，一般不会出现这种状态的
//        mTbTop.setupWithViewPager(mVp);

        for (int i = 0; i < list.size(); i++) {
            mTbTop.addTab(mTbTop.newTab().setText("标签" + i));

            TabLayout.Tab tabAt = mTb.getTabAt(i);
            tabAt.setCustomView(R.layout.tb_item_view);
            View customView = tabAt.getCustomView();
            TextView tv = customView.findViewById(R.id.tv);
            tv.setText("标签" + i);
        }
    }
}

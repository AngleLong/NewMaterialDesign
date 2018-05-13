package com.jinlong.newmaterialdesign.tablayout;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jinlong.newmaterialdesign.R;
import com.jinlong.newmaterialdesign.toolbar.MainVPAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * TabLayout的显示
 */
public class TabLayoutActivity extends AppCompatActivity {

    private TabLayout mTb;
    private ViewPager mVp;
    private TabLayout mTbToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);

        mTb = findViewById(R.id.tb);
        mTbToolbar = findViewById(R.id.tb_toolbar);
        mVp = findViewById(R.id.vp_content);

        initTabVP();
    }

    /**
     * 设置联动
     */
    private void initTabVP() {
//        mTb.getTabAt(1).select();
        List<Fragment> list = new ArrayList();
        for (int i = 0; i < 2; i++) {
            ItemFragment itemFragment = new ItemFragment();
            list.add(itemFragment);
        }

        MainVPAdapter vpAdapter = new MainVPAdapter(getSupportFragmentManager(), list, new String[]{"标签1", "标签2"});
        mVp.setAdapter(vpAdapter);
        mTb.setupWithViewPager(mVp);
        mTbToolbar.setupWithViewPager(mVp);
    }
}

package com.jinlong.newmaterialdesign.toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 75335 on 2018/4/21.
 * 主页ViewPager的适配器
 */

public class MainVPAdapter extends FragmentPagerAdapter {
    private List<Fragment> mList;

    public MainVPAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        if (list == null) {
            mList = new ArrayList<>();
        } else {
            mList = list;
        }
    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList.size();
    }
}

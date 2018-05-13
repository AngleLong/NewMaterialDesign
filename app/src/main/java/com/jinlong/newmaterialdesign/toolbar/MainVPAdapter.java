package com.jinlong.newmaterialdesign.toolbar;

import android.support.annotation.Nullable;
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
    private String[] mArrs;

    public MainVPAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        if (list == null) {
            mList = new ArrayList<>();
        } else {
            mList = list;
        }
    }

    public MainVPAdapter(FragmentManager fm, List<Fragment> list, String[] arr) {
        super(fm);
        if (list == null) {
            mList = new ArrayList<>();
        } else {
            mList = list;
        }
        mArrs = arr;
    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (mArrs == null)
            return super.getPageTitle(position);
        else
            return mArrs[position];
    }
}

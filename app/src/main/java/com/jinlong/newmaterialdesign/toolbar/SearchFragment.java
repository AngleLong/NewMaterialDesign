package com.jinlong.newmaterialdesign.toolbar;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jinlong.newmaterialdesign.R;

/**
 * 搜索页面的Fragment
 */
public class SearchFragment extends Fragment {


    private TextView mTvSearch;

    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_search, container, false);

        mTvSearch = rootView.findViewById(R.id.tv_search);
        return rootView;
    }

    public void setSearchStr(String query) {
        if (!TextUtils.isEmpty(query))
            mTvSearch.setText("搜索的内容是" + query);
    }
}

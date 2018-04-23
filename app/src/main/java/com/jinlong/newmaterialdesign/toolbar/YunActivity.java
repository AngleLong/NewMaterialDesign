package com.jinlong.newmaterialdesign.toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.jinlong.newmaterialdesign.R;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 模仿网易云音乐的Toolbar
 */
public class YunActivity extends AppCompatActivity {

    private static final String TAG = YunActivity.class.getSimpleName();
    private SearchView mSearchView;
    private ViewPager mVpContent;
    private SearchFragment mSearchFragment;
    private SearchView.SearchAutoComplete mSearchAutoComplete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yun);

        Log.e(TAG, "onCreate: ");

        initToolbar();
        initViewPager();
    }


    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mSearchAutoComplete.isShown()) {
                    try {
                        mSearchAutoComplete.setText("");//清除文本
                        //利用反射调用收起SearchView的onCloseClicked()方法
                        Method method = mSearchView.getClass().getDeclaredMethod("onCloseClicked");
                        method.setAccessible(true);
                        method.invoke(mSearchView);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    finish();
                }
            }
        });
    }

    private void initViewPager() {
        mVpContent = findViewById(R.id.vp_content);

        List<Fragment> list = new ArrayList<>();
        DefaultFragment defaultFragment = new DefaultFragment();
        list.add(defaultFragment);
        mSearchFragment = new SearchFragment();
        list.add(mSearchFragment);

        MainVPAdapter adapter = new MainVPAdapter(getSupportFragmentManager(), list);

        mVpContent.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.e(TAG, "onCreateOptionsMenu: ");
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_yun, menu);

        //获取SearchView对象
        MenuItem searchItem = menu.findItem(R.id.search);
        mSearchView = (SearchView) searchItem.getActionView();

        //searchView中的一些设置
        mSearchView.setIconifiedByDefault(false);
        //修改searchView的文字颜色
        mSearchAutoComplete = mSearchView.findViewById(R.id.search_src_text);
        //设置输入框提示文字样式
        mSearchAutoComplete.setHintTextColor(getResources().getColor(android.R.color.white));//设置提示文字颜色
        mSearchAutoComplete.setTextColor(getResources().getColor(android.R.color.white));//设置内容文字颜色


        //设置相应的监听,文字变化的监听
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //在文字改变的时候回调，query是改变之后的文字
                mSearchFragment.setSearchStr(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //文字提交的时候哦回调，newText是最后提交搜索的文字
                return false;
            }
        });

        mSearchView.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //开始搜索的时候，设置显示搜索页面
                mVpContent.setCurrentItem(1);
            }
        });


        mSearchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                //关闭搜索按钮的时候，设置显示默认页面
                mVpContent.setCurrentItem(0);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}

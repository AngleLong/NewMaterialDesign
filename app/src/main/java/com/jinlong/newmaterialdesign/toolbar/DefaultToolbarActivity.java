package com.jinlong.newmaterialdesign.toolbar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.jinlong.newmaterialdesign.R;

/**
 * 这个是默认的Toolbar的展示
 */
public class DefaultToolbarActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private TextView mTvTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default_toolbar);
        mTvTitle = findViewById(R.id.tv_title);

        initToolbar();
        initToolbarListener();
    }


    private void initToolbar() {
        mToolbar = findViewById(R.id.toolbar);
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
    }

    private void initToolbarListener() {
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DefaultToolbarActivity.this, "点击了navigationIcon", Toast.LENGTH_SHORT).show();
            }
        });
        mTvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DefaultToolbarActivity.this, "点击了标题", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //设置menu文件
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_default_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        //menu的监听
        switch (item.getItemId()) {
            case R.id.menu_cycling:
                intent = new Intent(DefaultToolbarActivity.this, ZhiHuToolbarActivity.class);
                startActivity(intent);
                break;
            case R.id.menu_other:
                Toast.makeText(this, "其他", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_yun:
                intent = new Intent(DefaultToolbarActivity.this, YunActivity.class);
                startActivity(intent);
                break;
            case R.id.menu_fragment:
                intent = new Intent(DefaultToolbarActivity.this, WithFragmentActivity.class);
                startActivity(intent);
                break;
        }
        return true;
    }
}

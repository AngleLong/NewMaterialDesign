package com.jinlong.newmaterialdesign.toolbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.jinlong.newmaterialdesign.R;

public class ZhiHuToolbarActivity extends AppCompatActivity {

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhi_hu_toolbar);

        setToolBar();
        setToolBarListener();
    }


    private void setToolBar() {
        mToolbar = findViewById(R.id.toolbarZhiHu);
        setSupportActionBar(mToolbar);
    }

    private void setToolBarListener() {
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_zhihu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_delete:
                Toast.makeText(this, "删除按钮", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_other:
                Toast.makeText(this, "其他按钮", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_setting:
                Toast.makeText(this, "设置按钮", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}

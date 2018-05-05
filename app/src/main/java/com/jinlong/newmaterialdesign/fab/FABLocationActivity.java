package com.jinlong.newmaterialdesign.fab;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jinlong.newmaterialdesign.R;

public class FABLocationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fablocation);



        final FloatingActionButton fab = findViewById(R.id.lyj_showbut);
        fab.post(new Runnable() {
            @Override
            public void run() {
                fab.animate()
                        .scaleX(1)
                        .scaleY(1)
                        .start();
            }
        });
    }
}

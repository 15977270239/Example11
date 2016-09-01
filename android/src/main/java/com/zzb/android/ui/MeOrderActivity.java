package com.zzb.android.ui;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.zzb.android.R;

/**
 * Created by Bin on 2016/9/1.
 */
public class MeOrderActivity extends Activity implements View.OnClickListener{
    private ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collctionshopp);
        initView();
    }
    public void initView(){
        back=(ImageView)findViewById(R.id.back);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back:
                finish();
                break;
        }
    }
}

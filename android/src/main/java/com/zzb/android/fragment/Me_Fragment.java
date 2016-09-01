package com.zzb.android.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.zzb.android.R;
import com.zzb.android.ui.ColloctionShoppActivity;

/**
 * Created by Bin on 2016/8/20.
 */
public class Me_Fragment extends Fragment implements View.OnClickListener{
    private View view;
    private Button button,btn_meorder;
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_me,container,false);
        initview();

        return view;
    }
    public void initview(){
        button=(Button)view.findViewById(R.id.cllction_goods);
        btn_meorder=(Button)view.findViewById(R.id.btn_meorder);
        button.setOnClickListener(this);
        btn_meorder.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.cllction_goods:
                startActivity(new Intent(getActivity(), ColloctionShoppActivity.class));
                break;
            case R.id.btn_meorder:

                break;
        }
    }
}

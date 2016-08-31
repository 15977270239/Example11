package com.zzb.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import com.zzb.android.entiys.ClickLimit;
import com.zzb.android.fragment.Car_Fragment;
import com.zzb.android.fragment.Classify_Fragment;
import com.zzb.android.fragment.Home_Fragment;
import com.zzb.android.fragment.Me_Fragment;

public class MainActivity extends FragmentActivity {
    //初始化碎片管理器
    private FragmentManager fm;
    private FragmentTransaction ft;
    //初始化Fragment碎片数组
    private Fragment[] fragments;
    //初始化id数组
    private int[] tabid={R.id.tab_home,R.id.tab_classify,
            R.id.tab_cart,R.id.tab_me};
//    private int[] tabid={R.id.tab_home,R.id.tab_classify};
    private RadioButton[] radioButtons;
    private boolean initdone;
    private int currindex = -1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
//    private void initView(){
//        fm = getSupportFragmentManager();
//        ft = fm.beginTransaction();
//        fragments = new Fragment[2];
//        fragments[0] = new Home_Fragment();
//        fragments[1] = new Classify_Fragment();
//        //把四个tab的数组长度存在radioButtons数组中
//        radioButtons = new RadioButton[tabid.length];
//        ft.add(R.id.framelayout,fragments[0]);
//        for (int i=0;i<fragments.length;i++){
//            //找到四个tab的id
//            radioButtons[i]=(RadioButton)findViewById(tabid[i]);
//            if (i==0){
//                ft.show(fragments[i]);
//            }else {
//                ft.hide(fragments[i]).remove(fragments[i]);
//            }
//        }
//        //提交 commitAllowingStateLoss()是允许状态值丢失的
//        ft.commitAllowingStateLoss();
//        initdone=true;
//    }
//    //tab的点击事件
//    public void fragmclick(View view){
//        if (!initdone|| !ClickLimit.canClick(200)){
//            return;
//        }
//        int id = view.getId();
//        ft = fm.beginTransaction();
//        for (int i=0;i<tabid.length;i++){
//            if (tabid[i]==id){
//                currindex=i;
//                if (!fragments[i].isAdded()){
//                    try {
//                        ft.add(R.id.framelayout,fragments[i],i+"");
//                    }catch (Exception e){
//                        e.printStackTrace();
//                    }
//                }
//                ft = ft.show(fragments[i]);
//                radioButtons[i].setChecked(true);
//            }else {
//                ft = ft.hide(fragments[i]);
//                radioButtons[i].setChecked(false);
//            }
//        }
//        ft.commitAllowingStateLoss();
//    }
private void initView(){
    fm = getSupportFragmentManager();
    ft = fm.beginTransaction();
    fragments = new Fragment[4];
    fragments[0] = new Home_Fragment();
    fragments[1] = new Classify_Fragment();
    fragments[2] = new Car_Fragment();
    fragments[3] = new Me_Fragment();
    //把四个tab的数组长度存在ImageView数组中
    radioButtons = new RadioButton[tabid.length];
    ft.add(R.id.framelayout, fragments[0]);
    for (int i = 0; i < fragments.length; i++) {
        //找到四个tab的id
        radioButtons[i] = (RadioButton)findViewById(tabid[i]);
        if (i==0) {
            ft.show(fragments[i]);
        }else {
            ft.hide(fragments[i]).remove(fragments[i]);
        }
    }
    //提交 commitAllowingStateLoss()是允许状态值丢失的
    ft.commitAllowingStateLoss();
    initdone = true;
}
    public void fragmclick(View view) {
        if (!initdone || !ClickLimit.canClick(200)) {
            return;
        }
        int id = view.getId();
        ft = fm.beginTransaction();
        for (int i = 0; i < tabid.length; i++) {
            if (tabid[i] == id) {
                currindex = i;
                if (!fragments[i].isAdded()) {
                    try {
                        ft.add(R.id.framelayout, fragments[i], i + "");
                    } catch (Exception e) {

                    }
                }
                ft = ft.show(fragments[i]);
                radioButtons[i].setChecked(true);
            } else {
                ft = ft.hide(fragments[i]);
                radioButtons[i].setChecked(false);
            }
        }
        ft.commitAllowingStateLoss();
    }

    private long exitTime = 0;
    public void onBackPressed(){
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(this,"再按一次退出程序", Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            startActivity(intent);
            MainActivity.this.finish();
        }
    }
}

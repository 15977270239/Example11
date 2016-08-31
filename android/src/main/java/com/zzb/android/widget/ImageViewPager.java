package com.zzb.android.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bumptech.glide.Glide;
import com.zzb.android.R;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Bin on 2016/8/21.
 */
public class ImageViewPager extends LinearLayout {
    private Context context;
    private View fatherview;
    private RadioGroup radiogroup;
    private ChildViewPager viewpager;
    private MyViewPagerAdapter adapter;
    private OnPageChange listener;
    private OnItemClick clicklistener;
    private static final int currimage = R.mipmap.page_indicator_unfocused;//选中是图片
    private static final int nocurrimage =  R.mipmap.page_indicator_focused;//未选中时的图片
    private ArrayList<RadioButton> radiodata ;
    private ArrayList<ViewPagerData> viewdata;
    float x1 = 0;
    float x2 = 0;
    float y1 = 0;
    float y2 = 0;
    private int oldcurrindex;
    private int currindex;
    private int position;
    class ViewPagerData{
        View view;
        String imageurl;
        ImageView imageview;
    }
    public ImageViewPager(Context context) {
        super(context);
        init(context);
    }

    public ImageViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ImageViewPager(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }
    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                //更换图片
                if (viewpager!=null && radiodata != null) {
                    if (radiodata.size()>1) {
                        int curr =  viewpager.getCurrentItem();
                        if (curr==radiodata.size()-1) {
                            curr = 0;
                        } else {
                            curr++;
                        }
                        viewpager.setCurrentItem(curr);
                    }
                }
            }
        }
    };
    private void init (Context context) {
        this.context = context;

        // 时间任务
        TimerTask timeTask = new TimerTask() {
            @Override
            public void run() {
                mHandler.sendEmptyMessage(1);
            }
        };
        // 每5秒更新一次
        new Timer().schedule(timeTask, 1000, 5000);
        //父界面
        fatherview = LayoutInflater.from(this.context).inflate(R.layout.layout_imageviewpager, null);
        radiogroup = (RadioGroup) fatherview.findViewById(R.id.radiogroup);
        viewpager = (ChildViewPager) fatherview.findViewById(R.id.vPager);
    }
//    public synchronized void setimsges (ArrayList<?> urls,int defcurrindex) {
public synchronized void setimsges (ArrayList<String> urls, int defcurrindex) {
        oldcurrindex = defcurrindex;

        this.removeAllViews();
        radiogroup.removeAllViews();
        radiodata = new ArrayList<RadioButton>();
        viewdata = new ArrayList<ViewPagerData>();

        RadioGroup.LayoutParams redioGroupParams=new RadioGroup.LayoutParams(12, 12);
        redioGroupParams.setMargins(8, 0, 8, 0);
        for (int i = 0; i < urls.size(); i++) {
            //radiogroup部分
            RadioButton radiobutton = new RadioButton(context);
            radiobutton.setGravity(Gravity.CENTER);
            Bitmap bmNull = null;
            radiobutton.setButtonDrawable(new BitmapDrawable(bmNull));
            if (i==defcurrindex) {
                radiobutton.setBackgroundResource(currimage);
            } else {
                radiobutton.setBackgroundResource(nocurrimage);
            }

            radiodata.add(radiobutton);
            radiogroup.addView(radiobutton,redioGroupParams);

            final int viewindex = i;			//ViewPager部分
            ViewPagerData vdata = new ViewPagerData();
            vdata.view = LayoutInflater.from(this.context).inflate(R.layout.item_imageviewpager, null);
            vdata.imageview = (ImageView)vdata.view.findViewById(R.id.ivp_image);
            viewpager.setOnSingleTouchListener(new ChildViewPager.OnSingleTouchListener() {


                @Override
                public void onSingleTouch() {
                    if (clicklistener!=null) {
                        clicklistener.onClick(position);
                    }

                }
            });

//            Object var = urls.get(i);
//            if (var instanceof String) {
//                vdata.imageurl = (String)var;
//            } else  if (var instanceof Banner) {
//                vdata.imageurl = ((Banner)var).getImg();
//            }
            //加载图片
            Glide.with(context).load(vdata.imageurl).dontAnimate().into(vdata.imageview);
            viewdata.add(vdata);
        }

        adapter = new MyViewPagerAdapter(viewdata);
        viewpager.setAdapter(adapter);
        viewpager.setOnPageChangeListener(new MyOnPageChangeListener());

        if (defcurrindex!=0) {
            this.setCurrentItem(defcurrindex);
            radiodata.get(defcurrindex).setBackgroundResource(currimage);
        }

        this.addView(fatherview);
    }


    public void setCurrentItem(int index) {
        viewpager.setCurrentItem(index);
    }

    //clicklistener
    public void setOnclick (OnItemClick clicklistener) {
        this.clicklistener = clicklistener;
    }
    //适配器
    private class MyViewPagerAdapter extends PagerAdapter {
        private ArrayList<ViewPagerData> data;

        public MyViewPagerAdapter(ArrayList<ViewPagerData> data) {
            this.data = data;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) 	{
            container.removeView(data.get(position).view);
        }


        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(data.get(position).view,0);
            return data.get(position).view;
        }

        @Override
        public int getCount() {
            return  data.size();
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0==arg1;
        }
    }

    private class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {
        public void onPageScrollStateChanged(int arg0) {

        }

        public void onPageScrolled(int arg0, float arg1, int arg2) {


        }

        public void onPageSelected(int index) {
            position=index;
            //页面转换
            currindex = index;
            //改变下方横向图片
            radiodata.get(currindex).setBackgroundResource(currimage);
            radiodata.get(oldcurrindex).setBackgroundResource(nocurrimage);

            oldcurrindex = index;
            //触发子事件
            if (listener!=null) {
                listener.onPageSelected(currindex);
            }

        }

    }

    public interface OnPageChange {
        public void onPageSelected(int currindex);
    }

    public interface OnItemClick{
        public void onClick(int index);
    }
}

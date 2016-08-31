package com.zzb.android.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zzb.android.R;
import com.zzb.android.entiys.ColloctionGoods;

import java.util.List;

/**
 * Created by Bin on 2016/8/26.
 */
public class ColloctionGoodsAdapter extends BaseAdapter implements View.OnClickListener{
    Activity activity;
    private List<ColloctionGoods> list;
    private ViewHoler holer;
    private Button right;
    private RelativeLayout layoutbuttom;
    private boolean ischecked=false;
    public ColloctionGoodsAdapter(Activity activity,List<ColloctionGoods> list){
        this.activity=activity;
        this.list=list;
        right=(Button)activity.findViewById(R.id.right);
        layoutbuttom=(RelativeLayout)activity.findViewById(R.id.layout_bottom);
        right.setOnClickListener(this);

    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertview, ViewGroup viewGroup) {
        holer=new ViewHoler();
        if (convertview==null){
            convertview= LayoutInflater.from(activity).inflate(R.layout.item_shopp_collection,null,false);
            holer.checkbox=(CheckBox)convertview.findViewById(R.id.checkbox);
            holer.goodsname=(TextView)convertview.findViewById(R.id.goods_title);
            holer.yuanprice=(TextView)convertview.findViewById(R.id.store);
            holer.xianprice=(TextView)convertview.findViewById(R.id.price);
            convertview.setTag(holer);
        }else{
            holer=(ViewHoler)convertview.getTag();
        }
        if (ischecked){
            holer.checkbox.setVisibility(View.GONE);
        }else {
            holer.checkbox.setVisibility(View.VISIBLE);
        }
        holer.goodsname.setText(list.get(position).getGoodsname());
        holer.yuanprice.setText("￥"+list.get(position).getYuanprice());
        holer.xianprice.setText("￥"+list.get(position).getXianprice());
        return convertview;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.right:
                if (ischecked){
                    ischecked=false;
                    right.setText("编辑");
                    layoutbuttom.setVisibility(View.GONE);
                }else {
                    ischecked=true;
                    right.setText("完成");
                    layoutbuttom.setVisibility(View.VISIBLE);
                }
                break;
        }
    }

    public class ViewHoler{
        private CheckBox checkbox;
        private TextView goodsname;
        private TextView yuanprice;
        private TextView xianprice;
    }
}

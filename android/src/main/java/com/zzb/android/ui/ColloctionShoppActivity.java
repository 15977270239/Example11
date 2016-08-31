package com.zzb.android.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.zzb.android.R;
import com.zzb.android.adapter.ColloctionGoodsAdapter;
import com.zzb.android.entiys.ColloctionGoods;

import java.util.ArrayList;
import java.util.List;


public class ColloctionShoppActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView back;
    private TextView title;
    private ListView listView;
    private Button right;
    private ColloctionGoods colloctionGoods;
    private List<ColloctionGoods> list;
    private ColloctionGoodsAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collctionshopp);
        initview();
        getData();
    }
    public void initview(){
        back=(ImageView)findViewById(R.id.back);
        title=(TextView)findViewById(R.id.title);
        right=(Button)findViewById(R.id.right);
        right.setText("编辑");
        right.setVisibility(View.VISIBLE);
        listView=(ListView)findViewById(R.id.collection_list);
        title.setText("商品收藏");
        back.setOnClickListener(this);
    }
    public void getData(){
        list = new ArrayList<>();
        colloctionGoods = new ColloctionGoods("你好我大家好才是真的好","12.00","10.36");
        list.add(colloctionGoods);
        colloctionGoods = new ColloctionGoods("dddddddddddddeeeeeeeeee","4.00","12.36");
        list.add(colloctionGoods);
        colloctionGoods = new ColloctionGoods("你好我大家好才是真的好","12.00","10.36");
        list.add(colloctionGoods);
        colloctionGoods = new ColloctionGoods("dddddddddddddeeeeeeeeee","4.00","12.36");
        list.add(colloctionGoods);colloctionGoods = new ColloctionGoods("你好我大家好才是真的好","12.00","10.36");
        list.add(colloctionGoods);
        colloctionGoods = new ColloctionGoods("dddddddddddddeeeeeeeeee","4.00","12.36");
        list.add(colloctionGoods);colloctionGoods = new ColloctionGoods("你好我大家好才是真的好","12.00","10.36");
        list.add(colloctionGoods);
        colloctionGoods = new ColloctionGoods("dddddddddddddeeeeeeeeee","4.00","12.36");
        list.add(colloctionGoods);


        adapter=new ColloctionGoodsAdapter(this,list);
        listView.setAdapter(adapter);
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

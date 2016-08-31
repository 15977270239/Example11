package com.zzb.android.entiys;

/**
 * Created by Bin on 2016/8/26.
 */
public class ColloctionGoods {
    private String goodsname;
    private String yuanprice;
    private String xianprice;
    public ColloctionGoods(String goodsname,String yuanprice,String xianprice){
        super();
        this.goodsname=goodsname;
        this.yuanprice=yuanprice;
        this.xianprice=xianprice;
    }
    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public String getYuanprice() {
        return yuanprice;
    }

    public void setYuanprice(String yuanprice) {
        this.yuanprice = yuanprice;
    }

    public String getXianprice() {
        return xianprice;
    }

    public void setXianprice(String xianprice) {
        this.xianprice = xianprice;
    }
}

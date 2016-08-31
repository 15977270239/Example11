package com.zzb.android.entiys;

/**
 * Created by Bin on 2016/8/21.
 */
public class Banner {
    // I/NetAccess(3112):
    // {"success":"true","message":"success","error_code":0,"data":{"img":"http:\/\/localhost\/show_love\/1.jpg","id":"1"}}

    public String img;
    public Banner(String img){
        super();
        this.img=img;
    }
    public String getImg() {
        return img;
    }
    public void setImg(String img) {
        this.img = img;
    }

}

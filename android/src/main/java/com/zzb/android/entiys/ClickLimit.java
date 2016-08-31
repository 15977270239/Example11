package com.zzb.android.entiys;

/**
 * Created by Bin on 2016/8/20.
 */
public class ClickLimit {
    private static long lastClickTime = 0;

    public static boolean canClick() {
        return canClick(300);
    }
    public static boolean canClick(int interval) {
        if ((System.currentTimeMillis() - lastClickTime) > interval) {
            lastClickTime = System.currentTimeMillis();
            return true;
        } else {
            return false;
        }
    }
}

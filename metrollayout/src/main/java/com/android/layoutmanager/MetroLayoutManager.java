package com.android.layoutmanager;

import android.util.Log;
import android.view.ViewGroup;

import com.android.type.MetroTypeConvert;


public abstract class MetroLayoutManager {
    private boolean mDebug = false;
    public Integer[][] mViewPosition;
    protected MetroTypeConvert mConvert;
    protected int mMinWidth;
    protected int mMinHeight;

    public MetroLayoutManager(MetroTypeConvert convert) {
        this.mConvert = convert;
        this.mViewPosition = autoSortChildView();
    }

    protected abstract Integer[][] autoSortChildView();

    public abstract void measureChildPostion(ViewGroup parent, int spaceWidth);

    public void bindMinChildSize(int minWidth, int minHeight) {
        this.mMinWidth = minWidth;
        this.mMinHeight = minHeight;
    }

    protected Integer[][] getViewPosition() {
        return mViewPosition;
    }

    protected void openDebug() {
        mDebug = true;
    }

    protected boolean isDebug() {
        return mDebug;
    }

    protected void log(String msg) {
        if (mDebug) {
            Log.e(this.getClass().getSimpleName(), msg);
        }
    }
}

package com.metrolviewdemo;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.base.BaseViewHolder;
import com.android.base.BaseMetroAdapter;
import com.android.type.MetroType;

public class HomeMetroAdapter extends BaseMetroAdapter<HomeMetroModel> {


    public HomeMetroAdapter(HomeMetroTypeConvers convers) {
        super(convers);
    }

    @Override
    public BaseViewHolder bindViewHolder() {
        return new MetroViewHolder();
    }

    private class MetroViewHolder extends BaseViewHolder<HomeMetroModel> {

        @Override
        protected MetroViewHolder bindView(Context context, HomeMetroModel model, ViewGroup parent) {
            if (MetroType.MAX == mViewType) {
                this.mRootView = LayoutInflater.from(context).inflate(R.layout.item_home_max, null);
            } else if (MetroType.MID == mViewType) {
                this.mRootView = LayoutInflater.from(context).inflate(R.layout.item_home_mid, null);
            } else {
                this.mRootView = LayoutInflater.from(context).inflate(R.layout.item_home_min, null);
            }
            return this;
        }

        @Override
        protected View bindData(HomeMetroModel model) {
            if (MetroType.MAX == mViewType) {
                setText(R.id.tv_name, model.getName());
            } else if (MetroType.MID == mViewType) {
                setText(R.id.tv_name, model.getName());
            } else {
                setText(R.id.tv_name, model.getName());
            }
            return mRootView;
        }
    }

}

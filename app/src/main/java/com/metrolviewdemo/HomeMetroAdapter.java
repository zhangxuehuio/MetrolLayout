package com.metrolviewdemo;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.OvershootInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.android.base.BaseMetroAdapter;
import com.android.base.BaseViewHolder;
import com.android.type.MetroType;
import com.bumptech.glide.Glide;

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
            String bgColor = model.getBgColor().trim();
            String name = model.getName().trim();
            final String imgUrl = "http://123.56.5.174/" + model.getImgUrl().trim();
            setText(R.id.tv_name, name);
            if (!TextUtils.isEmpty(bgColor)) {
                setBackgroundColor(R.id.rv_root, Color.parseColor(bgColor));
            }
            if (!TextUtils.isEmpty(imgUrl)) {
                setImageUrlForCallback(!TextUtils.isEmpty(bgColor) ? R.id.iv_logo : R.id.iv_bg, new OnImageLoaderListener() {
                    @Override
                    public void onImagerLoader(ImageView view) {
                        Glide.with(mRootView.getContext())
                                .load(imgUrl)
                                .into(view);
                    }
                });
            }
            setGone(R.id.tv_name, TextUtils.isEmpty(name));
            setGone(R.id.iv_bg, !TextUtils.isEmpty(bgColor));
            setGone(R.id.iv_logo, TextUtils.isEmpty(bgColor));
            return mRootView;
        }

        @Override
        protected MetroViewHolder bindViewAnimation(int position) {

            TranslateAnimation translateAnimation;

            if (position == 0) {
                translateAnimation = new TranslateAnimation(
                        Animation.RELATIVE_TO_SELF, 0,
                        Animation.RELATIVE_TO_SELF, 0,
                        Animation.RELATIVE_TO_SELF, -1,
                        Animation.RELATIVE_TO_SELF, 0);
            } else if (position > 0 && position < 4) {
                translateAnimation = new TranslateAnimation(
                        Animation.RELATIVE_TO_SELF, 0,
                        Animation.RELATIVE_TO_SELF, 0,
                        Animation.RELATIVE_TO_SELF, -1,
                        Animation.RELATIVE_TO_SELF, 0);
            } else if (position == 7) {
                translateAnimation = new TranslateAnimation(
                        Animation.RELATIVE_TO_SELF, -1,
                        Animation.RELATIVE_TO_SELF, 0,
                        Animation.RELATIVE_TO_SELF, 0,
                        Animation.RELATIVE_TO_SELF, 0);
            } else {
                translateAnimation = new TranslateAnimation(
                        Animation.RELATIVE_TO_SELF, 0,
                        Animation.RELATIVE_TO_SELF, 0,
                        Animation.RELATIVE_TO_SELF, 1,
                        Animation.RELATIVE_TO_SELF, 0);
            }
            translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
            translateAnimation.setDuration(500);
            mRootView.setAnimation(translateAnimation);
            return this;
        }
    }


}

package com.android.base;

import android.content.Context;
import android.support.annotation.IdRes;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.type.MetroType;

public abstract class BaseViewHolder<T> {
    protected View mRootView;
    protected MetroType mViewType;

    public BaseViewHolder() {
    }

    protected abstract BaseViewHolder<T> bindView(Context context, T model, ViewGroup parent);

    protected abstract View bindData(T model);

    protected abstract BaseViewHolder<T> bindViewAnimation(int position);

    protected BaseViewHolder<T> bindViewType(MetroType metroType) {
        this.mViewType = metroType;
        return this;
    }

    public BaseViewHolder<T> setText(@IdRes int resId, String text) {
        TextView textView = getView(resId);
        if (textView != null) {
            textView.setText(text);
        }
        return this;
    }

    public BaseViewHolder<T> setBackgroundColor(@IdRes int resId, int color) {
        View view = getView(resId);
        if (view != null) {
            view.setBackgroundColor(color);
        }
        return this;
    }

    public BaseViewHolder<T> setGone(@IdRes int resId, boolean isGone) {
        View view = getView(resId);
        if (view != null) {
            view.setVisibility(isGone ? View.GONE : View.VISIBLE);
        }
        return this;
    }

    public BaseViewHolder<T> setGone(boolean isGone) {
        if (mRootView != null) {
            mRootView.setVisibility(isGone ? View.GONE : View.VISIBLE);
        }
        return this;
    }

    public BaseViewHolder<T> setImageResource(@IdRes int resId, int imgId) {
        ImageView view = getView(resId);
        if (view != null) {
            view.setImageResource(imgId);
        }
        return this;
    }

    public BaseViewHolder<T> setImageUrlForCallback(@IdRes int resId, OnImageLoaderListener listener) {
        ImageView view = getView(resId);
        if (view != null && listener != null) {
            listener.onImagerLoader(view);
        }
        return this;
    }


    private <V extends View> V getView(@IdRes int resId) {
        V v = null;
        if (mRootView != null) {
            v = mRootView.findViewById(resId);
        }
        return v;
    }

    public interface OnImageLoaderListener {
        void onImagerLoader(ImageView view);
    }
}
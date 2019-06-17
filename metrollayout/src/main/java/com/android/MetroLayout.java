package com.android;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.android.base.BaseMetroAdapter;
import com.android.layoutmanager.MetroLayoutManager;
import com.android.type.MetroType;
import com.metrolview.R;

public class MetroLayout extends ViewGroup {
    private int mItemDividerSpace;
    private int mHorizontalGridCount;
    private int mVerticalGridCount;

    private BaseAdapter mAdapter;
    private MetroLayoutManager mLayoutManager;
    private MetroLayout.OnItemClickListener mListener;
    private MetroLayout.DataChangeObserver mObserver;

    public MetroLayout(Context context) {
        this(context, null);
    }

    public MetroLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MetroLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.MetroLayout);
        mItemDividerSpace = ta.getDimensionPixelSize(R.styleable.MetroLayout_ItemDividerSpace, 10);
        mHorizontalGridCount = ta.getInteger(R.styleable.MetroLayout_HorizontalGridCount, 7);
        mVerticalGridCount = ta.getInteger(R.styleable.MetroLayout_VerticalGridCount, 3);
        ta.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        measureChildSize(this, widthMeasureSpec, heightMeasureSpec);
    }

    private void measureChildSize(ViewGroup parent, int widthMeasureSpec, int heightMeasureSpec) {
        int parentWith = MeasureSpec.getSize(widthMeasureSpec);
        int parentHeight = MeasureSpec.getSize(heightMeasureSpec);
        Log.e("zxh", " px2dp ==> 10px = " + DensityUtil.px2dip(this.getContext(), 10));
//        Log.e("zxh", "measureChildSize    parentWith=" + parentWith + "    parentHeight=" + parentHeight);
        int totalHorizontalDividerSpace = mItemDividerSpace * (mHorizontalGridCount - 1);
        int totalVerticalDividerSpace = mItemDividerSpace * (mVerticalGridCount - 1);
        int minWidth = (parentWith - totalHorizontalDividerSpace) / mHorizontalGridCount;
        int minHeight = (parentHeight - totalVerticalDividerSpace) / mVerticalGridCount;
        if (mLayoutManager != null) {
            mLayoutManager.bindMinChildSize(minWidth, minHeight);
        }
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View childView = getChildAt(i);
            MetroType type = (MetroType) childView.getTag();
            int childWidth;
            int childHeight;
            if (type == MetroType.MAX) {
                childWidth = minWidth * 2 + mItemDividerSpace;
                childHeight = minHeight * 2 + mItemDividerSpace;
            } else if (type == MetroType.MID) {
                childWidth = minWidth * 2 + mItemDividerSpace;
                childHeight = minHeight;
            } else {
                childWidth = minWidth;
                childHeight = minHeight;
            }
            Log.e("zxh", "measureChildSize    childWidth=" + childWidth + "    childHeight=" + childHeight);
            childView.measure(MeasureSpec.makeMeasureSpec(childWidth, MeasureSpec.EXACTLY), MeasureSpec.makeMeasureSpec(childHeight, MeasureSpec.EXACTLY));
        }
    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if (mLayoutManager != null) {
            mLayoutManager.measureChildPostion(this, mItemDividerSpace);
        }
    }

    public void notifyDataSetChanged(BaseAdapter adapter) {
        if (mAdapter == null) {
            mAdapter = adapter;
            if (mAdapter instanceof BaseMetroAdapter) {
                mLayoutManager = ((BaseMetroAdapter) mAdapter).getLayoutManager();
            }
            if (mObserver == null) {
                mObserver = new MetroLayout.DataChangeObserver();
                mAdapter.registerDataSetObserver(mObserver);
            }
            drawLayout();
        }
        this.postInvalidate();
    }

    private void drawLayout() {
        if (mAdapter == null || mAdapter.getCount() == 0) {
            return;
        }
        this.removeAllViews();
        for (int i = 0; i < mAdapter.getCount(); i++) {
            View view = mAdapter.getView(i, null, this);
            final int position = i;
            view.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        mListener.itemClick(position);
                    }
                }
            });
            this.addView(view);
        }
    }

    public void setAdapter(BaseAdapter adapter) {
        if (mAdapter == null) {
            mAdapter = adapter;
            if (mAdapter instanceof BaseMetroAdapter) {
                mLayoutManager = ((BaseMetroAdapter) mAdapter).getLayoutManager();
            }
            if (mObserver == null) {
                mObserver = new MetroLayout.DataChangeObserver();
                mAdapter.registerDataSetObserver(mObserver);
            }
            drawLayout();
        }
        this.postInvalidate();
    }

    public void setItemClickListener(MetroLayout.OnItemClickListener mListener) {
        this.mListener = mListener;
    }

    /**
     * 单击监听接口
     */
    public interface OnItemClickListener {
        void itemClick(int position);
    }

    class DataChangeObserver extends DataSetObserver {
        @Override
        public void onChanged() {
            MetroLayout.this.drawLayout();
        }

        @Override
        public void onInvalidated() {
            super.onInvalidated();
        }
    }

}


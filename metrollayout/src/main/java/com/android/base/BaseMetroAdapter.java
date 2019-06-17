package com.android.base;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.android.type.MetroType;
import com.android.type.MetroTypeConvert;
import com.android.layoutmanager.AutoSortMetroLayoutManager;
import com.android.layoutmanager.MetroLayoutManager;


/**
 * home主界面的适配器
 */
public abstract class BaseMetroAdapter<T> extends BaseAdapter {
    private static final int ITEM_MAX = -2;
    private static final int ITEM_MID = -1;
    private static final int ITEM_MIN = 0;
    private static final String TAG = BaseMetroAdapter.class.getSimpleName();
    private MetroTypeConvert<T> mConvert;
    private MetroLayoutManager mLayoutManager;

    public BaseMetroAdapter(MetroTypeConvert<T> convert) {
        this.mConvert = convert;
        if (this.mConvert.isAutoSort()) {
            mLayoutManager = new AutoSortMetroLayoutManager(mConvert);
        }
    }

    public void setMetroSortStrategy(MetroLayoutManager sortStrategy) {
        mLayoutManager = sortStrategy;
    }

    /**
     * 获取布局管理器
     *
     * @return
     */
    public MetroLayoutManager getLayoutManager() {
        return mLayoutManager;
    }

    @Override
    public int getCount() {
        return mConvert.getListData().size();
    }

    @Override
    public T getItem(int position) {
        return mConvert.getItemData(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        MetroType type = mConvert.getViewType(position);
        if (type == MetroType.MAX) {
            return ITEM_MAX;
        } else if (type == MetroType.MID) {
            return ITEM_MID;
        } else {
            return ITEM_MIN;
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        T model = getItem(position);
        MetroType type = mConvert.getViewType(position);
        convertView = bindViewHolder()
                .bindViewType(type)
                .bindView(parent.getContext(), model, parent)
                .bindViewAnimation(position)
                .bindData(model);
        convertView.setTag(type);
        return convertView;
    }

    public abstract BaseViewHolder<T> bindViewHolder();

}

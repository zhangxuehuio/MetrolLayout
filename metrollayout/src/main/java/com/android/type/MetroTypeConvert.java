package com.android.type;

import java.util.List;

public abstract class MetroTypeConvert<T> {
    private List<T> mList;

    public MetroTypeConvert(List<T> list) {
        mList = list;
    }

    public abstract boolean isAutoSort();

    public abstract MetroType getViewType(int position);

    public T getItemData(int position) {
        return mList.get(position);
    }

    public List<T> getListData() {
        return mList;
    }
}

package com.metrolviewdemo;

import com.android.type.MetroType;
import com.android.type.MetroTypeConvert;

import java.util.List;

public class HomeMetroTypeConvers extends MetroTypeConvert<HomeMetroModel> {

    public HomeMetroTypeConvers(List<HomeMetroModel> list) {
        super(list);
    }

    @Override
    public boolean isAutoSort() {
        return true;
    }

    @Override
    public MetroType getViewType(int position) {
        String type = getItemData(position).getActionType();
        if ("max".equals(type)) {
            return MetroType.MAX;
        } else if ("mid".equals(type)) {
            return MetroType.MID;
        } else {
            return MetroType.MIN;
        }
    }
}

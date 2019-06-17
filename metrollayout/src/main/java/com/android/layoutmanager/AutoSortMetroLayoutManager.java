package com.android.layoutmanager;

import android.view.ViewGroup;

import com.android.type.MetroType;
import com.android.type.MetroTypeConvert;

import java.util.List;


public class AutoSortMetroLayoutManager extends MetroLayoutManager {


    public AutoSortMetroLayoutManager(MetroTypeConvert convert) {
        super(convert);
    }

    /**
     * 对模块的位置排序
     */
    @Override
    public Integer[][] autoSortChildView() {
        Integer[][] cubeArr = new Integer[3][7];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {
                cubeArr[i][j] = 0;
            }
        }
        int x = 0;
        int y = 0;
        List list = mConvert.getListData();
        for (int i = 0; i < list.size(); i++) {
            MetroType type = mConvert.getViewType(i);
            if (x >= 7) {
                x = 0;
                y++;
            }
            if (MetroType.MIN == type) {
                while (cubeArr[y][x] > 0) {
                    x++;
                    if (x >= 7) {
                        x = 0;
                        y++;
                    }
                }
                cubeArr[y][x] = 01;
            } else {
                if (x >= 6) {
                    if (y >= 2) {
                        break;
                    }
                    x = 0;
                    y++;
                }
                while (cubeArr[y][x] > 0 || cubeArr[y][x + 1] > 0) {
                    x++;
                    if (x >= 6) {
                        x = 0;
                        y++;
                    }
                    if (y > 2) {
                        break;
                    }
                }
                if (y > 2) {
                    break;
                }
                if (MetroType.MAX == type) {
                    cubeArr[y][x] = 41;
                    cubeArr[y + 1][x] = 43;
                    x++;
                    cubeArr[y][x] = 42;
                    cubeArr[y + 1][x] = 44;
                } else if (MetroType.MID == type) {
                    cubeArr[y][x] = 21;
                    x++;
                    cubeArr[y][x] = 22;
                }
            }
            x++;

        }
        if (isDebug()) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 7; j++) {
                    log((cubeArr[i][j] <= 1 ? "0" + cubeArr[i][j] : cubeArr[i][j]) + ",");
                }
                log("\n");
            }
        }
        return cubeArr;
    }


    /**
     * 测量子模块的位置
     */
    @Override
    public void measureChildPostion(ViewGroup parent, int spaceWidth) {
        if (getViewPosition() == null || getViewPosition().length == 0) {
            return;
        }
        int childLeft = 0;
        int childTop = 0;
        int postion = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {
                int tag = getViewPosition()[i][j];
                if (tag == 0 || tag == 1) {
                    parent.getChildAt(postion).layout(childLeft, childTop, childLeft + mMinWidth, childTop + mMinHeight);
                    childLeft += mMinWidth + spaceWidth;
                    postion++;
                } else if (tag > 20 && tag < 40) {
                    parent.getChildAt(postion).layout(childLeft, childTop, childLeft + 2 * mMinWidth + spaceWidth, childTop + mMinHeight);
                    childLeft += mMinWidth + spaceWidth + mMinWidth + spaceWidth;
                    j++;
                    postion++;
                } else if (tag > 40 && tag < 43) {
                    parent.getChildAt(postion).layout(childLeft, childTop, childLeft + 2 * mMinWidth + spaceWidth, childTop + 2 * mMinHeight + spaceWidth);
                    childLeft += mMinWidth + spaceWidth + mMinWidth + spaceWidth;
                    j++;
                    postion++;
                } else if (tag >= 43) {
                    childLeft += mMinWidth + spaceWidth;
                }

            }
            childLeft = 0;
            childTop += mMinHeight + spaceWidth;
        }
    }

}

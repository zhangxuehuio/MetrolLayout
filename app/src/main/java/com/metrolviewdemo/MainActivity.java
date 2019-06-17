package com.metrolviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.android.MetroLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final int ITEM_MAX = -2;
    public static final int ITEM_MID = -1;
    public static final int ITEM_MIN = 0;
    private MetroLayout mMvHome;
    private String mJsonStr = "{\n" +
            "    \"data\": [\n" +
            "        {\n" +
            "            \"id\": 8,\n" +
            "            \"name\": \" \",\n" +
            "            \"parentId\": 0,\n" +
            "            \"imgUrl\": \"Images/img01.png\",\n" +
            "            \"bgColor\": \"\",\n" +
            "            \"actionLogo\": \"\",\n" +
            "            \"actionOrderNumber\": 0,\n" +
            "            \"actionType\": \"max\",\n" +
            "            \"jumpToAction\": \"\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 1,\n" +
            "            \"name\": \"咨询服务\",\n" +
            "            \"parentId\": 0,\n" +
            "            \"imgUrl\": \"Images/icon03.png\",\n" +
            "            \"bgColor\": \"#5530be\",\n" +
            "            \"actionLogo\": \"\",\n" +
            "            \"actionOrderNumber\": 2,\n" +
            "            \"actionType\": \"mid\",\n" +
            "            \"jumpToAction\": \"reeman://m.libmanai.com/speech/SpeechServerActivity\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 2,\n" +
            "            \"name\": \"智能书目检索\",\n" +
            "            \"parentId\": 0,\n" +
            "            \"imgUrl\": \"images/icon14.png\",\n" +
            "            \"bgColor\": \"#9a07a0\",\n" +
            "            \"actionLogo\": \"\",\n" +
            "            \"actionOrderNumber\": 4,\n" +
            "            \"actionType\": \"mid\",\n" +
            "            \"jumpToAction\": \"/shumujiansuo.html\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 28,\n" +
            "            \"name\": \" \",\n" +
            "            \"parentId\": 0,\n" +
            "            \"imgUrl\": \"Images/img04.png\",\n" +
            "            \"bgColor\": \"\",\n" +
            "            \"actionLogo\": \"\",\n" +
            "            \"actionOrderNumber\": 6,\n" +
            "            \"actionType\": \"min\",\n" +
            "            \"jumpToAction\": \"\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 5,\n" +
            "            \"name\": \"本馆介绍\",\n" +
            "            \"parentId\": 0,\n" +
            "            \"imgUrl\": \"Images/icon05.png\",\n" +
            "            \"bgColor\": \"#3087ec\",\n" +
            "            \"actionLogo\": \"\",\n" +
            "            \"actionOrderNumber\": 8,\n" +
            "            \"actionType\": \"mid\",\n" +
            "            \"jumpToAction\": \"/benguanjieshao.html\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 29,\n" +
            "            \"name\": \" \",\n" +
            "            \"parentId\": 0,\n" +
            "            \"imgUrl\": \"Images/img06.png\",\n" +
            "            \"bgColor\": \"\",\n" +
            "            \"actionLogo\": \"\",\n" +
            "            \"actionOrderNumber\": 10,\n" +
            "            \"actionType\": \"mid\",\n" +
            "            \"jumpToAction\": \"\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 4,\n" +
            "            \"name\": \"个人中心\",\n" +
            "            \"parentId\": 0,\n" +
            "            \"imgUrl\": \"Images/icon07.png\",\n" +
            "            \"bgColor\": \"#0e50cb\",\n" +
            "            \"actionLogo\": \"\",\n" +
            "            \"actionOrderNumber\": 11,\n" +
            "            \"actionType\": \"min\",\n" +
            "            \"jumpToAction\": \"reeman://m.libmanai.com/login/LoginActivity\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 3,\n" +
            "            \"name\": \"数字资源数据库\",\n" +
            "            \"parentId\": 0,\n" +
            "            \"imgUrl\": \"Images/icon08.png\",\n" +
            "            \"bgColor\": \" #0290a4\",\n" +
            "            \"actionLogo\": \"\",\n" +
            "            \"actionOrderNumber\": 12,\n" +
            "            \"actionType\": \"mid\",\n" +
            "            \"jumpToAction\": \"/dianziziyuan.html\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 30,\n" +
            "            \"name\": \" \",\n" +
            "            \"parentId\": 0,\n" +
            "            \"imgUrl\": \"Images/img09.png\",\n" +
            "            \"bgColor\": \"\",\n" +
            "            \"actionLogo\": \"\",\n" +
            "            \"actionOrderNumber\": 14,\n" +
            "            \"actionType\": \"min\",\n" +
            "            \"jumpToAction\": \"\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 31,\n" +
            "            \"name\": \" \",\n" +
            "            \"parentId\": 0,\n" +
            "            \"imgUrl\": \"Images/img12.png\",\n" +
            "            \"bgColor\": \"\",\n" +
            "            \"actionLogo\": \"\",\n" +
            "            \"actionOrderNumber\": 16,\n" +
            "            \"actionType\": \"mid\",\n" +
            "            \"jumpToAction\": \"\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"id\": 32,\n" +
            "            \"name\": \" \",\n" +
            "            \"parentId\": 0,\n" +
            "            \"imgUrl\": \"Images/img13.png\",\n" +
            "            \"bgColor\": \"\",\n" +
            "            \"actionLogo\": \"\",\n" +
            "            \"actionOrderNumber\": 18,\n" +
            "            \"actionType\": \"mid\",\n" +
            "            \"jumpToAction\": \"\"\n" +
            "        }\n" +
            "    ],\n" +
            "    \"status\": true,\n" +
            "    \"errorNo\": 0,\n" +
            "    \"errorMessage\": \"\"\n" +
            "}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        mMvHome = findViewById(R.id.mv_home);
        getHomeMenuList();
    }

    /**
     * 检查手机号是否存在
     */
    private void getHomeMenuList() {
        try {
            JSONObject jsonObject = new JSONObject(mJsonStr);
            String jsonData = jsonObject.getString("data");
            Gson gson = new Gson();
            Type type = new TypeToken<List<HomeMetroModel>>() {}.getType();
            List<HomeMetroModel> list = gson.fromJson(jsonData, type);
            mMvHome.setAdapter(new HomeMetroAdapter(new HomeMetroTypeConvers(list)));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}

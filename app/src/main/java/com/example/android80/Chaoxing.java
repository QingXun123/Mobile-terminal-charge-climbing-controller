package com.example.android80;

import static com.example.android80.SendHttp.chaoxingcheck;
import static com.example.android80.SendHttp.chaoxinglogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;

public class Chaoxing extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chaoxing);

        new Thread(runnable).start();
    }

    @Override
    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.
//        }
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            JSONObject loginBody = new JSONObject();
            loginBody.put("uname", "13682348336");
            loginBody.put("code", "SzSz2003..");
            loginBody.put("loginType", "1");
            loginBody.put("roleSelect", "true");
            try {
                JSONObject jsonObject = chaoxinglogin("http://passport2.chaoxing.com/fanyalogin", loginBody);
//                JSONObject jsonObject = chaoxingcheck("https://mooc1-api.chaoxing.com/mycourse/backclazzdata", loginBody);
                System.out.println(jsonObject);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };

}

/*
    https://mobilelearn.chaoxing.com/pptSign/stuSignajax?enc= ${enc} &name= ${encodeURI(name)} &activeId= ${aid} &uid= ${uid} &clientip=&useragent=&latitude=-1&longitude=-1&fid= ${fid} &appType=15


*/
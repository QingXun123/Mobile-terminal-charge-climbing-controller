package com.example.android80;

import static com.example.android80.SendHttp.sendRequest;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.sql.Connection;

public class Console extends AppCompatActivity implements View.OnClickListener {
    private Button sendAll;
    private Button sendMe;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_console);

        sendAll = findViewById(R.id.sendAll);
        sendMe = findViewById(R.id.sendMe);

        sendAll.setOnClickListener(this);
        sendMe.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Electricity electricity = new Electricity();
        int num = 0;
        switch (v.getId()) {
            case R.id.sendAll:
                electricity.start();
                while(electricity.value == null && num < 10) {
                    try {
                        Thread.sleep(100);
                        num++;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (num < 10) {
                    new Thread(new SendTextMail("947338658@qq.com", "宿舍剩余电量：" + electricity.value, "")).start();
                    new Thread(new SendTextMail("2105287320@qq.com", "宿舍剩余电量：" + electricity.value, "")).start();
                    new Thread(new SendTextMail("1286805840@qq.com", "宿舍剩余电量：" + electricity.value, "")).start();
                    new Thread(new SendTextMail("2601260031@qq.com", "宿舍剩余电量：" + electricity.value, "")).start();
                    new Thread(new SendTextMail("1933727856@qq.com", "宿舍剩余电量：" + electricity.value, "")).start();
                    new Thread(new SendTextMail("3132475656@qq.com", "宿舍剩余电量：" + electricity.value, "")).start();
                    new Thread(new SendTextMail("2031915277@qq.com", "宿舍剩余电量：" + electricity.value, "")).start();
                    new Thread(new SendTextMail("c1470005346@163.com", "宿舍剩余电量：" + electricity.value, "")).start();
                    Toast.makeText(getApplicationContext(), "发送成功！", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "爬取失败！", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.sendMe:
                electricity.start();
                while(electricity.value == null && num < 10) {
                    try {
                        Thread.sleep(100);
                        num++;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (num < 10) {
                    new Thread(new SendTextMail("947338658@qq.com", "宿舍剩余电量：" + electricity.value, "")).start();
                    Toast.makeText(getApplicationContext(), "发送成功！", Toast.LENGTH_SHORT).show();
                } else {
                    //显示Toast信息
                    Toast.makeText(getApplicationContext(), "爬取失败！", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    Runnable login = new Runnable(){
        @Override
        public void run() {
            JSONObject loginBody = new JSONObject();
            loginBody.put("phone", "13682348336");
            loginBody.put("password", "SzSz2003..");
            try {
                JSONObject jsonObject = sendRequest("http://192.168.196.96:5000/login", loginBody);
                System.out.println(jsonObject);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };

//    Runnable test = new Runnable(){
//        @Override
//        public void run() {
//            try {
//                Connection con = MySQLConnections.getConnection();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    };
}
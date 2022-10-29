package com.example.android80;



import static android.content.ContentValues.TAG;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button loginBtn;
    private EditText editTextTextEmailAddress;
    private EditText editTextTextPassword;
    private SQLiteDatabase db;
    private MyDBOpenHelper myDBHelper;
    private StringBuilder sb;
    private Context mContext;
    private int i = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginBtn = (Button) findViewById(R.id.loginBtn);
        editTextTextEmailAddress = (EditText) findViewById(R.id.editTextTextEmailAddress);
        editTextTextPassword = (EditText) findViewById(R.id.editTextTextPassword);

        loginBtn.setOnClickListener(this);

        mContext = MainActivity.this;
        myDBHelper = new MyDBOpenHelper(mContext, "my.db", null, 1);
    }

    @Override
    public void onClick(View v) {
        db = myDBHelper.getWritableDatabase();
        switch (v.getId()) {
            case R.id.loginBtn:
                new Thread(electricity).start();
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
                System.out.println(jsonObject.get("UID"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };

    Runnable electricity = new Runnable(){
        @Override
        public void run() {
            JSONObject loginBody = new JSONObject();
            loginBody.put("jsondata", "{ \\\"query_elec_roominfo\\\": { \\\"aid\\\":\\\"0030000000002501\\\", \\\"account\\\": \\\"30483\\\",\\\"room\\\": { \\\"roomid\\\": \\\"201\\\", \\\"room\\\": \\\"201\\\" },  \\\"floor\\\": { \\\"floorid\\\": \\\"\\\", \\\"floor\\\": \\\"\\\" }, \\\"area\\\": { \\\"area\\\": \\\"嘉应学院\\\", \\\"areaname\\\": \\\"嘉应学院\\\" }, \\\"building\\\": { \\\"buildingid\\\": \\\"9318\\\", \\\"building\\\": \\\"中4A栋\\\" },\\\"extdata\\\":\\\"info1=\\\" } }");
            loginBody.put("funname", "synjones.onecard.query.elec.roominfo");
            loginBody.put("json", "true");
            try {
                JSONObject jsonObject = sendRequest("http://ecard.jyu.edu.cn:8988/web/Common/Tsm.html", loginBody);
                System.out.println(jsonObject.get("UID"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };

    Runnable test = new Runnable(){
        @Override
        public void run() {
            try {
                Connection con = MySQLConnections.getConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    public static JSONObject sendRequest(String urlParam, JSONObject b) throws IOException {
        try {
            //        params.setUseJsonStreamer(true);
            JSONObject body = b;
            URL url = new URL(urlParam);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            // 设置允许输出
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("POST");
            // 设置contentType
            conn.setRequestProperty("Content-Type", "application/json");
            DataOutputStream os = new DataOutputStream( conn.getOutputStream());
            String content = String.valueOf(body);
            os.writeBytes(content);
            os.flush();
            os.close();
            if(conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStreamReader in = new InputStreamReader(conn.getInputStream());
                BufferedReader bf = new BufferedReader(in);
                String recieveData = null;
                String result = "";
                while ((recieveData = bf.readLine()) != null){
                    result += recieveData + "\n";
                }
                JSONObject jsonObject =  JSON.parseObject(result);
                in.close();
                conn.disconnect();
                return jsonObject;
            }
        } catch (Exception e) {
            throw e;
        }
        return null;
    }
}
package com.example.android80;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private Button loginBtn;
    private EditText editTextTextEmailAddress;
    private EditText editTextTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginBtn = (Button) findViewById(R.id.loginBtn);
        editTextTextEmailAddress = (EditText) findViewById(R.id.editTextTextEmailAddress);
        editTextTextPassword = (EditText) findViewById(R.id.editTextTextPassword);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            //重写点击事件的处理方法onClick()
            @Override
            public void onClick(View v) {
                //显示Toast信息
//                Toast.makeText(getApplicationContext(), editTextTextEmailAddress.getText(), Toast.LENGTH_SHORT).show();
                new Thread(login).start();
            }
        });
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

    Runnable sign = new Runnable(){
        @Override
        public void run() {
            JSONObject signBody = new JSONObject();
            signBody.put("phone", "13682348336");
            signBody.put("password", "SzSz2003..");
            try {
                JSONObject jsonObject = sendRequest("http://192.168.196.96:5000/login", signBody);
                System.out.println(jsonObject.get("UID"));
            } catch (IOException e) {
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
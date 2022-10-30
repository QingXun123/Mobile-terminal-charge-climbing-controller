package com.example.android80;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 发送http数据包
 */
public class SendHttp {
    private SendHttp() {}
    public static JSONObject sendRequest(String urlParam, JSONObject body) throws IOException {
        try {
            //        params.setUseJsonStreamer(true);
            URL url = new URL(urlParam);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            // 设置允许输出
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("POST");
            // 设置contentType
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Accept-Encoding", "gzip, deflate");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.5112.102 Safari/537.36 Edg/104.0.1293.70");
            conn.setRequestProperty("Accept", "*/*");
            conn.setRequestProperty("Content-Length", "615");
            DataOutputStream os = new DataOutputStream( conn.getOutputStream());
            String content = JSON.toJSONString(body);
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

    public static JSONObject sendRequest(String urlParam, String content) throws IOException {
        try {
            //        params.setUseJsonStreamer(true);
            URL url = new URL(urlParam);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            // 设置允许输出
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("POST");
            // 设置contentType
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Accept-Encoding", "gzip, deflate");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.5112.102 Safari/537.36 Edg/104.0.1293.70");
            conn.setRequestProperty("Accept", "*/*");
            conn.setRequestProperty("Content-Length", "615");
            DataOutputStream os = new DataOutputStream( conn.getOutputStream());
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

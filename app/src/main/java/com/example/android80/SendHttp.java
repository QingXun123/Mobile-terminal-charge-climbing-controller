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

    public static JSONObject chaoxinglogin(String urlParam, JSONObject body) throws IOException {
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
//            conn.setRequestProperty("User-Agent", "Dalvik/2.1.0 (Linux; U; Android 11; M2007J3SC Build/RKQ1.200826.002) (device:M2007J3SC) Language/zh_CN com.chaoxing.mobile/ChaoXingStudy_3_5.1.3_android_phone_613_74 ");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("X-Requested-With", "XMLHttpRequest");
            DataOutputStream os = new DataOutputStream( conn.getOutputStream());
            String content = JSON.toJSONString(body);
            os.writeBytes(content);
            os.flush();
            os.close();
            if(conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStreamReader in = new InputStreamReader(conn.getInputStream());
                BufferedReader bf = new BufferedReader(in);
                StringBuilder builder = new StringBuilder();

                builder.append(conn.getResponseCode())
                        .append(" ")
                        .append(conn.getResponseMessage())
                        .append("\n");
                System.out.println(conn.getHeaderFields().entrySet());
                System.out.println(conn.getHeaderField("Set-Cookie"));
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

    public static JSONObject chaoxingcheck(String urlParam, JSONObject body) throws IOException {
        try {
            //        params.setUseJsonStreamer(true);
            URL url = new URL(urlParam);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            // 设置允许输出
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("GET");
            // 设置contentType
            conn.setRequestProperty("User-Agent", "Dalvik/2.1.0 (Linux; U; Android 11; M2007J3SC Build/RKQ1.200826.002) (device:M2007J3SC) Language/zh_CN com.chaoxing.mobile/ChaoXingStudy_3_5.1.3_android_phone_613_74 ");
            DataOutputStream os = new DataOutputStream( conn.getOutputStream());
            String content = JSON.toJSONString(body);
            os.writeBytes(content);
            os.flush();
            os.close();
            if(conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStreamReader in = new InputStreamReader(conn.getInputStream());
                BufferedReader bf = new BufferedReader(in);
                StringBuilder builder = new StringBuilder();

                builder.append(conn.getResponseCode())
                        .append(" ")
                        .append(conn.getResponseMessage())
                        .append("\n");
                System.out.println(conn.getHeaderFields().entrySet());
                System.out.println(conn.getHeaderField("Set-Cookie"));
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

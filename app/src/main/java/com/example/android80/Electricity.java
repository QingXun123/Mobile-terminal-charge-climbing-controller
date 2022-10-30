package com.example.android80;

import static com.example.android80.SendHttp.sendRequest;

import com.alibaba.fastjson.JSONObject;

import java.util.Objects;
import java.util.concurrent.Callable;

public class Electricity extends Thread {
    String value;

    public Electricity() {
    }

    public Electricity(String value) {
        this.value = value;
    }

    public void run() {
        JSONObject loginBody = new JSONObject();
        loginBody.put("jsondata", "{ \"query_elec_roominfo\": { \"aid\":\"0030000000002501\", \"account\": \"30483\",\"room\": { \"roomid\": \"201\", \"room\": \"201\" },  \"floor\": { \"floorid\": \"\", \"floor\": \"\" }, \"area\": { \"area\": \"嘉应学院\", \"areaname\": \"嘉应学院\" }, \"building\": { \"buildingid\": \"9318\", \"building\": \"中4A栋\" },\"extdata\":\"info1=\" } }");
        loginBody.put("funname", "synjones.onecard.query.elec.roominfo");
        loginBody.put("json", "true");
        try {
            JSONObject jsonObject = sendRequest("http://ecard.jyu.edu.cn:8988/web/Common/Tsm.html", "jsondata=%7B+%22query_elec_roominfo%22%3A+%7B+%22aid%22%3A%220030000000002501%22%2C+%22account%22%3A+%2230483%22%2C%22room%22%3A+%7B+%22roomid%22%3A+%22201%22%2C+%22room%22%3A+%22201%22+%7D%2C++%22floor%22%3A+%7B+%22floorid%22%3A+%22%22%2C+%22floor%22%3A+%22%22+%7D%2C+%22area%22%3A+%7B+%22area%22%3A+%22%E5%98%89%E5%BA%94%E5%AD%A6%E9%99%A2%22%2C+%22areaname%22%3A+%22%E5%98%89%E5%BA%94%E5%AD%A6%E9%99%A2%22+%7D%2C+%22building%22%3A+%7B+%22buildingid%22%3A+%229318%22%2C+%22building%22%3A+%22%E4%B8%AD4A%E6%A0%8B%22+%7D%2C%22extdata%22%3A%22info1%3D%22+%7D+%7D&funname=synjones.onecard.query.elec.roominfo&json=true");
            JSONObject jsonObject2 = jsonObject.getJSONObject("query_elec_roominfo");
            value = ((String) jsonObject2.get("errmsg")).substring(7);
            System.out.println(value);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

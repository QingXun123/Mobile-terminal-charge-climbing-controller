package com.example.android80;

import java.util.Objects;

public class ChaoMsg {
    private String fid;
    private String pid;
    private String refer;
    private String _blank;
    private String t;
    private String vc3;
    private String _uid;
    private String _d;
    private String uf;
    private String JSESSIONID;
    private String lv;
    private String UID;
    private String vc;
    private String vc2;
    private String xxtenc;
    private String DSSTASH_LOG;
    private String route;
    private String name;

    public ChaoMsg() {
    }

    public ChaoMsg(String fid, String pid, String refer, String _blank, String t, String vc3, String _uid, String _d, String uf, String JSESSIONID, String lv, String UID, String vc, String vc2, String xxtenc, String DSSTASH_LOG, String route, String name) {
        this.fid = fid;
        this.pid = pid;
        this.refer = refer;
        this._blank = _blank;
        this.t = t;
        this.vc3 = vc3;
        this._uid = _uid;
        this._d = _d;
        this.uf = uf;
        this.JSESSIONID = JSESSIONID;
        this.lv = lv;
        this.UID = UID;
        this.vc = vc;
        this.vc2 = vc2;
        this.xxtenc = xxtenc;
        this.DSSTASH_LOG = DSSTASH_LOG;
        this.route = route;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChaoMsg chaoMsg = (ChaoMsg) o;
        return Objects.equals(fid, chaoMsg.fid) && Objects.equals(pid, chaoMsg.pid) && Objects.equals(refer, chaoMsg.refer) && Objects.equals(_blank, chaoMsg._blank) && Objects.equals(t, chaoMsg.t) && Objects.equals(vc3, chaoMsg.vc3) && Objects.equals(_uid, chaoMsg._uid) && Objects.equals(_d, chaoMsg._d) && Objects.equals(uf, chaoMsg.uf) && Objects.equals(JSESSIONID, chaoMsg.JSESSIONID) && Objects.equals(lv, chaoMsg.lv) && Objects.equals(UID, chaoMsg.UID) && Objects.equals(vc, chaoMsg.vc) && Objects.equals(vc2, chaoMsg.vc2) && Objects.equals(xxtenc, chaoMsg.xxtenc) && Objects.equals(DSSTASH_LOG, chaoMsg.DSSTASH_LOG) && Objects.equals(route, chaoMsg.route) && Objects.equals(name, chaoMsg.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fid, pid, refer, _blank, t, vc3, _uid, _d, uf, JSESSIONID, lv, UID, vc, vc2, xxtenc, DSSTASH_LOG, route, name);
    }

    @Override
    public String toString() {
        return "ChaoMsg{" +
                "fid='" + fid + '\'' +
                ", pid='" + pid + '\'' +
                ", refer='" + refer + '\'' +
                ", _blank='" + _blank + '\'' +
                ", t='" + t + '\'' +
                ", vc3='" + vc3 + '\'' +
                ", _uid='" + _uid + '\'' +
                ", _d='" + _d + '\'' +
                ", uf='" + uf + '\'' +
                ", JSESSIONID='" + JSESSIONID + '\'' +
                ", lv='" + lv + '\'' +
                ", UID='" + UID + '\'' +
                ", vc='" + vc + '\'' +
                ", vc2='" + vc2 + '\'' +
                ", xxtenc='" + xxtenc + '\'' +
                ", DSSTASH_LOG='" + DSSTASH_LOG + '\'' +
                ", route='" + route + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getRefer() {
        return refer;
    }

    public void setRefer(String refer) {
        this.refer = refer;
    }

    public String get_blank() {
        return _blank;
    }

    public void set_blank(String _blank) {
        this._blank = _blank;
    }

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }

    public String getVc3() {
        return vc3;
    }

    public void setVc3(String vc3) {
        this.vc3 = vc3;
    }

    public String get_uid() {
        return _uid;
    }

    public void set_uid(String _uid) {
        this._uid = _uid;
    }

    public String get_d() {
        return _d;
    }

    public void set_d(String _d) {
        this._d = _d;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getJSESSIONID() {
        return JSESSIONID;
    }

    public void setJSESSIONID(String JSESSIONID) {
        this.JSESSIONID = JSESSIONID;
    }

    public String getLv() {
        return lv;
    }

    public void setLv(String lv) {
        this.lv = lv;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getVc() {
        return vc;
    }

    public void setVc(String vc) {
        this.vc = vc;
    }

    public String getVc2() {
        return vc2;
    }

    public void setVc2(String vc2) {
        this.vc2 = vc2;
    }

    public String getXxtenc() {
        return xxtenc;
    }

    public void setXxtenc(String xxtenc) {
        this.xxtenc = xxtenc;
    }

    public String getDSSTASH_LOG() {
        return DSSTASH_LOG;
    }

    public void setDSSTASH_LOG(String DSSTASH_LOG) {
        this.DSSTASH_LOG = DSSTASH_LOG;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

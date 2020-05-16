package com.example.aisuangua.pojo;

import java.util.Date;

public class Tiezi {
    private String id;

    private String userid;

    private String suerid;

    private String quetitle;

    private Integer queyuedusum;

    private Integer queanssum;

    private String quecainaid;

    private String quegrande;

    private String queasgbi;

    private Date quefabutime;

    private Date quecainatime;

    private Integer quezhidinsum;

    private Integer quejiami;

    private String tiezitypeid;

    private String quedouqitype;

    private String quecontent;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getSuerid() {
        return suerid;
    }

    public void setSuerid(String suerid) {
        this.suerid = suerid == null ? null : suerid.trim();
    }

    public String getQuetitle() {
        return quetitle;
    }

    public void setQuetitle(String quetitle) {
        this.quetitle = quetitle == null ? null : quetitle.trim();
    }

    public Integer getQueyuedusum() {
        return queyuedusum;
    }

    public void setQueyuedusum(Integer queyuedusum) {
        this.queyuedusum = queyuedusum;
    }

    public Integer getQueanssum() {
        return queanssum;
    }

    public void setQueanssum(Integer queanssum) {
        this.queanssum = queanssum;
    }

    public String getQuecainaid() {
        return quecainaid;
    }

    public void setQuecainaid(String quecainaid) {
        this.quecainaid = quecainaid == null ? null : quecainaid.trim();
    }

    public String getQuegrande() {
        return quegrande;
    }

    public void setQuegrande(String quegrande) {
        this.quegrande = quegrande == null ? null : quegrande.trim();
    }

    public String getQueasgbi() {
        return queasgbi;
    }

    public void setQueasgbi(String queasgbi) {
        this.queasgbi = queasgbi == null ? null : queasgbi.trim();
    }

    public Date getQuefabutime() {
        return quefabutime;
    }

    public void setQuefabutime(Date quefabutime) {
        this.quefabutime = quefabutime;
    }

    public Date getQuecainatime() {
        return quecainatime;
    }

    public void setQuecainatime(Date quecainatime) {
        this.quecainatime = quecainatime;
    }

    public Integer getQuezhidinsum() {
        return quezhidinsum;
    }

    public void setQuezhidinsum(Integer quezhidinsum) {
        this.quezhidinsum = quezhidinsum;
    }

    public Integer getQuejiami() {
        return quejiami;
    }

    public void setQuejiami(Integer quejiami) {
        this.quejiami = quejiami;
    }

    public String getTiezitypeid() {
        return tiezitypeid;
    }

    public void setTiezitypeid(String tiezitypeid) {
        this.tiezitypeid = tiezitypeid == null ? null : tiezitypeid.trim();
    }

    public String getQuedouqitype() {
        return quedouqitype;
    }

    public void setQuedouqitype(String quedouqitype) {
        this.quedouqitype = quedouqitype == null ? null : quedouqitype.trim();
    }

    public String getQuecontent() {
        return quecontent;
    }

    public void setQuecontent(String quecontent) {
        this.quecontent = quecontent == null ? null : quecontent.trim();
    }
}
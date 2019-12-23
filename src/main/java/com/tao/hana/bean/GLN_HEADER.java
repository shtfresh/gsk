package com.tao.hana.bean;

/**
 * Copyright 2019 bejson.com
 */


import com.alibaba.fastjson.annotation.JSONField;

/**
 * Auto-generated: 2019-12-20 11:38:9
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class GLN_HEADER {

    @JSONField(name="REQ_ORG_CODE")
    private String REQ_ORG_CODE;
    @JSONField(name="REQ_ORG_TX_DATE")
    private String REQ_ORG_TX_DATE;
    @JSONField(name="REQ_ORG_TX_TIME")
    private String REQ_ORG_TX_TIME;
    @JSONField(name="REQ_ORG_TX_NO")
    private String REQ_ORG_TX_NO;
    @JSONField(name="GLN_TX_NO")
    private String GLN_TX_NO;
    @JSONField(name="RES_ORG_TX_NO")
    private String RES_ORG_TX_NO;
    @JSONField(name="RES_CODE")
    private String RES_CODE;
    @JSONField(name="REQ_ORG_AREA")
    private String REQ_ORG_AREA;

    public void setREQ_ORG_CODE(String REQ_ORG_CODE) {
        this.REQ_ORG_CODE = REQ_ORG_CODE;
    }
    public String getREQ_ORG_CODE() {
        return REQ_ORG_CODE;
    }

    public void setREQ_ORG_TX_DATE(String REQ_ORG_TX_DATE) {
        this.REQ_ORG_TX_DATE = REQ_ORG_TX_DATE;
    }
    public String getREQ_ORG_TX_DATE() {
        return REQ_ORG_TX_DATE;
    }

    public void setREQ_ORG_TX_TIME(String REQ_ORG_TX_TIME) {
        this.REQ_ORG_TX_TIME = REQ_ORG_TX_TIME;
    }
    public String getREQ_ORG_TX_TIME() {
        return REQ_ORG_TX_TIME;
    }

    public void setREQ_ORG_TX_NO(String REQ_ORG_TX_NO) {
        this.REQ_ORG_TX_NO = REQ_ORG_TX_NO;
    }
    public String getREQ_ORG_TX_NO() {
        return REQ_ORG_TX_NO;
    }

    public void setGLN_TX_NO(String GLN_TX_NO) {
        this.GLN_TX_NO = GLN_TX_NO;
    }
    public String getGLN_TX_NO() {
        return GLN_TX_NO;
    }

    public void setRES_ORG_TX_NO(String RES_ORG_TX_NO) {
        this.RES_ORG_TX_NO = RES_ORG_TX_NO;
    }
    public String getRES_ORG_TX_NO() {
        return RES_ORG_TX_NO;
    }

    public void setRES_CODE(String RES_CODE) {
        this.RES_CODE = RES_CODE;
    }
    public String getRES_CODE() {
        return RES_CODE;
    }

    public void setREQ_ORG_AREA(String REQ_ORG_AREA) {
        this.REQ_ORG_AREA = REQ_ORG_AREA;
    }
    public String getREQ_ORG_AREA() {
        return REQ_ORG_AREA;
    }

}
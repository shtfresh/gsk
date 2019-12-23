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
public class GLN_BODY {

    @JSONField(name="PAY_CODE")
    private String PAY_CODE;
    @JSONField(name="REQ_CUR_CODE")
    private String REQ_CUR_CODE;
    @JSONField(name="REQ_AMOUNT")
    private String REQ_AMOUNT;
    @JSONField(name="MERCHANT_NAME")
    private String MERCHANT_NAME;
    @JSONField(name="MERCHANT_NAT_CODE")
    private String MERCHANT_NAT_CODE;
    @JSONField(name="MERCHANT_ID")
    private String MERCHANT_ID;
    @JSONField(name="TERMINAL_ID")
    private String TERMINAL_ID;
    @JSONField(name="PAYMENT_NO")
    private String PAYMENT_NO;
    @JSONField(name="MERCHANT_LOCATION")
    private String MERCHANT_LOCATION;
    @JSONField(name="MERCHANT_CATEGORY_CODE")
    private String MERCHANT_CATEGORY_CODE;

    @JSONField(name="MERCHANT_LOCATION")
    public String getMERCHANT_LOCATION() {
        return MERCHANT_LOCATION;
    }
    @JSONField(name="MERCHANT_LOCATION")
    public void setMERCHANT_LOCATION(String MERCHANT_LOCATION) {
        this.MERCHANT_LOCATION = MERCHANT_LOCATION;
    }
    @JSONField(name="MERCHANT_CATEGORY_CODE")
    public String getMERCHANT_CATEGORY_CODE() {
        return MERCHANT_CATEGORY_CODE;
    }
    @JSONField(name="MERCHANT_CATEGORY_CODE")
    public void setMERCHANT_CATEGORY_CODE(String MERCHANT_CATEGORY_CODE) {
        this.MERCHANT_CATEGORY_CODE = MERCHANT_CATEGORY_CODE;
    }
    @JSONField(name="PAY_CODE")
    public void setPAY_CODE(String PAY_CODE) {
        this.PAY_CODE = PAY_CODE;
    }
    @JSONField(name="PAY_CODE")
    public String getPAY_CODE() {
        return PAY_CODE;
    }

    @JSONField(name="REQ_CUR_CODE")
    public void setREQ_CUR_CODE(String REQ_CUR_CODE) {
        this.REQ_CUR_CODE = REQ_CUR_CODE;
    }
    @JSONField(name="REQ_CUR_CODE")
    public String getREQ_CUR_CODE() {
        return REQ_CUR_CODE;
    }

    @JSONField(name="REQ_AMOUNT")
    public void setREQ_AMOUNT(String REQ_AMOUNT) {
        this.REQ_AMOUNT = REQ_AMOUNT;
    }
    @JSONField(name="REQ_AMOUNT")
    public String getREQ_AMOUNT() {
        return REQ_AMOUNT;
    }

    @JSONField(name="MERCHANT_NAME")
    public void setMERCHANT_NAME(String MERCHANT_NAME) {
        this.MERCHANT_NAME = MERCHANT_NAME;
    }
    @JSONField(name="MERCHANT_NAME")
    public String getMERCHANT_NAME() {
        return MERCHANT_NAME;
    }

    @JSONField(name="MERCHANT_NAT_CODE")
    public void setMERCHANT_NAT_CODE(String MERCHANT_NAT_CODE) {
        this.MERCHANT_NAT_CODE = MERCHANT_NAT_CODE;
    }
    @JSONField(name="MERCHANT_NAT_CODE")
    public String getMERCHANT_NAT_CODE() {
        return MERCHANT_NAT_CODE;
    }

    @JSONField(name="MERCHANT_ID")
    public void setMERCHANT_ID(String MERCHANT_ID) {
        this.MERCHANT_ID = MERCHANT_ID;
    }
    @JSONField(name="MERCHANT_ID")
    public String getMERCHANT_ID() {
        return MERCHANT_ID;
    }

    @JSONField(name="MERCHANT_ID")
    public void setTERMINAL_ID(String TERMINAL_ID) {
        this.TERMINAL_ID = TERMINAL_ID;
    }
    @JSONField(name="MERCHANT_ID")
    public String getTERMINAL_ID() {
        return TERMINAL_ID;
    }

    @JSONField(name="PAYMENT_NO")
    public void setPAYMENT_NO(String PAYMENT_NO) {
        this.PAYMENT_NO = PAYMENT_NO;
    }
    @JSONField(name="PAYMENT_NO")
    public String getPAYMENT_NO() {
        return PAYMENT_NO;
    }

}
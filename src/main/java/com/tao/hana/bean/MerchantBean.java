package com.tao.hana.bean;

import com.alibaba.fastjson.annotation.JSONField;

public class MerchantBean {


    private  String merchantId;

    private String merchantName;

    private String merchantPassWord;

    private String merchantCategoryCode;
    private String merchantLocation;

    private String message;
    private String code;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMerchantCategoryCode() {
        return merchantCategoryCode;
    }

    public void setMerchantCategoryCode(String merchantCategoryCode) {
        this.merchantCategoryCode = merchantCategoryCode;
    }

    public String getMerchantLocation() {
        return merchantLocation;
    }

    public void setMerchantLocation(String merchantLocation) {
        this.merchantLocation = merchantLocation;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getMerchantPassWord() {
        return merchantPassWord;
    }

    public void setMerchantPassWord(String merchantPassWord) {
        this.merchantPassWord = merchantPassWord;
    }
}

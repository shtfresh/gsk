package com.tao.hana.bean;

import com.alibaba.fastjson.annotation.JSONField;

public class MerchantBean {


    private  String merchantId;

    private String merchantName;

    private String merchantPassWord;


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
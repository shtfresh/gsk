package com.tao.hana.bean;

public class TransactionsBean {

    private String glnTxNumber;
    private String localTxNumber;
    private String amount;
    private String currency;
    private int status;

    public String getGlnTxNumber() {
        return glnTxNumber;
    }

    public void setGlnTxNumber(String glnTxNumber) {
        this.glnTxNumber = glnTxNumber;
    }

    public String getLocalTxNumber() {
        return localTxNumber;
    }

    public void setLocalTxNumber(String localTxNumber) {
        this.localTxNumber = localTxNumber;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

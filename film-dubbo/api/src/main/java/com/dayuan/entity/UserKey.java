package com.dayuan.entity;

import java.io.Serializable;

public class UserKey implements Serializable {
    private Integer id;

    private String cardNo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }
}
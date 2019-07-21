package com.example.siva1.change;

import java.io.Serializable;
import java.util.List;

public class Merchant implements Serializable{
    int merchantId;
    String merchantName;
    List<Order> orderList;

    public Merchant(int merchantId, String merchantName, List<Order> orderList) {
        this.merchantId = merchantId;
        this.merchantName = merchantName;
        this.orderList = orderList;
    }

    public int getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(int merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    @Override
    public String toString() {
        return "Merchant{" +
                "merchantId=" + merchantId +
                ", merchantName='" + merchantName + '\'' +
                ", orderList=" + orderList +
                '}';
    }
}

package com.example.siva1.change;

import java.io.Serializable;
import java.util.List;

public class Order implements Serializable {
double amount;
String phoneNumber;
int orderId;
String customerName;
String placedTime;
List<List<String>> itemList;

    public Order(double amount, String phoneNumber, int orderId, String customerName, String placedTime, List<List<String>> itemList) {
        this.amount = amount;
        this.phoneNumber = phoneNumber;
        this.orderId = orderId;
        this.customerName = customerName;
        this.placedTime = placedTime;
        this.itemList = itemList;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPlacedTime() {
        return placedTime;
    }

    public void setPlacedTime(String placedTime) {
        this.placedTime = placedTime;
    }

    public List<List<String>> getItemList() {
        return itemList;
    }

    public void setItemList(List<List<String>> itemList) {
        this.itemList = itemList;
    }

    @Override
    public String toString() {
        return "Order{" +
                "amount=" + amount +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", orderId=" + orderId +
                ", customerName='" + customerName + '\'' +
                ", placedTime='" + placedTime + '\'' +
                ", itemList=" + itemList +
                '}';
    }


}

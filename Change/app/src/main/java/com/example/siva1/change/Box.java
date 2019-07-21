package com.example.siva1.change;

import java.io.Serializable;

public class Box implements Serializable{
    int boxName;
    String mobNum;

    public int getBoxName() {
        return boxName;
    }

    public void setBoxName(int boxName) {
        this.boxName = boxName;
    }

    public String getMobNum() {
        return mobNum;
    }

    public void setMobNum(String mobNum) {
        this.mobNum = mobNum;
    }

    public Box(int boxName, String mobNum) {
        this.boxName = boxName;
        this.mobNum = mobNum;
    }
}

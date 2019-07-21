package com.example.siva1.change;

import java.io.Serializable;
import java.util.List;

public class Panel implements Serializable {
    int panelId;
    String panelName;
    List<Merchant> merchantList;

    public Panel(int panelId, String panelName, List<Merchant> merchantList) {
        this.panelId = panelId;
        this.panelName = panelName;
        this.merchantList = merchantList;
    }

    public int getPanelId() {
        return panelId;
    }

    public void setPanelId(int panelId) {
        this.panelId = panelId;
    }

    public String getPanelName() {
        return panelName;
    }

    public void setPanelName(String panelName) {
        this.panelName = panelName;
    }

    public List<Merchant> getMerchantList() {
        return merchantList;
    }

    public void setMerchantList(List<Merchant> merchantList) {
        this.merchantList = merchantList;
    }

    @Override
    public String toString() {
        return "Panel{" +
                "panelId=" + panelId +
                ", panelName='" + panelName + '\'' +
                ", merchantList=" + merchantList +
                '}';
    }
}

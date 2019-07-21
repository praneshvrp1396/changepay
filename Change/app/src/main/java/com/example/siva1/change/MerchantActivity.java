package com.example.siva1.change;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MerchantActivity extends AppCompatActivity {
    ExpandableListView expandableListView;
    MerchantListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<Order>> expandableListDetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merchant);
        Panel selectedPanel= (Panel) getIntent().getSerializableExtra("panel");
        List<Merchant>activeMerchants=selectedPanel.getMerchantList();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        expandableListTitle=new ArrayList<>();
        expandableListDetail=new HashMap<>();
        for (Merchant merchant:activeMerchants) {
            expandableListTitle.add(merchant.getMerchantName());
            expandableListDetail.put(merchant.getMerchantName(),merchant.getOrderList());
        }
        expandableListView=findViewById(R.id.elv_merchant);
        expandableListAdapter = new MerchantListAdapter(this, expandableListTitle, expandableListDetail);
        expandableListView.setAdapter(expandableListAdapter);
    }

}

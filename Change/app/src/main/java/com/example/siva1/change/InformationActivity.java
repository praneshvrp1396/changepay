package com.example.siva1.change;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;

public class InformationActivity extends AppCompatActivity {
Retrofit retrofit;
    BluetoothAdapter mBluetoothAdapter;
    private ArrayList<BluetoothDevice> mDeviceList = new ArrayList<BluetoothDevice>();
    BluetoothSocket mmSocket;
    BluetoothDevice mmDevice;
    OutputStream mmOutputStream;
    InputStream mmInputStream;
    private List<Panel> panelArrayList = new ArrayList<>();
    private RecyclerView recyclerView;
    private PanelAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView=findViewById(R.id.rv_panel);
        List<Order>orderList=new ArrayList<>();
        orderList.add(new Order(500,"7904035546",2,"pranesh","5:00",null));
        orderList.add(new Order(500,"7904035546",2,"pranesh","5:00",null));
        orderList.add(new Order(500,"7904035546",2,"pranesh","5:00",null));
        orderList.add(new Order(500,"7904035546",2,"pranesh","5:00",null));
        orderList.add(new Order(500,"7904035546",2,"pranesh","5:00",null));
        Merchant merchant=new Merchant(1,"Merchant 1",orderList);
        List<Merchant> merchantList=new ArrayList<>();
        merchantList.add(merchant);
        panelArrayList.add(new Panel(1,"Tower 1",merchantList));
        mAdapter=new PanelAdapter(panelArrayList);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setAdapter(mAdapter);
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                    Panel panel=panelArrayList.get(position);
                    Intent intent=new Intent(InformationActivity.this,MerchantActivity.class);
                    intent.putExtra("panel",panel);
                    startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
//        retrofit = new Retrofit.Builder()
//                .baseUrl("https://reqres.in/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        APIClass apiClass=retrofit.create(APIClass.class);
//        apiClass.getPanelList().enqueue(new Callback<List<Panel>>() {
//            @Override
//            public void onResponse(Call<List<Panel>> call, Response<List<Panel>> response) {
//                System.out.println("sucess"+response.body());
//            }
//
//            @Override
//            public void onFailure(Call<List<Panel>> call, Throwable t) {
//            System.out.println(t);
//            }
//        });
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}

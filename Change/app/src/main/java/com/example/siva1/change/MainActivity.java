package com.example.siva1.change;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Set;
import java.util.UUID;

import co.aenterhy.toggleswitch.ToggleSwitchButton;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    BluetoothAdapter mBluetoothAdapter;
    private ArrayList<BluetoothDevice> mDeviceList = new ArrayList<BluetoothDevice>();
    Retrofit retrofit;
    EditText email,pass;
    BluetoothSocket mmSocket;
    BluetoothDevice mmDevice;
    OutputStream mmOutputStream;
    InputStream mmInputStream;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        ToggleSwitchButton toggle = (ToggleSwitchButton) findViewById(R.id.toggle);
        toggle.setOnTriggerListener(new ToggleSwitchButton.OnTriggerListener() {
            @Override
            public void toggledUp() {
                mBluetoothAdapter	= BluetoothAdapter.getDefaultAdapter();
//                if(mBluetoothAdapter.isEnabled()){
//                    mBluetoothAdapter.startDiscovery();
//
//                }else {
//                    Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
//
//                    startActivityForResult(intent, 1000);
//                    mBluetoothAdapter.startDiscovery();
//
//                }
//                IntentFilter filter = new IntentFilter();
//
//                filter.addAction(BluetoothAdapter.ACTION_STATE_CHANGED);
//                filter.addAction(BluetoothDevice.ACTION_FOUND);
//                filter.addAction(BluetoothAdapter.ACTION_DISCOVERY_STARTED);
//                filter.addAction(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
//                filter.addAction(BluetoothDevice.ACTION_PAIRING_REQUEST);
                Set<BluetoothDevice> pairedDevices = mBluetoothAdapter.getBondedDevices();
                if(pairedDevices.size() > 0)
                {
                    for(BluetoothDevice device : pairedDevices)
                    {
                        if(device.getName().equals("Change_PAY"))//FireFly-B1A7Change to the name of your bluetooth module (Case sensitive)
                        {
                            mmDevice = device;
                            break;
                        }
                    }
                }
                UUID uuid = UUID.fromString("00001101-0000-1000-8000-00805f9b34fb"); //Standard //SerialPortService ID

                try {
                    mmSocket = mmDevice.createRfcommSocketToServiceRecord(uuid);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    mmSocket.connect();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    mmOutputStream = mmSocket.getOutputStream();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    mmInputStream = mmSocket.getInputStream();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    mmOutputStream.write('1');
                } catch (IOException e) {
                    e.printStackTrace();
                }


//                registerReceiver(mReceiver, filter);
                Toast.makeText(MainActivity.this, "Camera", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void toggledDown() {
                email=findViewById(R.id.et_email);
                pass=findViewById(R.id.et_pass);

                retrofit = new Retrofit.Builder()
                        .baseUrl("https://reqres.in/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                APIClass apiClass=retrofit.create(APIClass.class);

//                apiClass.getVerified(email.getText().toString(),pass.getText().toString()).enqueue(new Callback<OTPResp>() {
//                    @Override
//                    public void onResponse(Call<OTPResp> call, Response<OTPResp> response) {
//                        if(response.body()!=null){
//                            Toast.makeText(MainActivity.this,"User verified",Toast.LENGTH_LONG).show();
//                        }else{
//                            Toast.makeText(MainActivity.this,"User doesnot exist",Toast.LENGTH_LONG).show();
//
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<OTPResp> call, Throwable t) {
//
//                    }
//                });
                Toast.makeText(MainActivity.this, "Audio", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();

            if (BluetoothAdapter.ACTION_STATE_CHANGED.equals(action)) {
                final int state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, BluetoothAdapter.ERROR);

                if (state == BluetoothAdapter.STATE_ON) {
//                    showToast("Enabled");
//
//                    showEnabled();
                }
            } else if (BluetoothAdapter.ACTION_DISCOVERY_STARTED.equals(action)) {
                System.out.println("started");
                mDeviceList = new ArrayList<BluetoothDevice>();

            } else if (BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(action)) {
                System.out.println("finsinhed");

//                Intent newIntent = new Intent(MainActivity.this, SampleActivity.class);
                mDeviceList=new ArrayList<>(mBluetoothAdapter.getBondedDevices());
//                newIntent.putParcelableArrayListExtra("device.list", mDeviceList);
//
//                startActivity(newIntent);
            } else if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                BluetoothDevice device = (BluetoothDevice) intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);

                mDeviceList.add(device);

                System.out.println("Found device " + device.getName());
            }else if(action.equals("android.bluetooth.device.action.PAIRING_REQUEST")){

            }
        }
    };
    public void setBluetoothPairingPin(BluetoothDevice device)
    {
        String pin="0000";
        byte[] pinBytes = pin.getBytes();
        try {
            Method m = device.getClass().getMethod("setPin", byte[].class);
            m.invoke(device, pinBytes);
            try {
                device.getClass().getMethod("setPairingConfirmation", boolean.class).invoke(device, true);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

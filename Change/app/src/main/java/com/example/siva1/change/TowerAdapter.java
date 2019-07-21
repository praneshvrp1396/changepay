package com.example.siva1.change;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class TowerAdapter extends RecyclerView.Adapter<TowerAdapter.MyTowerAdapter> {
    List<Box>boxList;
    TowerAdapter(List<Box> boxList){
        this.boxList=boxList;
    }

    @Override
    public TowerAdapter.MyTowerAdapter onCreateViewHolder(ViewGroup parent, int viewType) {
        View item= LayoutInflater.from(parent.getContext()).inflate(R.layout.tower_view,parent,false);
        return new TowerAdapter.MyTowerAdapter(item);
    }

    @Override
    public void onBindViewHolder(TowerAdapter.MyTowerAdapter holder, final int position) {
        Box selectedBox=boxList.get(position);
        holder.boxNum.setText(Integer.toString(selectedBox.getBoxName()));
        holder.mobNum.setText(selectedBox.getMobNum());
        holder.openBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"Box"+String.valueOf(position)+"has been opened",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return boxList.size();
    }

    public class MyTowerAdapter extends RecyclerView.ViewHolder{
        public TextView boxNum;
        public TextView mobNum;
        public Button openBox;
        public MyTowerAdapter(View itemView) {
            super(itemView);
            boxNum=itemView.findViewById(R.id.tv_box_no);
            mobNum=itemView.findViewById(R.id.tv_mob_no);
            openBox=itemView.findViewById(R.id.bt_box_open);
        }
    }
}

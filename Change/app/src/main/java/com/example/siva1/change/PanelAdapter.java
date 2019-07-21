package com.example.siva1.change;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class PanelAdapter extends RecyclerView.Adapter<PanelAdapter.MyPanelAdapter> {
    public List<Panel> panelList;

    public PanelAdapter(List<Panel> panelList) {
        this.panelList = panelList;
    }

    @Override
    public MyPanelAdapter onCreateViewHolder(ViewGroup parent, int viewType) {
        View item= LayoutInflater.from(parent.getContext()).inflate(R.layout.panel_view,parent,false);
        return new MyPanelAdapter(item);
    }

    @Override
    public void onBindViewHolder(MyPanelAdapter holder, int position) {
        Panel selectedPanel=panelList.get(position);
        holder.panelName.setText(selectedPanel.getPanelName());

    }

    @Override
    public int getItemCount() {
        return panelList.size();
    }

    public class MyPanelAdapter extends RecyclerView.ViewHolder{
        public TextView panelName;
        public MyPanelAdapter(View itemView) {
            super(itemView);
            panelName=itemView.findViewById(R.id.tv_panelname);
        }
    }
}

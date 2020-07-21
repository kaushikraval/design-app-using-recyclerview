package com.demo.designappdemo.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.demo.designappdemo.Interface.RecyclerviewInterface;
import com.demo.designappdemo.models.MainList;
import com.demo.designappdemo.R;

import java.util.List;

public class MainListAdapter extends RecyclerView.Adapter<MainListAdapter.MyViewHolder> {

    private List<MainList> mainLists;
    private RecyclerviewInterface recyclerviewInterface;

    public MainListAdapter(List<MainList> mainLists,RecyclerviewInterface listener) {
        this.mainLists = mainLists;
        this.recyclerviewInterface = listener;
    }

    @NonNull
    @Override
    public MainListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_list,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainListAdapter.MyViewHolder holder, int position) {
            MainList list = mainLists.get(position);
            holder.mainTextView.setText(list.getTitle());
    }

    @Override
    public int getItemCount() {
        return mainLists.size();
    }

    public  class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView mainTextView;

        public MyViewHolder(@NonNull final View itemView) {
            super(itemView);

            mainTextView = itemView.findViewById(R.id.tvMain);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        recyclerviewInterface.onItemClick(getAdapterPosition());
                }
            });
        }

    }

}

package com.demo.designappdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.demo.designappdemo.Interface.RecyclerviewInterface;
import com.demo.designappdemo.adapters.MainListAdapter;
import com.demo.designappdemo.models.MainList;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerviewInterface {

    private List<MainList> list = new ArrayList<>();
    private RecyclerView recyclerView;
    private MainListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.MainRecycler);

        adapter = new MainListAdapter(list,this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepareData();

    }

    private void prepareData() {

        MainList mainList = new MainList("People You May Know");
        list.add(mainList);

        mainList = new MainList("Campaigns");
        list.add(mainList);

        mainList = new MainList("Trending Post");
        list.add(mainList);

        adapter.notifyDataSetChanged();
    }


    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
        startActivity(intent);
    }
}
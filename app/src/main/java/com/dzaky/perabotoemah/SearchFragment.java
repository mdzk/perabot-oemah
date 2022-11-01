package com.dzaky.perabotoemah;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment implements ItemAdapter.ItemClickListener{

    RecyclerView rvItems;
    ItemAdapter itemAdapter;
    List<ItemModel> itemModelList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_search, container, false);
        rvItems = view.findViewById(R.id.rv_items);
        setData();
        preparedRecyclerView();
        return view;
    }

    public void setData() {
        itemModelList.add(new ItemModel("Kursi Kayu","Lorem Ipsum","ornament.png"));
        itemModelList.add(new ItemModel("Sofa Ikea","Lorem Ipsum","ornament.png"));
        itemModelList.add(new ItemModel("Lampu Tidur","Lorem Ipsum","ornament.png"));
    }

    public void preparedRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rvItems.setLayoutManager(linearLayoutManager);
        preAdapter();
    }

    public void preAdapter() {
        itemAdapter = new ItemAdapter(itemModelList, getContext(), this::selectedItem);
        rvItems.setAdapter(itemAdapter);
    }

    @Override
    public void selectedItem(ItemModel itemModel) {
        startActivity(new Intent(getContext(), ItemDetailActivity.class).putExtra("data", itemModel));
    }
}
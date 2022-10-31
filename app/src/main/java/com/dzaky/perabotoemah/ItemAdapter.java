package com.dzaky.perabotoemah;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemAdapterVh> {

    public List<ItemModel> itemModelList = new ArrayList<>();
    public Context context;

    public ItemAdapter(List<ItemModel> itemModels, Context context) {
        this.itemModelList = itemModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ItemAdapterVh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.row_items, parent, false);
        return new ItemAdapterVh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapterVh holder, int position) {
        ItemModel itemModel = itemModelList.get(position);
        String title = itemModel.getTitle();
        String description = itemModel.getDescription();
        String thumbnail = itemModel.getThumbnail();

        holder.title.setText(title);
    }

    @Override
    public int getItemCount() {
        return itemModelList.size();
    }

    public static class ItemAdapterVh extends RecyclerView.ViewHolder {

        private TextView itemTitle;
        private TextView itemDescription;
        private ImageView itemThumbnail;

        public ItemAdapterVh(@NonNull View itemView) {
            super(itemView);
            itemTitle = itemView.findViewById(R.id.tv_title);
            itemDescription = itemView.findViewById(R.id.tv_description);
            itemThumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }
}

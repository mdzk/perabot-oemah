package com.dzaky.perabotoemah;

import android.content.Context;
import android.graphics.drawable.Drawable;
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
    public ItemClickListener itemClickListener;

    public interface ItemClickListener {
        void selectedItem(ItemModel itemModel);
    }

    public ItemAdapter(List<ItemModel> itemModels, Context context, ItemClickListener itemClickListener) {
        this.itemModelList = itemModels;
        this.context = context;
        this.itemClickListener = itemClickListener;
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

        holder.itemTitle.setText(title);
        holder.itemDescription.setText(description);
        holder.itemThumbnail.setImageDrawable(Drawable.createFromPath(thumbnail));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.selectedItem(itemModel);
            }
        });
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

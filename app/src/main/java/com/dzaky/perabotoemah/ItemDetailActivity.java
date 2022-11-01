package com.dzaky.perabotoemah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ItemDetailActivity extends AppCompatActivity {

    TextView tvTitleDetail;
    ItemModel itemModel;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);
        tvTitleDetail = findViewById(R.id.tv_title_detail);
        intent = getIntent();

        if(intent != null) {
            itemModel = (ItemModel) intent.getSerializableExtra("data");
            String title = itemModel.getTitle();
            tvTitleDetail.setText(title);
        }
    }
}
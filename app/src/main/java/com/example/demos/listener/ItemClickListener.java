package com.example.demos.listener;

import android.view.View;

public interface ItemClickListener {

    void onAddItemClick(View view, int position);
    void onRemoveItemClick(View view, int position);

}

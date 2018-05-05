package com.ibm.mystore.ui.item;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ibm.mystore.R;
import com.ibm.mystore.data.network.model.Item;

/**
 * Created by abk on 05/05/2018.
 */

public class ItemFragment extends Fragment {

    public static final String TAG = "ItemFragment";
    public static final String ITEM = "ITEM";

    private RelativeLayout relativeLayoutLoading;
    private TextView textViewTitle;
    private TextView textViewPrice;
    private TextView textViewDescription;
    private Item item;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null) {
            item = getArguments().getParcelable(ITEM);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item, container, false);
        // Initializing the views
        initializeViews(view);
        // Setting the item data
        updateItem(item);
        return view;
    }

    private void initializeViews(View view) {
        relativeLayoutLoading = (RelativeLayout) view.findViewById(R.id.loading);
        textViewTitle = (TextView) view.findViewById(R.id.item_title);
        textViewPrice = (TextView) view.findViewById(R.id.item_price);
        textViewDescription = (TextView) view.findViewById(R.id.item_description);
    }

    private void setItemData() {
        textViewTitle.setText(item.getTitle());
        textViewPrice.setText(item.getValue());
        textViewDescription.setText(item.getDescription().getFrCA());
    }

    private void setItem(Item item) {
        this.item = item;

    }

    public void updateItem(Item item) {
        // Showing loading while setting item data
        showLoading();
        // Setting data from the item object we got from the parent activity
        setItem(item);
        // Populating data to the views
        setItemData();
        // Hiding the loading view once it is all done
        hideLoading();
    }

    private void showLoading() {
        relativeLayoutLoading.setVisibility(View.VISIBLE);
    }

    private void hideLoading() {
        relativeLayoutLoading.setVisibility(View.GONE);
    }
}

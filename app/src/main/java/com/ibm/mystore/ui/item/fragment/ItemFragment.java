package com.ibm.mystore.ui.item.fragment;

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
import com.ibm.mystore.data.network.model.Description;
import com.ibm.mystore.data.network.model.Item;

import java.util.Locale;

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
        setItem(savedInstanceState);
    }

    /**
     * Set item from savedInstanceState or fragment args
     * @param savedInstanceState
     */
    private void setItem(Bundle savedInstanceState) {
        if(savedInstanceState != null && savedInstanceState.getParcelable(ITEM) != null) {
            item = (Item) savedInstanceState.get(ITEM);
        }
        else if(getArguments() != null) {
            item = getArguments().getParcelable(ITEM);
        } else {
            item = null;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if(item != null) {
            outState.putParcelable(ITEM, item);
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
        textViewPrice.setText(getContext().getString(R.string.price_tag, item.getValue(), item.getCurrency()));
        String description = getDescriptionByDeviceLocale(item.getDescription());
        textViewDescription.setText(description);
    }

    /**
     * Check device language to display the appropriate description
     * @param description object
     * @return french description if the device is set to "fr-CA" if not return the default
     * value "en-CA"
     */
    private String getDescriptionByDeviceLocale(Description description) {
        if(description == null) return null;
        String descriptionText = null;
        String deviceLanguageTag = Locale.getDefault().toLanguageTag();
        if(deviceLanguageTag.equals("fr-CA"))
            descriptionText = description.getFrCA();
        else
            descriptionText = description.getEnCA();
        return descriptionText;
    }

    public void updateItem(Item item) {
        // Showing loading while setting item data
        showLoading();
        if(item != null) {
            // Populating data to the views
            setItemData();
            // Hiding the loading view once it is all done
            hideLoading();
        }
    }

    private void showLoading() {
        relativeLayoutLoading.setVisibility(View.VISIBLE);
    }

    private void hideLoading() {
        relativeLayoutLoading.setVisibility(View.GONE);
    }
}

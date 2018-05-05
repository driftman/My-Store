package com.ibm.mystore.ui.item;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.ibm.mystore.R;
import com.ibm.mystore.data.network.model.Description;
import com.ibm.mystore.data.network.model.Item;
import com.ibm.mystore.ui.base.BaseActivity;
import com.ibm.mystore.ui.item.listener.OnItemSelectedListener;

import java.util.List;

public class ItemsActivity extends BaseActivity implements
        ItemContract.IItemView,
        OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if(savedInstanceState == null) {
            addItemsFragment();
            if(isLandscapeOrTablet()) {
                addItemFragment();
            }
        }
    }

    private void addItemsFragment() {
        ItemsFragment itemsFragment = new ItemsFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragment_items, itemsFragment);
        transaction.commit();
    }

    private void addItemFragment() {

        ItemFragment itemFragment = new ItemFragment();

        Description description = new Description();
        description.setEnCA("Fusce ac euismod dolor, at suscipit mauris. Suspendisse potenti (EN).");
        description.setFrCA("Fusce ac euismod dolor, at suscipit mauris. Suspendisse potenti (FR).");

        Item item = new Item();
        item.setId("1");
        item.setTitle("Item 1");
        item.setDescription(description);

        Bundle args = getBundledItem(item);

        itemFragment.setArguments(args);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragment_item, itemFragment);
        transaction.commit();

    }

    private Bundle getBundledItem(Item item) {
        Bundle args = new Bundle();
        args.putParcelable(ItemFragment.ITEM, item);
        return args;
    }

    private void replaceItemFragment(Item item) {
        ItemFragment itemFragment = new ItemFragment();
        // Adding the chosen item to the arguments
        Bundle args = getBundledItem(item);
        itemFragment.setArguments(args);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        // Check whether we should replace the main or the item container
        if(isLandscapeOrTablet()) {
            transaction.replace(R.id.fragment_item, itemFragment);
        } else {
            transaction.replace(R.id.fragment_items, itemFragment);
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }

    @Override
    public void onItemSelected(Item item, int position) {
        replaceItemFragment(item);
    }


    // This method will help determine whether the phone is on landscape mode or it is a tablet
    // device
    private Boolean isLandscapeOrTablet() {
        View view = findViewById(R.id.fragment_item);
        return view != null;
    }

    @Override
    public void setItems(List<Item> items) {

    }
}

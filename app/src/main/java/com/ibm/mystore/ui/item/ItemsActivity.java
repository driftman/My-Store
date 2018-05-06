package com.ibm.mystore.ui.item;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.ibm.mystore.MainApplication;
import com.ibm.mystore.R;
import com.ibm.mystore.data.network.model.Item;
import com.ibm.mystore.di.component.ItemComponent;
import com.ibm.mystore.ui.base.BaseActivity;
import com.ibm.mystore.ui.item.fragment.ItemFragment;
import com.ibm.mystore.ui.item.fragment.ItemsFragment;
import com.ibm.mystore.ui.item.listener.OnItemSelectedListener;


public class ItemsActivity extends BaseActivity implements OnItemSelectedListener {

    public static final String TAG = "ItemsActivity";

    private ItemComponent itemComponent;

    private Toolbar toolbar;

    private Bundle savedInstanceState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        // Setting the saved instance state
        this.savedInstanceState = savedInstanceState;
        // Setting toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initializeActivity(savedInstanceState);
        initializeInjector();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    /**
     * Initializes injector
     */
    private void initializeInjector() {
        itemComponent = ((MainApplication) getApplication())
                .plusItemComponent();
    }

    /**
     * Provides an ItemComponent
     * @return ItemComponent
     */
    public ItemComponent getItemComponent() {
        return itemComponent;
    }


    /**
     * Initializes this activity.
     */
    private void initializeActivity(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        if(savedInstanceState == null) {
            addItemsFragment();
            if(isLandscapeOrLargeDevice()) {
                addItemFragment(null);
            }
        } else {
            FragmentManager fragmentManager = getSupportFragmentManager();
            Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_items);
            if(fragment instanceof ItemFragment) {
                fragmentManager.popBackStack();
            }
        }

    }

    private void addItemsFragment() {
        ItemsFragment itemsFragment = new ItemsFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragment_items, itemsFragment);
        transaction.commit();
    }

    private void addItemFragment(Item item) {
        ItemFragment itemFragment = new ItemFragment();
        if(item != null) {
            Bundle args = getBundledItem(item);
            itemFragment.setArguments(args);
        }
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
        if(isLandscapeOrLargeDevice()) {
            transaction.replace(R.id.fragment_item, itemFragment);
        } else {
            transaction.replace(R.id.fragment_items, itemFragment);
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }

    @Override
    public void onItemSelected(Item item) {
        replaceItemFragment(item);
    }

    @Override
    public void displayFirstItemForLandscapeAndLargeDevice(Item item) {
        if(isLandscapeOrLargeDevice()) {
            onItemSelected(item);
        }
    }


    /**
     * This method will help determine whether the phone is on landscape mode or it is a tablet
     * device
     * @return
     */
    private Boolean isLandscapeOrLargeDevice() {
        View view = findViewById(R.id.fragment_item);
        return view != null;
    }

    @Override
    public Bundle getSavedInstanceState() {
        return savedInstanceState;
    }
}

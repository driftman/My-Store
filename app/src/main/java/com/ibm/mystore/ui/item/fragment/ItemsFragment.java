package com.ibm.mystore.ui.item.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.ibm.mystore.MainApplication;
import com.ibm.mystore.R;
import com.ibm.mystore.data.network.model.Item;
import com.ibm.mystore.ui.item.ItemsActivity;
import com.ibm.mystore.ui.item.adapter.ItemsAdapter;
import com.ibm.mystore.ui.item.listener.OnItemSelectedListener;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by abk on 05/05/2018.
 */

public class ItemsFragment extends Fragment implements
        ItemsContract.IItemsView {

    public static String TAG = "ItemsFragment";
    public static final String ITEMS = "ITEMS";

    @Inject
    public ItemsContract.IItemsPresenter presenter;

    @Inject
    public ItemsAdapter adapter;

    private OnItemSelectedListener listener;
    private RecyclerView recyclerView;
    private LinearLayoutManager llm;
    private RelativeLayout loading;

    private Bundle savedInstanceState;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnItemSelectedListener) {
            this.listener = (OnItemSelectedListener) context;
        } else {
            throw new ClassCastException(context.toString()
                    + " must implement OnItemSelectedListener");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if(adapter != null) {
            final ArrayList<Item> items = adapter.getItems();
            if(items != null) outState.putParcelableArrayList(ITEMS, items);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_items, container, false);
        initializeInjector();
        initializeViews(rootView);
        // Attaching the fragment to its presenter
        presenter.onAttach(this);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Setting the saved instance state
        this.savedInstanceState = savedInstanceState;
        presenter.onViewInitialized();
    }

    /**
     * Initialize dependencies
     */
    private void initializeInjector() {
        ((ItemsActivity) getActivity())
                .getItemComponent()
                .inject(this);
    }

    /**
     * Initilize views
     * @param view
     */
    private void initializeViews(View view) {
        // Setting the loading layout
        loading = (RelativeLayout) view.findViewById(R.id.loading);
        showLoading();
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_items);
        // Setting a vertical layout manager
        llm = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(llm);
        // Setting up the item click listener
        adapter.setOnItemSelectedListener(listener);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showMessage(int resourceId) {
        Toast.makeText(getContext(), getString(resourceId), Toast.LENGTH_SHORT).show();
    }

    @Override
    public Bundle getSavedInstanceState() {
        return savedInstanceState;
    }

    @Override
    public void showLoading() {
        loading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        loading.setVisibility(View.GONE);
    }

    @Override
    public void setItems(ArrayList<Item> items) {
        adapter.setItems(items);
        hideLoading();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDetach();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        presenter = null;
        listener = null;
    }


}

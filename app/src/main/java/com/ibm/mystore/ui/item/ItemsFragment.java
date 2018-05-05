package com.ibm.mystore.ui.item;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ibm.mystore.R;
import com.ibm.mystore.ui.item.adapter.ItemsAdapter;
import com.ibm.mystore.ui.item.listener.OnItemSelectedListener;

/**
 * Created by abk on 05/05/2018.
 */

public class ItemsFragment extends Fragment {

    public static String TAG = "ItemsFragment";
    private OnItemSelectedListener listener;
    private RecyclerView recyclerView;
    private LinearLayoutManager llm;
    private ItemsAdapter adapter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnItemSelectedListener) {
            this.listener = (OnItemSelectedListener) context;
        } else {
            throw new ClassCastException(context.toString()
                    + " must implement PizzaMenuFragment.OnItemSelectedListener");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_items, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view_items);
        llm = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        adapter = new ItemsAdapter(getContext(), null, listener);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(adapter);
        return rootView;
    }

}

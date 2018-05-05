package com.ibm.mystore.ui.item.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ibm.mystore.R;
import com.ibm.mystore.data.network.model.Item;
import com.ibm.mystore.ui.item.listener.OnItemSelectedListener;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Soufiane ELBAZ on 05/05/2018.
 */

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ItemsViewHolder> {


    private Context context;
    private List<Item> items;
    private final OnItemSelectedListener listener;

    public ItemsAdapter(Context context, List<Item> items, OnItemSelectedListener listener) {
        this.context = context;
        this.items = items;
        this.listener = listener;
    }

    @Override
    public ItemsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new ItemsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemsViewHolder holder, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemSelected(null, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    class ItemsViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView price;

        public ItemsViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            price = (TextView) itemView.findViewById(R.id.price);
        }
    }
}

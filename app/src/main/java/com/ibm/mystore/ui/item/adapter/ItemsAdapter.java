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

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Soufiane ELBAZ on 05/05/2018.
 */

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ItemsViewHolder> {


    private Context context;
    private List<Item> items;
    private OnItemSelectedListener listener;

    @Inject
    public ItemsAdapter(Context context) {
        this.context = context;
        this.items = Collections.emptyList();
    }

    public void setOnItemSelectedListener(OnItemSelectedListener listener) {
        this.listener = listener;
    }

    public void setItems(List<Item> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @Override
    public ItemsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new ItemsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemsViewHolder holder, final int position) {
        final Item item = items.get(position);
        holder.title.setText(item.getTitle());
        holder.price.setText(context.getString(R.string.price_tag, item.getValue(), item.getCurrency()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listener != null) listener.onItemSelected(item, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ItemsViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView price;

        public ItemsViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.item_title);
            price = (TextView) itemView.findViewById(R.id.item_price);
        }
    }
}

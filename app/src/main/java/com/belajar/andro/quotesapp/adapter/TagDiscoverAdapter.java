package com.belajar.andro.quotesapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.belajar.andro.quotesapp.R;
import com.belajar.andro.quotesapp.model.quotes.QuotesDiscoverResultsItem;

import java.util.ArrayList;

public class TagDiscoverAdapter extends RecyclerView.Adapter<TagDiscoverAdapter.ViewHolder> {

    private ArrayList<QuotesDiscoverResultsItem> quotesDiscoverResultsItems = new ArrayList<>();
    private Context context;

    public TagDiscoverAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<QuotesDiscoverResultsItem> items){
        quotesDiscoverResultsItems.clear();
        quotesDiscoverResultsItems.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TagDiscoverAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_tags,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TagDiscoverAdapter.ViewHolder holder, int position) {
        holder.tvTag.setText(quotesDiscoverResultsItems.get(position).getTags().toString());
    }

    @Override
    public int getItemCount() {
        return quotesDiscoverResultsItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTag;
        CardView cvItem;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cvItem = itemView.findViewById(R.id.item_list_tags_CV);
            tvTag = itemView.findViewById(R.id.item_list_iv_tag);
        }
    }
}

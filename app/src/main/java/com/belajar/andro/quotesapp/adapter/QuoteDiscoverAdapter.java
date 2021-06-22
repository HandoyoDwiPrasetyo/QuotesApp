package com.belajar.andro.quotesapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.belajar.andro.quotesapp.R;
import com.belajar.andro.quotesapp.database.AppDatabase;
import com.belajar.andro.quotesapp.database.SearchHistoryModel;
import com.belajar.andro.quotesapp.model.quotes.QuotesDiscoverResultsItem;
import com.belajar.andro.quotesapp.view.activity.DetailQuote;

import java.util.ArrayList;
import java.util.Locale;

public class QuoteDiscoverAdapter extends RecyclerView.Adapter<QuoteDiscoverAdapter.ViewHolder> {

    private ArrayList<QuotesDiscoverResultsItem> quotesDiscoverResultsItems = new ArrayList<>();
    private Context context;
    private ArrayList<QuotesDiscoverResultsItem> quotesFiltered = new ArrayList<>();

    private AppDatabase appDatabase;

    public QuoteDiscoverAdapter(Context context) {
        this.context = context;
        appDatabase = AppDatabase.iniDatabase(this.context);
    }

    public void setData(ArrayList<QuotesDiscoverResultsItem> items) {
        quotesDiscoverResultsItems.clear();
        quotesDiscoverResultsItems.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public QuoteDiscoverAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_quotes, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuoteDiscoverAdapter.ViewHolder holder, int position) {
        holder.tvQuote.setText(quotesDiscoverResultsItems.get(position).getContent());
        holder.tvAuthor.setText(quotesDiscoverResultsItems.get(position).getAuthor());

        holder.cvItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    SearchHistoryModel historyModel = new SearchHistoryModel();
                    historyModel.setContent(quotesDiscoverResultsItems.get(position).getContent());
                    historyModel.setAuthor(quotesDiscoverResultsItems.get(position).getAuthor());

                    appDatabase.historyDao().insertHistory(historyModel);

                    Log.d("QuoteAdapter", "Berhasil, msg:");
                    Toast.makeText(context, "Berhasil", Toast.LENGTH_SHORT).show();
                } catch (Exception rt) {
                    Log.e("QuoteAdapter", "Gagal, msg:" + rt.getMessage());
                    Toast.makeText(context, "Gagal", Toast.LENGTH_SHORT).show();
                }

                Intent intent = new Intent(context, DetailQuote.class);

                intent.putExtra("quote", quotesDiscoverResultsItems.get(position).getContent());
                intent.putExtra("author", quotesDiscoverResultsItems.get(position).getAuthor());
                intent.putExtra("tag", quotesDiscoverResultsItems.get(position).getTags().toString());
                intent.putExtra("dateadd", quotesDiscoverResultsItems.get(position).getDateModified());
                intent.putExtra("datemodified", quotesDiscoverResultsItems.get(position).getDateModified());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return quotesDiscoverResultsItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvQuote, tvAuthor;
        CardView cvItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cvItem = itemView.findViewById(R.id.item_list_quotes_CV);
            tvQuote = itemView.findViewById(R.id.item_list_iv_quote);
            tvAuthor = itemView.findViewById(R.id.item_list_iv_author);
        }
    }

    // filter name in Search Bar
    public void filter(String characterText) {
        characterText = characterText.toLowerCase(Locale.getDefault());

        quotesFiltered.clear();
        for (QuotesDiscoverResultsItem quote : quotesDiscoverResultsItems) {
            if (quote.getContent().toLowerCase(Locale.getDefault()).contains(characterText)) {
                quotesFiltered.add(quote);
            }
        }

        setData(quotesFiltered);
        notifyDataSetChanged();
    }
}

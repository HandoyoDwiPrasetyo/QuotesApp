package com.belajar.andro.quotesapp.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.belajar.andro.quotesapp.R;
import com.belajar.andro.quotesapp.database.AppDatabase;
import com.belajar.andro.quotesapp.database.SearchHistoryModel;

import java.util.ArrayList;

public class HistoryDiscoverAdapter extends RecyclerView.Adapter<HistoryDiscoverAdapter.ViewHolder> {

    private Context context;
    private AppDatabase appDatabase;
    private ArrayList<SearchHistoryModel> historyModelItems = new ArrayList<>();

    public HistoryDiscoverAdapter(Context context){
        this.appDatabase = AppDatabase.iniDatabase(this.context);
        this.context = context;
    }

    public void setData(ArrayList<SearchHistoryModel> items){
        historyModelItems.clear();
        historyModelItems.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HistoryDiscoverAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_history,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryDiscoverAdapter.ViewHolder holder, int position) {
        holder.tvContent.setText(historyModelItems.get(position).getContent());
        holder.tvAuthor.setText(historyModelItems.get(position).getAuthor());
        holder.ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    SearchHistoryModel historyModel = new SearchHistoryModel();
                    historyModel.setContent(historyModelItems.get(position).getContent());
                    historyModel.setAuthor(historyModelItems.get(position).getAuthor());
                    historyModel.setId(historyModelItems.get(position).getId());

                    appDatabase.historyDao().deleteHistory(historyModel);
                    Log.e("MainActivity", "Riwayat Berhasil Dihapus, msg: ");
                    Toast.makeText(context, "Riwayat Berhasil Dihapus",Toast.LENGTH_SHORT).show();
                } catch (Exception ex){
                    Log.e("MainActivity", "Riwayat Gagal Dihapus, msg: "+ex.getMessage());
                    Toast.makeText(context, "Riwayat Gagal Dihapus",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return historyModelItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivDelete;
        TextView tvContent,tvAuthor;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivDelete = itemView.findViewById(R.id.iv_delete_history);
            tvContent = itemView.findViewById(R.id.item_list_iv_content_history);
            tvAuthor = itemView.findViewById(R.id.item_list_iv_author_history);
        }
    }
}

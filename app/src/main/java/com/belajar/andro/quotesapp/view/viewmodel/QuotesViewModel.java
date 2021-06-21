package com.belajar.andro.quotesapp.view.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.belajar.andro.quotesapp.model.quotes.QuotesDiscoverResponse;
import com.belajar.andro.quotesapp.model.quotes.QuotesDiscoverResultsItem;
import com.belajar.andro.quotesapp.service.ApiMain;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuotesViewModel extends ViewModel {
    private ApiMain apiMain;
    private MutableLiveData<ArrayList<QuotesDiscoverResultsItem>> listDiscoverQuote = new MutableLiveData<>();

    public void setQuoteDiscover(){
        if (this.apiMain == null){
            apiMain = new ApiMain();
        }

        apiMain.getApiQuotes().getQuotesDiscover().enqueue(new Callback<QuotesDiscoverResponse>() {
            @Override
            public void onResponse(Call<QuotesDiscoverResponse> call, Response<QuotesDiscoverResponse> response) {
                QuotesDiscoverResponse responseDiscover = response.body();
                if (responseDiscover != null && responseDiscover.getResults() != null){
                    ArrayList<QuotesDiscoverResultsItem> quotesDiscoverItems = responseDiscover.getResults();
                    listDiscoverQuote.postValue(quotesDiscoverItems);
                }
            }

            @Override
            public void onFailure(Call<QuotesDiscoverResponse> call, Throwable t) {

            }
        });
    }

    public LiveData<ArrayList<QuotesDiscoverResultsItem>> getQuotesDiscover(){
        return listDiscoverQuote;
    }
}

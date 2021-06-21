package com.belajar.andro.quotesapp.service;

import com.belajar.andro.quotesapp.model.quotes.QuotesDiscoverResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface QuotesRepository {
    @GET("quotes?page=2")
    Call<QuotesDiscoverResponse> getQuotesDiscover();
}

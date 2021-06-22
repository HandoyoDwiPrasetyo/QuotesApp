package com.belajar.andro.quotesapp.model.quotes;

import java.util.ArrayList;
import com.google.gson.annotations.SerializedName;

public class QuotesDiscoverResponse{

	@SerializedName("count")
	private int count;

	@SerializedName("totalPages")
	private int totalPages;

	@SerializedName("lastItemIndex")
	private int lastItemIndex;

	@SerializedName("page")
	private int page;

	@SerializedName("totalCount")
	private int totalCount;

	@SerializedName("results")
	private ArrayList<QuotesDiscoverResultsItem> results;

	public void setCount(int count){
		this.count = count;
	}

	public int getCount(){
		return count;
	}

	public void setTotalPages(int totalPages){
		this.totalPages = totalPages;
	}

	public int getTotalPages(){
		return totalPages;
	}

	public void setLastItemIndex(int lastItemIndex){
		this.lastItemIndex = lastItemIndex;
	}

	public int getLastItemIndex(){
		return lastItemIndex;
	}

	public void setPage(int page){
		this.page = page;
	}

	public int getPage(){
		return page;
	}

	public void setTotalCount(int totalCount){
		this.totalCount = totalCount;
	}

	public int getTotalCount(){
		return totalCount;
	}

	public void setResults(ArrayList<QuotesDiscoverResultsItem> results){
		this.results = results;
	}

	public ArrayList<QuotesDiscoverResultsItem> getResults(){
		return results;
	}
}
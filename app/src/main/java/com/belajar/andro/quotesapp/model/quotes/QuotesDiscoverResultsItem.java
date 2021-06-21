package com.belajar.andro.quotesapp.model.quotes;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class QuotesDiscoverResultsItem {

	@SerializedName("authorSlug")
	private String authorSlug;

	@SerializedName("author")
	private String author;

	@SerializedName("length")
	private int length;

	@SerializedName("dateModified")
	private String dateModified;

	@SerializedName("_id")
	private String id;

	@SerializedName("content")
	private String content;

	@SerializedName("dateAdded")
	private String dateAdded;

	@SerializedName("tags")
	private List<String> tags;

	public void setAuthorSlug(String authorSlug){
		this.authorSlug = authorSlug;
	}

	public String getAuthorSlug(){
		return authorSlug;
	}

	public void setAuthor(String author){
		this.author = author;
	}

	public String getAuthor(){
		return author;
	}

	public void setLength(int length){
		this.length = length;
	}

	public int getLength(){
		return length;
	}

	public void setDateModified(String dateModified){
		this.dateModified = dateModified;
	}

	public String getDateModified(){
		return dateModified;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setContent(String content){
		this.content = content;
	}

	public String getContent(){
		return content;
	}

	public void setDateAdded(String dateAdded){
		this.dateAdded = dateAdded;
	}

	public String getDateAdded(){
		return dateAdded;
	}

	public void setTags(List<String> tags){
		this.tags = tags;
	}

	public List<String> getTags(){
		return tags;
	}
}
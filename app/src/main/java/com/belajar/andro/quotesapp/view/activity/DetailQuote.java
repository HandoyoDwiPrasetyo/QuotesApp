package com.belajar.andro.quotesapp.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.belajar.andro.quotesapp.R;

public class DetailQuote extends AppCompatActivity {

    private TextView tvQuote, tvAuthor, tvTag, tvDateAdd, tvDateModified;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_quote);

        tvQuote = findViewById(R.id.detail_quote);
        tvAuthor = findViewById(R.id.detail_author);
        tvTag = findViewById(R.id.detail_tag);
        tvDateAdd = findViewById(R.id.detail_dateadd);
        tvDateModified = findViewById(R.id.detail_datemodified);

        String contentquote = getIntent().getStringExtra("quote");
        String authorquote = getIntent().getStringExtra("author");
        String tagquote = getIntent().getStringExtra("tag");
        String dateaddquote = getIntent().getStringExtra("dateadd");
        String datemodifiedquote = getIntent().getStringExtra("datemodified");

        tvQuote.setText(contentquote);
        tvAuthor.setText(authorquote);
        tvTag.setText(tagquote);
        tvDateAdd.setText(dateaddquote);
        tvDateModified.setText(datemodifiedquote);

    }
}
package com.belajar.andro.quotesapp.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.belajar.andro.quotesapp.R;

public class DetailQuote extends AppCompatActivity {

    private TextView tvQuote, tvAuthor, tvTag, tvDateAdd, tvDateModified;
    private Button btnShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_quote);

        tvQuote = findViewById(R.id.detail_quote);
        tvAuthor = findViewById(R.id.detail_author);
        tvTag = findViewById(R.id.detail_tag);
        tvDateAdd = findViewById(R.id.detail_dateadd);
        tvDateModified = findViewById(R.id.detail_datemodified);

        btnShare = findViewById(R.id.share_quote);
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, getIntent().getStringExtra("quote"));
                intent.setType("text/plain");
                startActivity(Intent.createChooser(intent,"Send To"));
            }
        });

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
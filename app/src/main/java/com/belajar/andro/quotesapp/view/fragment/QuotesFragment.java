package com.belajar.andro.quotesapp.view.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.belajar.andro.quotesapp.R;
import com.belajar.andro.quotesapp.adapter.QuoteDiscoverAdapter;
import com.belajar.andro.quotesapp.model.quotes.QuotesDiscoverResultsItem;
import com.belajar.andro.quotesapp.view.viewmodel.QuotesViewModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QuotesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

public class QuotesFragment extends Fragment implements SearchView.OnQueryTextListener{

    private QuoteDiscoverAdapter quoteDiscoverAdapter;
    private RecyclerView rvQuotesDiscover;
    private QuotesViewModel quotesViewModel;
    private ArrayList<QuotesDiscoverResultsItem> savedItem = new ArrayList<>();


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public QuotesFragment() {
        // Required empty public constructor
    }

    public static QuotesFragment newInstance(String param1, String param2) {
        QuotesFragment fragment = new QuotesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // show the search nav
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_quotes, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        quoteDiscoverAdapter = new QuoteDiscoverAdapter(getContext());
        quoteDiscoverAdapter.notifyDataSetChanged();

        rvQuotesDiscover = view.findViewById(R.id.fragment_quote_rv);
        rvQuotesDiscover.setLayoutManager(new GridLayoutManager(getContext(), 2));

        quotesViewModel = new ViewModelProvider(this).get(QuotesViewModel.class);
        quotesViewModel.setQuoteDiscover();
        quotesViewModel.getQuotesDiscover().observe(getActivity(), getQuoteDiscover);

        rvQuotesDiscover.setAdapter(quoteDiscoverAdapter);
    }

    private Observer<ArrayList<QuotesDiscoverResultsItem>> getQuoteDiscover = new Observer<ArrayList<QuotesDiscoverResultsItem>>() {
        @Override
        public void onChanged(ArrayList<QuotesDiscoverResultsItem> quotesDiscoverResultsItems) {
            if (quotesDiscoverResultsItems != null){
                quoteDiscoverAdapter.setData(quotesDiscoverResultsItems);
                savedItem = quotesDiscoverResultsItems;
            }
        }
    };

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.search_nav, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        item.setShowAsAction(MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW | MenuItem.SHOW_AS_ACTION_IF_ROOM);

        SearchView searchView = (SearchView) item.getActionView();
        searchView.setQueryHint(getResources().getString(R.string.query_hint));
        searchView.onActionViewExpanded();
        searchView.setOnQueryTextListener(this);

    }

    @Override
    public boolean onQueryTextChange(String query) {
        quoteDiscoverAdapter.setData(savedItem);
        quoteDiscoverAdapter.filter(query);
        return false;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return true;
    }



}
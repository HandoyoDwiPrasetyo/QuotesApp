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
import android.view.View;
import android.view.ViewGroup;

import com.belajar.andro.quotesapp.R;
import com.belajar.andro.quotesapp.adapter.AuthorDiscoverAdapter;
import com.belajar.andro.quotesapp.model.quotes.QuotesDiscoverResultsItem;
import com.belajar.andro.quotesapp.view.viewmodel.QuotesViewModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AuthorsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AuthorsFragment extends Fragment {

    private AuthorDiscoverAdapter authorDiscoverAdapter;
    private RecyclerView rvAuthorsDiscover;
    private QuotesViewModel quotesViewModel;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AuthorsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AuthorsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AuthorsFragment newInstance(String param1, String param2) {
        AuthorsFragment fragment = new AuthorsFragment();
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_authors, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        authorDiscoverAdapter = new AuthorDiscoverAdapter(getContext());
        authorDiscoverAdapter.notifyDataSetChanged();

        rvAuthorsDiscover = view.findViewById(R.id.fragment_author_rv);
        rvAuthorsDiscover.setLayoutManager(new GridLayoutManager(getContext(),1));

        quotesViewModel = new ViewModelProvider(this).get(QuotesViewModel.class);
        quotesViewModel.setQuoteDiscover();
        quotesViewModel.getQuotesDiscover().observe(getActivity(), getQuoteDiscover);

        rvAuthorsDiscover.setAdapter(authorDiscoverAdapter);
    }

    private Observer<ArrayList<QuotesDiscoverResultsItem>> getQuoteDiscover = new Observer<ArrayList<QuotesDiscoverResultsItem>>() {
        @Override
        public void onChanged(ArrayList<QuotesDiscoverResultsItem> quotesDiscoverResultsItems) {
            if (quotesDiscoverResultsItems != null){
                authorDiscoverAdapter.setData(quotesDiscoverResultsItems);
            }
        }
    };
}
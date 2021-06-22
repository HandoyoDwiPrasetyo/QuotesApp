package com.belajar.andro.quotesapp.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import com.belajar.andro.quotesapp.adapter.QuoteDiscoverAdapter;
import com.belajar.andro.quotesapp.view.fragment.AuthorsFragment;
import com.belajar.andro.quotesapp.view.fragment.QuotesFragment;
import com.belajar.andro.quotesapp.R;
import com.belajar.andro.quotesapp.view.fragment.TagsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private Fragment selectedFragment = new QuotesFragment();
    private BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.activity_main_bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        loadFragment(selectedFragment);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.menu_bottom_nav_quote:
                selectedFragment = new QuotesFragment();
                loadFragment(selectedFragment);
                break;

            case R.id.menu_bottom_nav_tags:
                selectedFragment = new TagsFragment();
                loadFragment(selectedFragment);
                break;

            case R.id.menu_bottom_nav_author:
                selectedFragment = new AuthorsFragment();
                loadFragment(selectedFragment);
                break;

        }
        return loadFragment(selectedFragment);
    }

    private boolean loadFragment(Fragment selectedFragment) {
        if (selectedFragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.activity_main_fragment_container, selectedFragment)
                    .commit();
            return true;
        }
        return false;
    }
}
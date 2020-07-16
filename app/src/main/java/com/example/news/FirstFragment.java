package com.example.news;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.news.model.News;
import com.example.news.viewmodel.NewsListViewmodel;

public class FirstFragment extends Fragment {

    NewsListViewmodel newsListViewmodel;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        newsListViewmodel = new ViewModelProvider((requireActivity())).get(NewsListViewmodel.class);
//TODO newsObservables is not returning a value
        newsObservables();

        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }

    public void newsObservables() {
        newsListViewmodel.getNews().observe(getViewLifecycleOwner(), new Observer<News>() {
            @Override
            public void onChanged(News news) {
                Log.i("News", ""+news.getArticles().get(1).getUrl());
            }
        });
    }
}
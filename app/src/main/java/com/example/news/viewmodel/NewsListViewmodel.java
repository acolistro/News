package com.example.news.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.news.model.News;
import com.example.news.repository.NewsRepository;

public class NewsListViewmodel extends AndroidViewModel {

    NewsRepository newsRepository;

    public NewsListViewmodel(@NonNull Application application) {
        super(application);
        newsRepository = NewsRepository.getInstance();
    }

    public LiveData<News> getNews() {
        return newsRepository.getNewsList();
    }
}

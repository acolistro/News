package com.example.news.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.news.model.Constants;
import com.example.news.model.News;
import com.example.news.service.IApiHelper;
import com.example.news.service.ServiceHelper;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class NewsRepository {
    public static NewsRepository newsRepository;
    static IApiHelper iApiHelper;


    public synchronized static NewsRepository getInstance() {
        //TODO Dagger implementation
        if (newsRepository == null) {
            newsRepository = new NewsRepository();
            iApiHelper = ServiceHelper.getRestAPIHelper();
        }
        return newsRepository;
    }

    public MutableLiveData<News> getNewsList() {
        final MutableLiveData<News> newsRepositoryMutableLiveData = new MutableLiveData<>();
        //TODO encrypt API key
        iApiHelper.getTopHeadlines("us", Constants.API_KEY)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Observer<News>() {
                @Override
                public void onSubscribe(Disposable d) {

                }

                @Override
                public void onNext(News news) {

                }

                @Override
                public void onError(Throwable e) {

                }

                @Override
                public void onComplete() {

                }
            });


        return newsRepositoryMutableLiveData;
    }
}

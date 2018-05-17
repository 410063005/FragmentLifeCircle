package com.example.cm.demo_arch.codelabs;

import android.arch.lifecycle.LiveData;

import java.util.List;

/**
 * Created by 410063005 on 2018/5/16.
 */

public class WordRepository {

    private WordDao mWordDao;

    private LiveData<List<Word>> mAllWords;

    public WordRepository(WordDao wordDao) {
        mWordDao = wordDao;
        mAllWords = mWordDao.getAllWordsLiveData();
    }

    public LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }

    public void insert(final Word word) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                mWordDao.insert(word);
            }
        }).start();
    }

    public void deleteAll() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                mWordDao.deleteAll();
            }
        }).start();
    }
}

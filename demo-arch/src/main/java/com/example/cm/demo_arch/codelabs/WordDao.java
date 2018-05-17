package com.example.cm.demo_arch.codelabs;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by 410063005 on 2018/5/16.
 */
@Dao
public interface WordDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Word word);

    @Query("DELETE FROM word_table")
    void deleteAll();

    @Query("SELECT * FROM word_table")
    List<Word> getAllWords();

    @Query("SELECT * FROM word_table")
    LiveData<List<Word>> getAllWordsLiveData();

}

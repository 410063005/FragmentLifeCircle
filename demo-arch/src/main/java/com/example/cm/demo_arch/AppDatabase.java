package com.example.cm.demo_arch;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.cm.demo_arch.codelabs.Word;
import com.example.cm.demo_arch.codelabs.WordDao;
import com.example.cm.demo_arch.room.User;
import com.example.cm.demo_arch.room.UserDao;

/**
 * Created by 410063005 on 2018/5/16.
 */

@Database(entities = {User.class, Word.class}, version = 3)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDao userDao();

    public abstract WordDao wordDao();
}

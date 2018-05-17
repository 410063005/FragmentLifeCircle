package com.example.cm.demo_arch

import android.arch.persistence.room.Room
import android.content.Context

/**
 * Created by 410063005 on 2018/5/16.
 */
object AppDatabaseHolder {

    fun get(context: Context): AppDatabase {
        return Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "cm-app-db")
//                .addCallback(object : RoomDatabase.Callback() {
//                    override fun onOpen(db: SupportSQLiteDatabase) {
//                        super.onOpen(db)
//                        thread {
//                            val wordDao = AppDatabaseHolder.get(context).wordDao()
//                            wordDao.insert(Word("hello"))
//                            wordDao.insert(Word("world"))
//                        }
//                    }
//                })
                .fallbackToDestructiveMigration().build()
    }

}
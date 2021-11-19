package com.example.tinkoffleague.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tinkoffleague.domain.pojo.TeamItem

@Database(entities = [TeamItem::class],version = 1,exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        private var db: AppDatabase? = null
        private const val DATABASE_NAME = "main.db"
        private val LOCK = Any()

        fun getInstance(context: Context): AppDatabase {
            synchronized(LOCK) {
                db?.let { return it }
                val instance =
                    Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME).build()
                db = instance
                return instance
            }
        }
    }

    abstract fun teamDbDao():TeamDbDao
}
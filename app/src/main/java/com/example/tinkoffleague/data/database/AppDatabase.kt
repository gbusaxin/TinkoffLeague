package com.example.tinkoffleague.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tinkoffleague.data.database.model.TeamInfoDbModel
import com.example.tinkoffleague.data.database.model.TournamentInfoDbModel

@Database(entities = [TeamInfoDbModel::class,TournamentInfoDbModel::class],
    version = 3,exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        private var db: AppDatabase? = null
        private const val DATABASE_NAME = "main.db"
        private val LOCK = Any()

        fun getInstance(context: Context): AppDatabase {
            synchronized(LOCK) {
                db?.let { return it }
                val instance =
                    Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                db = instance
                return instance
            }
        }
    }

    abstract fun teamDbDao():TeamDbDao
}
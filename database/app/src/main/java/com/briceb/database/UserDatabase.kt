package com.briceb.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}

private var INSTANCE: UserDatabase? = null

fun getDatabase(context: Context): UserDatabase? {
    if (INSTANCE == null) {
        INSTANCE = Room.databaseBuilder(
            context,
            UserDatabase::class.java,
            "user_db")
            .allowMainThreadQueries()
            .build()
    }
    return INSTANCE
}
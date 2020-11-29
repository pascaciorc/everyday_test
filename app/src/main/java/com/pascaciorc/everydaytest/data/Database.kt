package com.pascaciorc.everydaytest.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Take::class], version = 2)
abstract class Database : RoomDatabase() {
    abstract fun takeDao(): TakeDao
}
package com.pascaciorc.everydaytest.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TakeDao {
    @Insert
    suspend fun insertTake(take: Take)

    @Query("SELECT * from take")
    fun getTakes(): LiveData<List<Take>>
}
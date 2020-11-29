package com.pascaciorc.everydaytest.data

import androidx.lifecycle.LiveData

interface DataRepository {
    fun getAllTakes(): LiveData<List<Take>>
    suspend fun addTake(take: Take)
}
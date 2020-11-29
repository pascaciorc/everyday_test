package com.pascaciorc.everydaytest.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.pascaciorc.everydaytest.data.DataRepositoryImpl
import com.pascaciorc.everydaytest.data.Take
import com.pascaciorc.everydaytest.utils.DateHelper.getCurrentTimestamp

class HomeViewModel @ViewModelInject constructor(
    private val repository: DataRepositoryImpl
) : ViewModel() {

    fun getDate() = repository.getAllTakes()
    suspend fun setDate() = repository.addTake(Take(date = getCurrentTimestamp()))
}
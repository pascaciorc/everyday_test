package com.pascaciorc.everydaytest.data

import javax.inject.Inject

class DataRepositoryImpl @Inject constructor(private val takeDao: TakeDao) : DataRepository {
    override fun getAllTakes() = takeDao.getTakes()
    override suspend fun addTake(take: Take) = takeDao.insertTake(take)
}
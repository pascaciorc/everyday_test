package com.pascaciorc.everydaytest.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Take(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val date: Long = 0
)
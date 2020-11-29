package com.pascaciorc.everydaytest.utils

import java.time.LocalDate

object DateHelper {
    fun lengthOfMonth() = LocalDate.now().lengthOfMonth()
    fun lengthOfMonth(data: LocalDate) = data.lengthOfMonth()
    fun getCurrentTimestamp() = System.currentTimeMillis()
}
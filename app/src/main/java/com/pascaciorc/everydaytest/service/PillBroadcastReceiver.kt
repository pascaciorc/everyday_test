package com.pascaciorc.everydaytest.service

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.pascaciorc.everydaytest.main.MainActivity
import com.pascaciorc.everydaytest.utils.NotificationHelper.showNotification

class PillBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        context?.let {
            showNotification(
                it,
                "Hola",
                "Living dead girl",
                Intent(it, MainActivity::class.java),
                0
            )
        }
    }
}
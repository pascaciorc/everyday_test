package com.pascaciorc.everydaytest.utils

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import com.pascaciorc.everydaytest.R


object NotificationHelper {
    private const val CHANNEL_ID = "channel_name" // The id of the channel.

    fun showNotification(
        context: Context,
        title: String?,
        message: String?,
        intent: Intent?,
        reqCode: Int
    ) {
        val pendingIntent =
            PendingIntent.getActivity(context, reqCode, intent, PendingIntent.FLAG_ONE_SHOT)
        val builder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_calendar)
            .setContentTitle(title)
            .setContentText(message)
            .setAutoCancel(true)
            .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
            .setContentIntent(pendingIntent)
        val notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name: CharSequence = "Channel Name" // The user-visible name of the channel.
            val importance = NotificationManager.IMPORTANCE_HIGH
            val mChannel = NotificationChannel(CHANNEL_ID, name, importance)
            notificationManager.createNotificationChannel(mChannel)
        }
        notificationManager.notify(
            reqCode,
            builder.build()
        ) // 0 is the request code, it should be unique id
        Log.d("showNotification", "showNotification: $reqCode")
    }
}
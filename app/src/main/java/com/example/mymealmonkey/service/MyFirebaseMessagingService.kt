package com.example.mymealmonkey.service

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import com.example.mymealmonkey.R
import com.example.mymealmonkey.view.activity.MainActivity
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage


open class MyFirebaseMessagingService : FirebaseMessagingService() {

    companion object {
        const val TOKEN = "TOKEN"
    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.d(TOKEN, "Refreshed token: $token")
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {

        if (remoteMessage.notification != null) {
            pushNotification(
                remoteMessage.notification?.title!!,
                remoteMessage.notification?.body!!
            )
        }
    }

    private fun pushNotification(title: String, body: String) {

        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        val notificationBuilder: NotificationCompat.Builder
        val CHANNEL_ID = "push_noti"
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        val pendingIntent = PendingIntent.getActivity(
            this, 0 /* Request code */, intent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name: CharSequence = "Custom Channel"
            val description = "Channel for suh Notification"
            val importance: Int = NotificationManager.IMPORTANCE_DEFAULT

            val channel = NotificationChannel(CHANNEL_ID, name, importance)
            channel.description

            notificationManager.createNotificationChannel(channel)

            notificationBuilder = NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentText(body)
                .setContentTitle(title)
                .setAutoCancel(true)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setChannelId(CHANNEL_ID)
                .setContentIntent(pendingIntent)
        } else {
            notificationBuilder = NotificationCompat.Builder(this)
                .setContentText(body)
                .setContentTitle(title)
                .setAutoCancel(true)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentIntent(pendingIntent)
        }
        notificationManager.notify(0, notificationBuilder.build())
    }

    private fun sendNotification(remoteMessage: RemoteMessage) {
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        val pendingIntent = PendingIntent.getActivity(
            this, 0 /* Request code */, intent,
            PendingIntent.FLAG_ONE_SHOT or PendingIntent.FLAG_IMMUTABLE
        )
        val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val notificationBuilder = NotificationCompat.Builder(this)
            .setContentText(remoteMessage.notification?.body)
            .setAutoCancel(true)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setSound(defaultSoundUri)
            .setContentIntent(pendingIntent)
        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(0 /* ID of notification */, notificationBuilder.build())
    }
}
package com.awak.wekare.Service

import android.app.*
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.media.AudioAttributes
import android.media.RingtoneManager
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.awak.wekare.R

import com.bosphere.filelogger.FL

object NotificationService {




    fun Context.vectorToBitmap(drawableId: Int): Bitmap? {
        val drawable = ContextCompat.getDrawable(applicationContext, drawableId) ?: return null
        val bitmap = Bitmap.createBitmap(
            drawable.intrinsicWidth, drawable.intrinsicHeight, Bitmap.Config.ARGB_8888
        ) ?: return null
        val canvas = Canvas(bitmap)
        drawable.setBounds(0, 0, canvas.width, canvas.height)
        drawable.draw(canvas)
        return bitmap
    }

}


@RequiresApi(Build.VERSION_CODES.O)
fun createNotificationChannel(
    notification: NotificationCompat.Builder,
    notificationManager: NotificationManager,
    id: String,
    name: String,
    importance: Int
) {
    notification.setChannelId(id)
    val ringtoneManager = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
    val audioAttributes =
        AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_NOTIFICATION_RINGTONE)
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION).build()
    val channel =
        NotificationChannel(id, name, importance)

    channel.enableLights(true)
    channel.enableVibration(true)
    channel.setSound(ringtoneManager, audioAttributes)

    channel.lightColor = Color.RED
    channel.lockscreenVisibility = NotificationCompat.PRIORITY_HIGH
    channel.vibrationPattern = longArrayOf(100, 200, 300, 400, 500, 400, 300, 200, 400)
    FL.d("created notification channel")
    notificationManager.createNotificationChannel(channel)
}
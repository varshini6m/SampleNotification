package com.awak.wekare.Service

import android.app.*
import android.content.Intent
import android.graphics.Color
import android.os.*
import android.widget.RemoteViews
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat

import com.bosphere.filelogger.FL
import com.bosphere.filelogger.FLConfig
import com.bosphere.filelogger.FLConst
import com.awak.wekare.Utils.DateUtils
import com.awak.wekare.MainActivity
import com.awak.wekare.R
import com.awak.wekare.Service.NotificationService.vectorToBitmap
import com.awak.wekare.Service.createNotificationChannel
import com.awak.wekare.Utils.WeKareConstants
import com.awak.wekare.WeKareApplication


import java.io.File
import java.util.*

class MedTimerService : Service() {

    private val FOREGROUND_NOTIFY_ID = 5051

    private val TIME_GAP_FOR_NEXT_MEDICATION = 24 * 60 * 60 * 1000


    private var morningTime = 0L
    private var afternoonTime = 0L
    private var eveningTime = 0L
    private var nightTime = 0L



    private val minuteHandler: Handler = Handler()
    private val morningHandler: Handler = Handler()
    private val afternoonHandler: Handler = Handler()
    private val eveningHandler: Handler = Handler()
    private val nightHandler: Handler = Handler()
    private val teleconsultReminder: Handler = Handler()
    @RequiresApi(Build.VERSION_CODES.O)
    private val minuteRunnable: Runnable = Runnable {
        doTheProcess()

    }


    @RequiresApi(Build.VERSION_CODES.O)
    private fun doTheProcess() {
        File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).absolutePath + "/Wekare/data/handlerForEveryMinute").mkdirs()
        FL.init(
                FLConfig.Builder(this@MedTimerService)
                        .logger(null)       // customise how to hook up with logcat
                        .defaultTag("HandlerForEveryMinute Tag")   // customise default tag
                        .minLevel(FLConst.Level.V)   // customise minimum logging level
                        .logToFile(true)   // enable logging to file
                        .dir(File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).absolutePath + "/Wekare/data/handlerForEveryMinute"))    // customise directory to hold log files
                        .retentionPolicy(FLConst.RetentionPolicy.FILE_COUNT) // customise retention strategy
                        .maxFileCount(FLConst.DEFAULT_MAX_FILE_COUNT)    // customise how many log files to keep if retention by file count
                        .maxTotalSize(FLConst.DEFAULT_MAX_TOTAL_SIZE)    // customise how much space log files can occupy if retention by total size
                        .build()
        )
        FL.setEnabled(true)
        showMedsReminderNotification("HandlerForEveryMinute",DateUtils.getEpochDateTimeFromDate(System.currentTimeMillis()))

        FL.d(
            "HandlerForEveryMinute",
            "minute handler Current Time ${DateUtils.getEpochDateTimeFromDate(System.currentTimeMillis())}"
        )


        minuteHandler.removeCallbacksAndMessages(minuteRunnable)
        minuteHandler.postDelayed(minuteRunnable, 60 * 1000L)
    }


    override fun onCreate() {
        super.onCreate()

    }




    @RequiresApi(Build.VERSION_CODES.O)
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        // FL.d("onStartCommand")

        if (intent != null) {
            val action = intent.action
          //  TimberLogger.i("FOREGROUND-START-ID", startId.toString())
            //TimberLogger.i("FOREGROUND-ACTION", action.toString())
            return if (action == "START") {
                File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).absolutePath + "/Wekare/data/medicationTimerService").mkdirs()
                FL.init(
                    FLConfig.Builder(this@MedTimerService)
                        .logger(null)       // customise how to hook up with logcat
                        .defaultTag("MedicationTimerService Tag")   // customise default tag
                        .minLevel(FLConst.Level.V)   // customise minimum logging level
                        .logToFile(true)   // enable logging to file
                        .dir(File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).absolutePath + "/Wekare/data/medicationTimerService"))    // customise directory to hold log files
                        .retentionPolicy(FLConst.RetentionPolicy.FILE_COUNT) // customise retention strategy
                        .maxFileCount(FLConst.DEFAULT_MAX_FILE_COUNT)    // customise how many log files to keep if retention by file count
                        .maxTotalSize(FLConst.DEFAULT_MAX_TOTAL_SIZE)    // customise how much space log files can occupy if retention by total size
                        .build()
                )
                FL.setEnabled(true)
                FL.d("started MedicationTimerService")

//                processTimings(Injector.provideWeKareRepository().reminderTimeInfo)
                minuteHandler.postDelayed(minuteRunnable, 60 * 1000L)
                startForegroundService()
                showMedsReminderNotification("MedicationTimerService",DateUtils.getEpochDateTimeFromDate(System.currentTimeMillis()))

                START_STICKY

            } else {
                minuteHandler.removeCallbacksAndMessages(null)

                stopForeground(true)
                stopSelfResult(startId)
                FL.d("stopped MedicationTimerService")
                STOP_FOREGROUND_REMOVE
            }

        } else {
            return super.onStartCommand(intent, flags, startId)
        }


    }





    @RequiresApi(Build.VERSION_CODES.O)
    private fun startForegroundService() {
        val notification = buildForegroundNotification()
        notification.flags = Notification.FLAG_FOREGROUND_SERVICE.let {
            notification.flags = notification.flags or it; notification.flags
        }
        startForeground(
                FOREGROUND_NOTIFY_ID,
                notification
        )
        FL.d("start foreground service")
        File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).absolutePath + "/Wekare/data/logs5").mkdirs()
        FL.init(
                FLConfig.Builder(WeKareApplication.application.applicationContext)
                        .logger(null)       // customise how to hook up with logcat
                        .defaultTag("Background Tag")   // customise default tag
                        .minLevel(FLConst.Level.V)   // customise minimum logging level
                        .logToFile(true)   // enable logging to file
                        .dir(File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).absolutePath + "/Wekare/data/logs5"))    // customise directory to hold log files
//            .formatter(FileFormatter())    // customise log format and file name
                        .retentionPolicy(FLConst.RetentionPolicy.FILE_COUNT) // customise retention strategy
                        .maxFileCount(FLConst.DEFAULT_MAX_FILE_COUNT)    // customise how many log files to keep if retention by file count
                        .maxTotalSize(FLConst.DEFAULT_MAX_TOTAL_SIZE)    // customise how much space log files can occupy if retention by total size
                        .build()
        )
        FL.setEnabled(true)
    }
    @RequiresApi(Build.VERSION_CODES.O)
    private fun buildForegroundNotification(): Notification {

//        return getDefaultNotification()
        return getCustomNotification()

    }
    @RequiresApi(Build.VERSION_CODES.O)
    private fun getCustomNotification(): Notification {
        val notificationCompatBuilder =
                NotificationCompat.Builder(
                        applicationContext,
                        WeKareConstants.NOTIFICATION_CHANNEL_ID_MED
                )
        val notificationManager = notificationManager()
        createNotificationChannel(
                notificationCompatBuilder,
                notificationManager,
                WeKareConstants.NOTIFICATION_CHANNEL_ID_MED,
                WeKareConstants.NOTIFICATION_CHANNEL_NAME_MED,
                NotificationManager.IMPORTANCE_LOW
        )
        val notificationLayout = RemoteViews(packageName, R.layout.notification_meds_layout)



        val resultPendingIntent: PendingIntent? = getResultPIntent()
        notificationCompatBuilder
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentIntent(resultPendingIntent)
                //            .setStyle(NotificationCompat.DecoratedCustomViewStyle())
                .setCustomContentView(notificationLayout)
                .setOngoing(true)
                .setAutoCancel(true)
        return notificationCompatBuilder.build()
        FL.d("custom notification")
    }
    private fun notificationManager(): NotificationManager {
        return applicationContext.getSystemService(NOTIFICATION_SERVICE) as NotificationManager
    }
    private fun getResultPIntent(): PendingIntent? {
        val resultIntent = Intent(applicationContext, MainActivity::class.java)
        resultIntent.putExtra(WeKareConstants.IS_FROM_NOTIFICATION, true)
        resultIntent.putExtra(WeKareConstants.IS_FROM_THERAPY, false)
        resultIntent.putExtra(WeKareConstants.IS_MEDICATION_REMINDER, true)
        return TaskStackBuilder.create(applicationContext).run {
            addNextIntentWithParentStack(resultIntent)
            getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)
        }
    }
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }


    @RequiresApi(Build.VERSION_CODES.O)
    private fun showMedsReminderNotification(title: String, message: String) {

        val notificationCompatBuilder =
                NotificationCompat.Builder(
                        applicationContext,
                        WeKareConstants.NOTIFICATION_CHANNEL_IMPORTANT_ID
                )
        val notificationManager =
                notificationManager()
        createNotificationChannel(
                notificationCompatBuilder,
                notificationManager,
                WeKareConstants.NOTIFICATION_CHANNEL_IMPORTANT_ID,
                WeKareConstants.NOTIFICATION_CHANNEL_IMPORTANT_NAME,
                NotificationManager.IMPORTANCE_HIGH
        )
        val bitmap = applicationContext.vectorToBitmap(R.drawable.ic_launcher_background)
        val resultPendingIntent: PendingIntent? = getResultPIntent()
        notificationCompatBuilder
                .setLargeIcon(bitmap).setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle(title)
                .setContentText(message)
                .setContentIntent(resultPendingIntent)
                .setBadgeIconType(NotificationCompat.BADGE_ICON_LARGE)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setColor(Color.parseColor("#f06d35"))
                .setStyle(NotificationCompat.BigTextStyle().bigText(message))
                .setAutoCancel(true)

        notificationManager.notify(
                System.currentTimeMillis().toInt(),
                notificationCompatBuilder.build()
        )

        FL.d("Posted Medication Notification to the system ")
    }






  





}
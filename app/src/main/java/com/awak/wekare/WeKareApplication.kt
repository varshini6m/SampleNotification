package com.awak.wekare

import android.app.Dialog
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

import androidx.multidex.MultiDexApplication
import com.awak.wekare.WeKareApplication.Companion.isInDevelopmentMode

import com.clevertap.android.sdk.ActivityLifecycleCallback
import com.clevertap.android.sdk.CleverTapAPI
import com.clevertap.android.sdk.pushnotification.amp.CTPushAmpListener
import com.google.firebase.iid.FirebaseInstanceId




const val BC_IS_APP_IN_FOREGROUND_KEY = BuildConfig.APPLICATION_ID + ".APP_IN_FOREGROUND"
const val BC_IS_APP_IN_SSL_EXCEPTION = BuildConfig.APPLICATION_ID + ".SSL_EXCEPTION"
const val BC_IS_APP_INVALID_VERSION = BuildConfig.APPLICATION_ID + ".INVALID_APP_VERSION"
const val BC_IS_APP_BIOMETRIC = BuildConfig.APPLICATION_ID + ".BIOMETRIC"
const val BC_IS_APP_SESSION_EXPIRED = BuildConfig.APPLICATION_ID + ".BC_IS_APP_SESSION_EXPIRED"
const val DISCLAIMER_SHOW = BuildConfig.APPLICATION_ID + ".DISCLAIMER_SHOW"
const val BC_IS_APP_IN_MALICIOUS_ENVIRONMENT =
    BuildConfig.APPLICATION_ID + ".BC_IS_APP_IN_MALICIOUS_ENVIRONMENT"
const val BC_IS_MEDICATION_TIMINGS_CHANGED_KEY =
    BuildConfig.APPLICATION_ID + ".BC_IS_MEDICATION_TIMINGS_CHANGED_KEY"
const val BC_IS_MEDICATION_LAUNCH_ALL_MEDS_KEY =
    BuildConfig.APPLICATION_ID + ".BC_IS_MEDICATION_LAUNCH_ALL_MEDS_KEY"
var APP_VERIFIER = "DMDIJNrlC8oaALvTId2Ai/swNu0=\n"
var isFromAfterVitals = false
val TIME_WINDOW_FOR_BACKGROUND_VALIDATION = if (isInDevelopmentMode()) {
    15 * 60 * 1000 // 15 sec
} else {
    30 * 60 * 1000 // 30 minutes
}

val TIME_WINDOW_FOR_FOREGROUND_VALIDATION = if (isInDevelopmentMode()) {
    15 * 60 * 1000 // 15 Minutes
} else {
    30 * 60 * 1000 // 30 minutes
}
const val APP_UPDATE_REQUEST_CODE = 5049
var uploadProgress: Double = 0.0

/**@param IS_SECURE_APP
 * true -- helps to make application to use security features like Root,emulator,MITM attack detections
 * false -- do not uses all security mechanisms
 * */

//var IS_SECURE_APP:Boolean = false

// appComponent lives in the Application class to share its lifecycle
class WeKareApplication : MultiDexApplication(), LifecycleObserver, OnBaseActivityListener,
    CTPushAmpListener {

    // Reference to the application graph that is used across the whole app
    private lateinit var mApplicationComponent: ApplicationComponent

    lateinit var updateDialog: Dialog

    // time when app launches
    var appStartBeginTime: Long = 0L


    // time when app goes to the background
    var appWentToBackGroundTime: Long = 0L

    companion object {
        lateinit var toasterObject: Toast

        fun isInDevelopmentMode() =
            (BuildConfig.BUILD_TYPE == "stagingdev"
                    || BuildConfig.BUILD_TYPE == "debug"
                    || BuildConfig.BUILD_TYPE == "devdev"
                    || BuildConfig.BUILD_TYPE == "qadev")


        lateinit var application: WeKareApplication
        fun getInstance() = WeKareApplication()
        lateinit var connManager: ConnectivityManager
        var cleverTapDefaultInstance: CleverTapAPI? = null

    }

    fun getComponent(): ApplicationComponent {
        return mApplicationComponent
    }

    override fun onCreate() {

        super.onCreate()
        application = this
        initAppDagger()


    }


    private fun showBuildData() {
        val BOARD = Build.BOARD
        val BRAND = Build.BRAND
        val DEVICE = Build.DEVICE
        val HARDWARE = Build.HARDWARE
        val MODEL = Build.MODEL
        val PRODUCT = Build.PRODUCT


    }



    private fun initAppDagger() {
        mApplicationComponent =
                DaggerApplicationComponent.builder().appModule(AppModule(this)).build()
        mApplicationComponent.inject(this)
    }




    @RequiresApi(Build.VERSION_CODES.O)
    private fun createDownloadNotificationChannel(
        channelId: String,
        channelName: String,
        context: Context
    ) {
        val notificationChannel = NotificationChannel(
            channelId,
            channelName,
            NotificationManager.IMPORTANCE_HIGH
        ).apply {
            lockscreenVisibility = Notification.VISIBILITY_PUBLIC
        }
        val notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(notificationChannel)
    }




    /** validates the last kill and current launch time gap and asks for Bio metric validation
     * With every launch validates if there is already a verification is in pending or not
     * and last kill time to current time difference should fall below <<X seconds>> after that user can login without validation also
     * For the launch validates time with last kill time from shared prefs and checks if the last kill happened during verifications
     * with the first launch verification will only be asked when last kill was on verification and reopened the app again within time window
     * after the time window even if the app killed during verification app will not ask for verification
     * When app moves between foreground and background time validated based on
     * @param appWentToBackGroundTime
     * && (System.currentTimeMillis() - appWentToBackGroundTime) <= TIME_WINDOW_FOR_BACKGROUND_VALIDATION
     * */










    override fun onPushAmpPayloadReceived(extras: Bundle?) {


    }

    override fun onDestroy() {
        TODO("Not yet implemented")
    }
}

interface OnBaseActivityListener {
    fun onDestroy()
}


interface RefreshTokenApiListener {
    fun onSuccess()
    fun onError()
}
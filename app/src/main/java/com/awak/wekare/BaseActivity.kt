package com.awak.wekare

import android.app.KeyguardManager
import android.app.NotificationManager
import android.content.*
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity


import androidx.lifecycle.ViewModelProvider
import com.awak.*
import com.awak.wekare.Service.MedTimerService


import com.bosphere.filelogger.FL

import javax.inject.Inject


open class BaseActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    var localAppStartBeginTime: Long? = null
    private lateinit var mActivityComponent: ActivityComponent


    //private var vitalComponent: VitalComponent? = null



    private var isToShowConnectionStatus = false

    companion object {
        var isDialogShowing = false

    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivityComponent = DaggerActivityComponent.builder()

                .applicationComponent((application as WeKareApplication).getComponent())
                .build()




    }










    override fun onDestroy() {
        super.onDestroy()

    }


    //ktx co-routine to accessing viewModels


















    override fun onResume() {
        //Low: Insecure State Transition
     window.clearFlags(WindowManager.LayoutParams.FLAG_SECURE)
        super.onResume()

//        updateUtils.addOnResumeListener(this)

    }

    override fun onStart() {
        super.onStart()


    }

    override fun onStop() {
        super.onStop()
        //stopBiometricTimer()



    }







    private fun cancelAllNotifications() {
        (applicationContext.getSystemService(NOTIFICATION_SERVICE) as NotificationManager).cancelAll()
    }



    fun doubleBack() {
        onBackPressed()
        onBackPressed()
    }










    /*Listening For Activity Result on UPDATE UTILS
    * @RESULT_OK: The user has accepted the update.
    * For immediate updates, you might not receive this callback
    * because the update should already be finished by the time control is given back to your app.
    * @RESULT_CANCELED: The user has denied or canceled the update.
    * @ActivityResult.RESULT_IN_APP_UPDATE_FAILED: Some other error prevented either the user from providing consent
    * or the update from proceeding.
    * */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

    }





    private fun startForegroundServiceForTimerMedications() {
        FL.d(" STARTED MEDICATION SERVICE")

        val serviceIntent = Intent(
            this,
                MedTimerService::class.java
        )
        serviceIntent.action = "START"
        this.startService(serviceIntent)
    }

    fun restartMedicationReminderService() {
        FL.d("RE STARTED MEDICATION SERVICE")
        startForegroundServiceForTimerMedications()
    }


    //Low: Insecure State Transition
    override fun onPause() {
        window.setFlags(WindowManager.LayoutParams.FLAG_SECURE,
        WindowManager.LayoutParams.FLAG_SECURE)
        /*this.window.decorView.rootView.scaleX = 200.toFloat()
        this.window.decorView.rootView.scaleY = 200.toFloat()*/
        super.onPause()

    }
//Low: Insecure State Transition
    override fun onPostResume() {
        window.clearFlags(WindowManager.LayoutParams.FLAG_SECURE)
        super.onPostResume()
    }


}


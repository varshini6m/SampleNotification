package com.awak.wekare;

import java.lang.System;

/**
 * @param IS_SECURE_APP
 * true -- helps to make application to use security features like Root,emulator,MITM attack detections
 * false -- do not uses all security mechanisms
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 &2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001&B\u0005\u00a2\u0006\u0002\u0010\u0005J \u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001dH\u0003J\u0006\u0010\u001e\u001a\u00020\u0010J\b\u0010\u001f\u001a\u00020\u0018H\u0002J\b\u0010 \u001a\u00020\u0018H\u0016J\b\u0010!\u001a\u00020\u0018H\u0016J\u0012\u0010\"\u001a\u00020\u00182\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010%\u001a\u00020\u0018H\u0002R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\'"}, d2 = {"Lcom/awak/wekare/WeKareApplication;", "Landroidx/multidex/MultiDexApplication;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/awak/wekare/OnBaseActivityListener;", "Lcom/clevertap/android/sdk/pushnotification/amp/CTPushAmpListener;", "()V", "appStartBeginTime", "", "getAppStartBeginTime", "()J", "setAppStartBeginTime", "(J)V", "appWentToBackGroundTime", "getAppWentToBackGroundTime", "setAppWentToBackGroundTime", "mApplicationComponent", "Lcom/awak/wekare/ApplicationComponent;", "updateDialog", "Landroid/app/Dialog;", "getUpdateDialog", "()Landroid/app/Dialog;", "setUpdateDialog", "(Landroid/app/Dialog;)V", "createDownloadNotificationChannel", "", "channelId", "", "channelName", "context", "Landroid/content/Context;", "getComponent", "initAppDagger", "onCreate", "onDestroy", "onPushAmpPayloadReceived", "extras", "Landroid/os/Bundle;", "showBuildData", "Companion", "app_debug"})
public final class WeKareApplication extends androidx.multidex.MultiDexApplication implements androidx.lifecycle.LifecycleObserver, com.awak.wekare.OnBaseActivityListener, com.clevertap.android.sdk.pushnotification.amp.CTPushAmpListener {
    private com.awak.wekare.ApplicationComponent mApplicationComponent;
    @org.jetbrains.annotations.NotNull()
    public android.app.Dialog updateDialog;
    private long appStartBeginTime;
    private long appWentToBackGroundTime;
    @org.jetbrains.annotations.NotNull()
    public static android.widget.Toast toasterObject;
    @org.jetbrains.annotations.NotNull()
    public static com.awak.wekare.WeKareApplication application;
    @org.jetbrains.annotations.NotNull()
    public static android.net.ConnectivityManager connManager;
    @org.jetbrains.annotations.Nullable()
    private static com.clevertap.android.sdk.CleverTapAPI cleverTapDefaultInstance;
    public static final com.awak.wekare.WeKareApplication.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.Dialog getUpdateDialog() {
        return null;
    }
    
    public final void setUpdateDialog(@org.jetbrains.annotations.NotNull()
    android.app.Dialog p0) {
    }
    
    public final long getAppStartBeginTime() {
        return 0L;
    }
    
    public final void setAppStartBeginTime(long p0) {
    }
    
    public final long getAppWentToBackGroundTime() {
        return 0L;
    }
    
    public final void setAppWentToBackGroundTime(long p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.awak.wekare.ApplicationComponent getComponent() {
        return null;
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    private final void showBuildData() {
    }
    
    private final void initAppDagger() {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    private final void createDownloadNotificationChannel(java.lang.String channelId, java.lang.String channelName, android.content.Context context) {
    }
    
    /**
     * validates the last kill and current launch time gap and asks for Bio metric validation
     * With every launch validates if there is already a verification is in pending or not
     * and last kill time to current time difference should fall below <<X seconds>> after that user can login without validation also
     * For the launch validates time with last kill time from shared prefs and checks if the last kill happened during verifications
     * with the first launch verification will only be asked when last kill was on verification and reopened the app again within time window
     * after the time window even if the app killed during verification app will not ask for verification
     * When app moves between foreground and background time validated based on
     * @param appWentToBackGroundTime
     * && (System.currentTimeMillis() - appWentToBackGroundTime) <= TIME_WINDOW_FOR_BACKGROUND_VALIDATION
     */
    @java.lang.Override()
    public void onPushAmpPayloadReceived(@org.jetbrains.annotations.Nullable()
    android.os.Bundle extras) {
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    public WeKareApplication() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u001b\u001a\u00020\u0004J\u0006\u0010\u001c\u001a\u00020\u001dR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/awak/wekare/WeKareApplication$Companion;", "", "()V", "application", "Lcom/awak/wekare/WeKareApplication;", "getApplication", "()Lcom/awak/wekare/WeKareApplication;", "setApplication", "(Lcom/awak/wekare/WeKareApplication;)V", "cleverTapDefaultInstance", "Lcom/clevertap/android/sdk/CleverTapAPI;", "getCleverTapDefaultInstance", "()Lcom/clevertap/android/sdk/CleverTapAPI;", "setCleverTapDefaultInstance", "(Lcom/clevertap/android/sdk/CleverTapAPI;)V", "connManager", "Landroid/net/ConnectivityManager;", "getConnManager", "()Landroid/net/ConnectivityManager;", "setConnManager", "(Landroid/net/ConnectivityManager;)V", "toasterObject", "Landroid/widget/Toast;", "getToasterObject", "()Landroid/widget/Toast;", "setToasterObject", "(Landroid/widget/Toast;)V", "getInstance", "isInDevelopmentMode", "", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.Toast getToasterObject() {
            return null;
        }
        
        public final void setToasterObject(@org.jetbrains.annotations.NotNull()
        android.widget.Toast p0) {
        }
        
        public final boolean isInDevelopmentMode() {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.awak.wekare.WeKareApplication getApplication() {
            return null;
        }
        
        public final void setApplication(@org.jetbrains.annotations.NotNull()
        com.awak.wekare.WeKareApplication p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.awak.wekare.WeKareApplication getInstance() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.net.ConnectivityManager getConnManager() {
            return null;
        }
        
        public final void setConnManager(@org.jetbrains.annotations.NotNull()
        android.net.ConnectivityManager p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.clevertap.android.sdk.CleverTapAPI getCleverTapDefaultInstance() {
            return null;
        }
        
        public final void setCleverTapDefaultInstance(@org.jetbrains.annotations.Nullable()
        com.clevertap.android.sdk.CleverTapAPI p0) {
        }
        
        private Companion() {
            super();
        }
    }
}
package com.awak.wekare.Service;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0003J\b\u0010\u0016\u001a\u00020\u0017H\u0003J\b\u0010\u0018\u001a\u00020\u0015H\u0003J\n\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\u0017H\u0016J\"\u0010\"\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0004H\u0017J\u0018\u0010%\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\'2\u0006\u0010(\u001a\u00020\'H\u0003J\b\u0010)\u001a\u00020\u0017H\u0003R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000e8\u0002X\u0083\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006*"}, d2 = {"Lcom/awak/wekare/Service/MedTimerService;", "Landroid/app/Service;", "()V", "FOREGROUND_NOTIFY_ID", "", "TIME_GAP_FOR_NEXT_MEDICATION", "afternoonHandler", "Landroid/os/Handler;", "afternoonTime", "", "eveningHandler", "eveningTime", "minuteHandler", "minuteRunnable", "Ljava/lang/Runnable;", "morningHandler", "morningTime", "nightHandler", "nightTime", "teleconsultReminder", "buildForegroundNotification", "Landroid/app/Notification;", "doTheProcess", "", "getCustomNotification", "getResultPIntent", "Landroid/app/PendingIntent;", "notificationManager", "Landroid/app/NotificationManager;", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onCreate", "onStartCommand", "flags", "startId", "showMedsReminderNotification", "title", "", "message", "startForegroundService", "app_debug"})
public final class MedTimerService extends android.app.Service {
    private final int FOREGROUND_NOTIFY_ID = 5051;
    private final int TIME_GAP_FOR_NEXT_MEDICATION = 86400000;
    private long morningTime;
    private long afternoonTime;
    private long eveningTime;
    private long nightTime;
    private final android.os.Handler minuteHandler = null;
    private final android.os.Handler morningHandler = null;
    private final android.os.Handler afternoonHandler = null;
    private final android.os.Handler eveningHandler = null;
    private final android.os.Handler nightHandler = null;
    private final android.os.Handler teleconsultReminder = null;
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    private final java.lang.Runnable minuteRunnable = null;
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    private final void doTheProcess() {
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    @java.lang.Override()
    public int onStartCommand(@org.jetbrains.annotations.Nullable()
    android.content.Intent intent, int flags, int startId) {
        return 0;
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    private final void startForegroundService() {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    private final android.app.Notification buildForegroundNotification() {
        return null;
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    private final android.app.Notification getCustomNotification() {
        return null;
    }
    
    private final android.app.NotificationManager notificationManager() {
        return null;
    }
    
    private final android.app.PendingIntent getResultPIntent() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.os.IBinder onBind(@org.jetbrains.annotations.Nullable()
    android.content.Intent intent) {
        return null;
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    private final void showMedsReminderNotification(java.lang.String title, java.lang.String message) {
    }
    
    public MedTimerService() {
        super();
    }
}
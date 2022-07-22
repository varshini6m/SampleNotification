package com.awak.wekare;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0005\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007\"\u000e\u0010\b\u001a\u00020\u0003X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0003X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0003X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0003X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0003X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0003X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0003X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0003X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0003X\u0086T\u00a2\u0006\u0002\n\u0000\"\u0011\u0010\u0011\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0011\u0010\u0014\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013\"\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0018\"\u0004\b\u0019\u0010\u001a\"\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006!"}, d2 = {"APP_UPDATE_REQUEST_CODE", "", "APP_VERIFIER", "", "getAPP_VERIFIER", "()Ljava/lang/String;", "setAPP_VERIFIER", "(Ljava/lang/String;)V", "BC_IS_APP_BIOMETRIC", "BC_IS_APP_INVALID_VERSION", "BC_IS_APP_IN_FOREGROUND_KEY", "BC_IS_APP_IN_MALICIOUS_ENVIRONMENT", "BC_IS_APP_IN_SSL_EXCEPTION", "BC_IS_APP_SESSION_EXPIRED", "BC_IS_MEDICATION_LAUNCH_ALL_MEDS_KEY", "BC_IS_MEDICATION_TIMINGS_CHANGED_KEY", "DISCLAIMER_SHOW", "TIME_WINDOW_FOR_BACKGROUND_VALIDATION", "getTIME_WINDOW_FOR_BACKGROUND_VALIDATION", "()I", "TIME_WINDOW_FOR_FOREGROUND_VALIDATION", "getTIME_WINDOW_FOR_FOREGROUND_VALIDATION", "isFromAfterVitals", "", "()Z", "setFromAfterVitals", "(Z)V", "uploadProgress", "", "getUploadProgress", "()D", "setUploadProgress", "(D)V", "app_debug"})
public final class WeKareApplicationKt {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BC_IS_APP_IN_FOREGROUND_KEY = "com.awak.wekare.APP_IN_FOREGROUND";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BC_IS_APP_IN_SSL_EXCEPTION = "com.awak.wekare.SSL_EXCEPTION";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BC_IS_APP_INVALID_VERSION = "com.awak.wekare.INVALID_APP_VERSION";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BC_IS_APP_BIOMETRIC = "com.awak.wekare.BIOMETRIC";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BC_IS_APP_SESSION_EXPIRED = "com.awak.wekare.BC_IS_APP_SESSION_EXPIRED";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DISCLAIMER_SHOW = "com.awak.wekare.DISCLAIMER_SHOW";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BC_IS_APP_IN_MALICIOUS_ENVIRONMENT = "com.awak.wekare.BC_IS_APP_IN_MALICIOUS_ENVIRONMENT";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BC_IS_MEDICATION_TIMINGS_CHANGED_KEY = "com.awak.wekare.BC_IS_MEDICATION_TIMINGS_CHANGED_KEY";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BC_IS_MEDICATION_LAUNCH_ALL_MEDS_KEY = "com.awak.wekare.BC_IS_MEDICATION_LAUNCH_ALL_MEDS_KEY";
    @org.jetbrains.annotations.NotNull()
    private static java.lang.String APP_VERIFIER;
    private static boolean isFromAfterVitals;
    private static final int TIME_WINDOW_FOR_BACKGROUND_VALIDATION = 0;
    private static final int TIME_WINDOW_FOR_FOREGROUND_VALIDATION = 0;
    public static final int APP_UPDATE_REQUEST_CODE = 5049;
    private static double uploadProgress;
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String getAPP_VERIFIER() {
        return null;
    }
    
    public static final void setAPP_VERIFIER(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public static final boolean isFromAfterVitals() {
        return false;
    }
    
    public static final void setFromAfterVitals(boolean p0) {
    }
    
    public static final int getTIME_WINDOW_FOR_BACKGROUND_VALIDATION() {
        return 0;
    }
    
    public static final int getTIME_WINDOW_FOR_FOREGROUND_VALIDATION() {
        return 0;
    }
    
    public static final double getUploadProgress() {
        return 0.0;
    }
    
    public static final void setUploadProgress(double p0) {
    }
}
package com.awak.wekare;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0007J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/awak/wekare/ActivityModule;", "", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "provideActivity", "provideContext", "Landroid/content/Context;", "app_debug"})
@dagger.Module()
public final class ActivityModule {
    private androidx.appcompat.app.AppCompatActivity activity;
    
    @org.jetbrains.annotations.Nullable()
    @ActivityContext()
    @dagger.Provides()
    public final android.content.Context provideContext() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @dagger.Provides()
    public final androidx.appcompat.app.AppCompatActivity provideActivity() {
        return null;
    }
    
    public ActivityModule(@org.jetbrains.annotations.Nullable()
    androidx.appcompat.app.AppCompatActivity activity) {
        super();
    }
}
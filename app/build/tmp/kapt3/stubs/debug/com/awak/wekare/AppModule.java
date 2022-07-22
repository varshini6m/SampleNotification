package com.awak.wekare;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0007J\b\u0010\u0006\u001a\u00020\u0007H\u0007J\b\u0010\b\u001a\u00020\tH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/awak/wekare/AppModule;", "", "mApplication", "Landroid/app/Application;", "(Landroid/app/Application;)V", "provideApplication", "provideContext", "Landroid/content/Context;", "provideIsDebug", "", "app_debug"})
@dagger.Module()
public final class AppModule {
    private android.app.Application mApplication;
    
    @org.jetbrains.annotations.NotNull()
    @ApplicationContext()
    @dagger.Provides()
    public final android.content.Context provideContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @ApplicationScope()
    @dagger.Provides()
    public final android.app.Application provideApplication() {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    public final boolean provideIsDebug() {
        return false;
    }
    
    public AppModule(@org.jetbrains.annotations.NotNull()
    android.app.Application mApplication) {
        super();
    }
}
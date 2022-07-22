package com.awak.wekare;

import java.lang.System;

/**
 * @Component Definition of the Application graph
 * @Singleton Single Instance
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\'J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/awak/wekare/ApplicationComponent;", "", "context", "Landroid/content/Context;", "inject", "", "application", "Lcom/awak/wekare/WeKareApplication;", "app_debug"})
@dagger.Component(modules = {com.awak.wekare.AppModule.class})
@ApplicationScope()
@javax.inject.Singleton()
public abstract interface ApplicationComponent {
    
    @org.jetbrains.annotations.NotNull()
    @ApplicationContext()
    public abstract android.content.Context context();
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    com.awak.wekare.WeKareApplication application);
}
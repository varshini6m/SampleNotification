// Generated by Dagger (https://dagger.dev).
package com.awak.wekare;

import android.content.Context;
import dagger.internal.Factory;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ActivityModule_ProvideContextFactory implements Factory<Context> {
  private final ActivityModule module;

  public ActivityModule_ProvideContextFactory(ActivityModule module) {
    this.module = module;
  }

  @Override
  @Nullable
  public Context get() {
    return provideContext(module);
  }

  public static ActivityModule_ProvideContextFactory create(ActivityModule module) {
    return new ActivityModule_ProvideContextFactory(module);
  }

  @Nullable
  public static Context provideContext(ActivityModule instance) {
    return instance.provideContext();
  }
}

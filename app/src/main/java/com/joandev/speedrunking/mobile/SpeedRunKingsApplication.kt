package com.joandev.speedrunking.mobile

import android.app.Application
import com.joandev.speedrunking.di.appModule
import org.koin.core.context.startKoin

class SpeedRunKingsApplication: Application() {

  override fun onCreate() {
    super.onCreate()
    startKoin {
      modules(appModule)
    }
  }
}
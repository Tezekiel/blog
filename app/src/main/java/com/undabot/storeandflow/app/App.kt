package com.undabot.storeandflow.app

import android.app.Application
import com.undabot.storeandflow.di.interactorModule
import com.undabot.storeandflow.di.repositoryModule
import com.undabot.storeandflow.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

  override fun onCreate() {
    super.onCreate()

    initializeKoin()
  }

  private fun initializeKoin() {
    startKoin {
      androidLogger(org.koin.core.logger.Level.DEBUG)
      androidContext(this@App)
      modules(listOf(repositoryModule, viewModelModule, interactorModule))
    }
  }
}

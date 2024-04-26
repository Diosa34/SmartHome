package com.github.diosa.smarthome

import android.app.Application

class App : Application() {
    val database by lazy { MainDB.createDataBase(this) }
}
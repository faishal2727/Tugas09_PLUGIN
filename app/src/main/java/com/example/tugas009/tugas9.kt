package com.example.tugas009

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

class tugas9  : Application(){
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        val config = RealmConfiguration.Builder().name("aplikasi").build()
        Realm.setDefaultConfiguration(config)


    }
}
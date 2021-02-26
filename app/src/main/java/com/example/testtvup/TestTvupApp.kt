package com.example.testtvup

import android.app.Application
import com.example.testtvup.di.DaggerMyTvupTestComponent
import com.example.testtvup.di.MyTvupTestComponent

class TestTvupApp : Application() {

    lateinit var component: MyTvupTestComponent
        private set

    override fun onCreate() {
        super.onCreate()

        component = DaggerMyTvupTestComponent.factory().create(this)

    }

}
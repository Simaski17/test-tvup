package com.example.testtvup.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface MyTvupTestComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: Application): MyTvupTestComponent
    }

}
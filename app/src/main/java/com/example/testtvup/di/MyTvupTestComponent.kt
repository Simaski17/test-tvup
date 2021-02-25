package com.example.testtvup.di

import android.app.Application
import com.example.testtvup.ui.catalogue.CatalogueMainFragmentComponent
import com.example.testtvup.ui.catalogue.CatalogueMainFragmentModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, DataModule::class])
interface MyTvupTestComponent {

    fun plus(module: CatalogueMainFragmentModule): CatalogueMainFragmentComponent

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: Application): MyTvupTestComponent
    }

}
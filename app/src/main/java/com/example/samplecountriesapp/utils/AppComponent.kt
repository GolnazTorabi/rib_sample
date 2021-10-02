package com.example.samplecountriesapp.utils

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/*@Component(
    modules = [
        NetworkModule::class,
        RepositoryModule::class,
    MainActivityModule::class,
    AndroidSupportInjectionModule::class]
)
@Singleton
interface AppComponent {


    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    *//*
     * This is our custom Application class
     * *//*
    fun inject(appController: AppController)
}*/

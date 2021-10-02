package com.example.samplecountriesapp.root.di

import com.example.samplecountriesapp.root.RootInteractors
import com.example.samplecountriesapp.root.RootRouter
import com.example.samplecountriesapp.root.RootView
import com.example.samplecountriesapp.root.countries.CountriesBuilder
import dagger.Binds
import dagger.Provides

/*@dagger.Module
abstract class Module {

    @RootScope
    @Binds
    internal abstract fun presenter(view: RootView): RootInteractors.RootPresenter

    @dagger.Module
    companion object {


        @RootScope
        @Provides
        @JvmStatic
        internal fun router(
            component: Component,
            view: RootView,
            interactor: RootInteractors
        ): RootRouter {
            return RootRouter(view, interactor, component, CountriesBuilder(component))
        }
    }
}*/

package com.example.samplecountriesapp.root.countries

import android.content.Context
import android.util.Log
import com.example.samplecountriesapp.root.countries.list.CountriesListBuilder
import com.example.samplecountriesapp.root.RootView
import com.example.samplecountriesapp.root.countries.list.data.repository.CharactersRepository
import com.example.samplecountriesapp.root.countries.list.data.repository.Repository
import com.uber.rib.core.Builder;
import com.uber.rib.core.EmptyPresenter
import com.uber.rib.core.InteractorBaseComponent
import dagger.BindsInstance
import dagger.Provides
import javax.inject.Qualifier
import javax.inject.Scope


class CountriesBuilder (dependency: ParentComponent) : Builder<CountriesRouter, CountriesBuilder.ParentComponent>(dependency) {
    fun build(): CountriesRouter {
        Log.d("TAG", "build: coun")
        val interactor = CountriesInteractor()
        val component = DaggerCountriesBuilder_Component.builder()
            .parentComponent(dependency)
            .interactor(interactor)
            .build()

        return component.characterRouter()
    }

    interface ParentComponent {

        fun rootView(): RootView

        fun context(): Context
    }

    @dagger.Module
    object Module {

        @CoinScope
        @Provides
        @JvmStatic
        internal fun presenter(): EmptyPresenter {
            return EmptyPresenter()
        }

        @CoinScope
        @Provides
        @JvmStatic
        internal fun router(rootView: RootView, component: Component, interactor: CountriesInteractor): CountriesRouter {
            return CountriesRouter(rootView, interactor, component, CountriesListBuilder(component))
        }
    }

    @CoinScope
    @dagger.Component(modules = arrayOf(Module::class), dependencies = arrayOf(ParentComponent::class))
    interface Component : InteractorBaseComponent<CountriesInteractor>, BuilderComponent,
        CountriesListBuilder.ParentComponent {

        @dagger.Component.Builder
        interface Builder {
            @BindsInstance
            fun interactor(interactor: CountriesInteractor): Builder

            fun parentComponent(component: ParentComponent): Builder
            fun build(): Component
        }

    }

    interface BuilderComponent {
        fun characterRouter(): CountriesRouter
    }

    @Scope
    @Retention(AnnotationRetention.BINARY)
    internal annotation class CoinScope


    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    internal annotation class CoinInternal
}
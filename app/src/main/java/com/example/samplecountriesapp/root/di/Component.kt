package com.example.samplecountriesapp.root.di

import android.content.Context
import com.example.samplecountriesapp.root.RootBuilder
import com.example.samplecountriesapp.root.RootInteractors
import com.example.samplecountriesapp.root.RootView
import com.example.samplecountriesapp.root.countries.CountriesBuilder
import com.uber.rib.core.InteractorBaseComponent
import dagger.BindsInstance

/*@RootScope
@dagger.Component(modules = [Module::class], dependencies = [RootBuilder.ParentComponent::class])
interface Component : InteractorBaseComponent<RootInteractors>, BuilderComponent,
    CountriesBuilder.ParentComponent {
    @dagger.Component.Builder
    interface Builder {
        @BindsInstance
        fun interactor(interactor: RootInteractors): Builder

        @BindsInstance
        fun view(view: RootView): Builder

        fun parentComponent(component: RootBuilder.ParentComponent): Builder

        @BindsInstance
        fun provideContext(context: Context): Builder

        fun build(): Component
    }
}*/

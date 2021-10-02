package com.example.samplecountriesapp.root

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.samplecountriesapp.R
import com.example.samplecountriesapp.root.countries.CountriesBuilder
import com.example.samplecountriesapp.root.di.BuilderComponent
import com.example.samplecountriesapp.root.di.RootScope
import com.uber.rib.core.InteractorBaseComponent
import com.uber.rib.core.ViewBuilder
import dagger.Binds
import dagger.BindsInstance
import dagger.Provides
import javax.inject.Inject


class RootBuilder @Inject constructor(dependency: ParentComponent) :
    ViewBuilder<RootView, RootRouter, RootBuilder.ParentComponent>(dependency) {

    interface ParentComponent

    fun build(context: Context, parentViewGroup: ViewGroup): RootRouter {
        Log.d("TAG", "build: ")
        val component = DaggerRootBuilder_Component.builder()
            .parentComponent(dependency)
            .view(createView(parentViewGroup))
            .interactor(RootInteractors())
            .provideContext(context)
            .build()
        return component.rootRouter()
    }

    override fun inflateView(inflater: LayoutInflater, parentViewGroup: ViewGroup): RootView {
        return inflater.inflate(R.layout.activity_main, parentViewGroup, false) as RootView
    }

    @dagger.Module
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
    }

    @RootScope
    @dagger.Component(modules = [Module::class], dependencies = [ParentComponent::class])
    interface Component : InteractorBaseComponent<RootInteractors>, BuilderComponent,
        CountriesBuilder.ParentComponent {
        @dagger.Component.Builder
        interface Builder {
            @BindsInstance
            fun interactor(interactor: RootInteractors): Builder

            @BindsInstance
            fun view(view: RootView): Builder

            fun parentComponent(component: ParentComponent): Builder

            @BindsInstance
            fun provideContext(context: Context): Builder

            fun build(): Component
        }
    }

    /* interface BuilderComponent {
         fun rootRouter(): RootRouter
     }*/

/*    @Scope
    @Retention(AnnotationRetention.RUNTIME)
    internal annotation class RootScope*/


}
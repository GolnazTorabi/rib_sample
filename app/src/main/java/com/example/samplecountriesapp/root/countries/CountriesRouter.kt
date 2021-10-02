package com.example.samplecountriesapp.root.countries

import android.util.Log
import android.view.ViewGroup
import com.example.samplecountriesapp.root.countries.list.CountriesListBuilder
import com.example.samplecountriesapp.root.countries.list.CountriesListRouter
import com.example.samplecountriesapp.root.RootView
import com.example.samplecountriesapp.root.countries.list.data.repository.CharactersRepository
import com.uber.rib.core.Router

class CountriesRouter(
    val rootView: RootView,
    interactor: CountriesInteractor,
    component: CountriesBuilder.Component,
    val countriesListBuilder: CountriesListBuilder
) : Router<CountriesInteractor>(interactor, component) {

    private lateinit var countiesListRouter: CountriesListRouter

    fun routeToCountriesList() {
        countiesListRouter = countriesListBuilder.build(rootView as ViewGroup)
        attachChild(countiesListRouter)
        rootView.addView(countiesListRouter.view)
        Log.d("TAG", "routeToCountriesList: ")
    }

    fun detachCountriesList() {
        Log.d("TAG", "detachCountriesList: ")

        detachChild(countiesListRouter)
        rootView.removeView(countiesListRouter.view)
    }
}
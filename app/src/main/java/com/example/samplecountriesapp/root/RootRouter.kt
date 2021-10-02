package com.example.samplecountriesapp.root

import android.util.Log
import com.example.samplecountriesapp.root.countries.CountriesBuilder
import com.example.samplecountriesapp.root.countries.CountriesRouter
import com.uber.rib.core.ViewRouter
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class RootRouter @Inject constructor(
    view: RootView,
    interactors: RootInteractors,
    component: RootBuilder.Component,
    val countriesBuilder: CountriesBuilder
) : ViewRouter<RootView, RootInteractors>(view, interactors, component) {
    private val compositeDisposable = CompositeDisposable()
    private var countriesRouter: CountriesRouter? = null
    fun attachCountriesList() {
        Log.d("TAG", "attachCountriesList: attachCountriesList")
        countriesRouter = countriesBuilder.build()
        attachChild(countriesRouter!!)
    }

    private fun detachCountriesList() {
        Log.d("TAG", "detachCountriesList: ")
        if (countriesRouter != null) {
            detachChild(countriesRouter!!)
            countriesRouter = null
        }
    }

    override fun willDetach() {
        super.willDetach()
        compositeDisposable.clear()
        detachCountriesList()
    }

}
package com.example.samplecountriesapp.root.countries

import android.util.Log
import com.uber.rib.core.Bundle
import com.uber.rib.core.EmptyPresenter
import com.uber.rib.core.Interactor
import com.uber.rib.core.RibInteractor

@RibInteractor
class CountriesInteractor : Interactor<EmptyPresenter, CountriesRouter>() {

    override fun didBecomeActive(savedInstanceState: Bundle?) {
        super.didBecomeActive(savedInstanceState)
        Log.d("TAG", "didBecomeActive: coun")
        router.routeToCountriesList()
    }

    override fun willResignActive() {
        super.willResignActive()

        router.detachCountriesList()
    }
}
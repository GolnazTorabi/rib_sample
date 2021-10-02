package com.example.samplecountriesapp.root

import android.util.Log
import com.uber.rib.core.Bundle
import com.uber.rib.core.Interactor
import com.uber.rib.core.RibInteractor
import io.objectbox.BoxStore
import javax.inject.Inject

@RibInteractor
class RootInteractors @Inject constructor(): Interactor<RootInteractors.RootPresenter,RootRouter>() {

    @Inject
    lateinit var rootPresenter: RootPresenter

    override fun didBecomeActive(savedInstanceState: Bundle?) {
        super.didBecomeActive(savedInstanceState)
        attachCountriesList()
    }

    private fun attachCountriesList(){
        router.attachCountriesList()
        Log.d("TAG", "attachCountriesList: ")
    }


    interface RootPresenter
}
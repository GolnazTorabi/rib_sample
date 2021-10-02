package com.example.samplecountriesapp.root.countries.list

import com.example.samplecountriesapp.root.countries.list.data.repository.Repository
import com.example.samplecountriesapp.root.countries.list.data.response.ResultsItem
import com.uber.rib.core.Bundle
import com.uber.rib.core.Interactor
import com.uber.rib.core.RibInteractor
import javax.inject.Inject


@RibInteractor
class CountriesListInteractors :
    Interactor<CountriesListInteractors.CountriesListPresenter, CountriesListRouter>() {
    @Inject
    lateinit var presenter: CountriesListPresenter
/*
    @Inject
    lateinit var repository: Repository*/

    override fun didBecomeActive(savedInstanceState: Bundle?) {
        super.didBecomeActive(savedInstanceState)

        getList()
    }

    private fun getList() {
        /* val data = repository.getCharacters()
         data.results?.let { presenter.showList(it) }*/
    }


    /**
     * Presenter interface implemented by this RIB's view.
     */
    interface CountriesListPresenter {
        fun showError(error: String)
        fun showList(list: List<ResultsItem>)
    }

    /*private fun launchAsync(block: suspend CoroutineScope.() -> Unit): Job {
        return launch(Contacts.Intents.UI) { block() }
    }*/
}
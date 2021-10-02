package com.example.samplecountriesapp.root.countries.list

import com.uber.rib.core.ViewRouter

class CountriesListRouter (
    view: CountriesListView,
    interactor: CountriesListInteractors,
    component: CountriesListBuilder.Component) : ViewRouter<CountriesListView, CountriesListInteractors>(view, interactor, component) {

/*    fun routeToCoinDetails(coinListModel: CoinListModel) {

        val intent = Intent(view.context, CoinDetailsActivity::class.java)
        intent.putExtra("coinId", coinListModel.id)
        view.context.startActivity(intent)

    }*/
}
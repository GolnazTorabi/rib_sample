package com.example.samplecountriesapp.root.countries.list

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import com.example.samplecountriesapp.root.countries.list.data.response.ResultsItem

class CountriesListView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) :
    LinearLayout(context, attrs, defStyle),
    CountriesListInteractors.CountriesListPresenter {

    /*private lateinit var mCoinListAdapter: CoinListAdapter
    private lateinit var mLayoutManager: RecyclerView.LayoutManager*/
    private lateinit var countryModel: List<ResultsItem>


    override fun onFinishInflate() {
        super.onFinishInflate()
        countryModel = mutableListOf()
    }

    override fun showError(error: String) {
        Toast.makeText(context, error, Toast.LENGTH_LONG).show()
    }

    override fun showList(list: List<ResultsItem>) {
        Log.d("TAG", "showList: ${list.size}")
    }
    /*override fun onSelectCoin(): Observable<CoinListModel> {
        return mCoinListAdapter.getItemClickSignal()
    }

    override fun showCoinList(coinList: List<CoinListModel>) {
        mCoinListAdapter.updateList(coinList)
    }


    override fun showLoadingProgress() {
        loadingView.visibility = View.VISIBLE
        loadingView.playAnimation()
    }

    override fun hideLoadingProgress() {
        loadingView.visibility = View.GONE
        loadingView.cancelAnimation()
        swipeRefreshLayout.isRefreshing = false
    }

    override fun onRefresh(): Observable<Any> {
        return RxSwipeRefreshLayout.refreshes(swipeRefreshLayout)
    }*/


}
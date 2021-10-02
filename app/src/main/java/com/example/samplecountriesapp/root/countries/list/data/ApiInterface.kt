package com.example.samplecountriesapp.root.countries.list.data

import com.example.samplecountriesapp.root.countries.list.data.response.ResponseCharacters
import io.reactivex.Single
import retrofit2.http.GET

interface ApiInterface {

    @GET("/character")
    fun getCharacters():Single<ResponseCharacters>
}
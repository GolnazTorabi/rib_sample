package com.example.samplecountriesapp.root.countries.list.data.repository

import com.example.samplecountriesapp.root.countries.list.data.response.ResponseCharacters
import io.reactivex.Single

interface Repository {
    fun getCharacters(): Single<ResponseCharacters>
}
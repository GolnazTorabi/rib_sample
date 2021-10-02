package com.example.samplecountriesapp.root.countries.list.data.repository

import com.example.samplecountriesapp.root.countries.list.data.ApiInterface
import com.example.samplecountriesapp.root.countries.list.data.response.ResponseCharacters
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

class CharactersRepository @Inject constructor(private val apiService: ApiInterface):Repository{
     override fun getCharacters(): Single<ResponseCharacters> {
        return apiService.getCharacters()
    }
    /*fun getCharacters(): ResponseCharacters {
        var data: ResponseCharacters? = null
        apiService.getCharacters().enqueue(object : Callback<ResponseCharacters> {
            override fun onResponse(
                call: Call<ResponseCharacters>,
                response: Response<ResponseCharacters>
            ) {
                data = response.body()
            }

            override fun onFailure(call: Call<ResponseCharacters>, t: Throwable) {
                Log.d("TAG", "onFailure: ${t.message}")
                Log.d("TAG", "onFailure: ${t.localizedMessage}")
                Log.d("TAG", "onFailure: ${t.cause}")
                Log.d("TAG", "onFailure: ${t.stackTrace[0].fileName}")
            }

        })
        return data ?: ResponseCharacters()
    }*/
}
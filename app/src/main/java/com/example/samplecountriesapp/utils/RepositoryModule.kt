package com.example.samplecountriesapp.utils

import com.example.samplecountriesapp.root.countries.list.data.repository.CharactersRepository
import com.example.samplecountriesapp.root.countries.list.data.repository.Repository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideRepository(impl: CharactersRepository): Repository = impl
}

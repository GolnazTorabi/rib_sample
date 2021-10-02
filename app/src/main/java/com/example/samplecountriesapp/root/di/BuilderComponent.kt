package com.example.samplecountriesapp.root.di

import com.example.samplecountriesapp.root.RootRouter

interface BuilderComponent {
    fun rootRouter(): RootRouter
}

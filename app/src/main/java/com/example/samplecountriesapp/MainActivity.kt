package com.example.samplecountriesapp

import android.util.Log
import android.view.ViewGroup
import com.example.samplecountriesapp.root.RootBuilder
import com.uber.rib.core.RibActivity
import com.uber.rib.core.ViewRouter
import dagger.android.AndroidInjection

class MainActivity : RibActivity() {

    override fun createRouter(parentViewGroup: ViewGroup): ViewRouter<*, *> {
        //AndroidInjection.inject(this);
        val rootBuilder = RootBuilder(object : RootBuilder.ParentComponent {})
        return rootBuilder.build(this, parentViewGroup)

    }
}
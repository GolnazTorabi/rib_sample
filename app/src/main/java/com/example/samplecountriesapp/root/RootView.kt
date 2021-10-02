package com.example.samplecountriesapp.root

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout


class RootView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) :
    LinearLayout(context, attrs, defStyle),
    RootInteractors.RootPresenter {
}
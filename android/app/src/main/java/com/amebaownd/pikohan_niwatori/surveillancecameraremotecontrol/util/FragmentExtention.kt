package com.amebaownd.pikohan_niwatori.surveillancecameraremotecontrol.util

import android.app.Activity
import android.app.Application
import androidx.fragment.app.Fragment

fun Fragment.getViewModelFactory(application: Application): ViewModelFactory {
    val repository = ServiceLoader.provideRepository()
    return ViewModelFactory(application,repository)
}

fun Activity.getViewModelFactory(application: Application): ViewModelFactory {
    val repository = ServiceLoader.provideRepository()
    return ViewModelFactory(application,repository)
}
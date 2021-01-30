package com.amebaownd.pikohan_niwatori.surveillancecameraremotecontrol.util

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.amebaownd.pikohan_niwatori.surveillancecameraremotecontrol.MainViewModel
import com.amebaownd.pikohan_niwatori.surveillancecameraremotecontrol.repository.Repository
import com.amebaownd.pikohan_niwatori.surveillancecameraremotecontrol.ui.connect.ConnectFragment
import com.amebaownd.pikohan_niwatori.surveillancecameraremotecontrol.ui.connect.ConnectViewModel
import com.amebaownd.pikohan_niwatori.surveillancecameraremotecontrol.ui.control.RemoteControlViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val application: Application, private val repository: Repository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val t = with(modelClass) {
            when {
                isAssignableFrom(ConnectViewModel::class.java) ->
                    ConnectViewModel(repository!!)
                isAssignableFrom(RemoteControlViewModel::class.java) ->
                    RemoteControlViewModel(application)
                isAssignableFrom(MainViewModel::class.java) ->
                    MainViewModel()
                else ->
                    throw IllegalArgumentException("Unknown ViewModelClass $modelClass")
            }
        } as T
        return t
    }
}
package com.amebaownd.pikohan_niwatori.surveillancecameraremotecontrol.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.amebaownd.pikohan_niwatori.surveillancecameraremotecontrol.MainViewModel
import com.amebaownd.pikohan_niwatori.surveillancecameraremotecontrol.repository.Repository
import com.amebaownd.pikohan_niwatori.surveillancecameraremotecontrol.ui.connect.ConnectFragment
import com.amebaownd.pikohan_niwatori.surveillancecameraremotecontrol.ui.connect.ConnectViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val repository: Repository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val t = with(modelClass) {
            when {
                isAssignableFrom(ConnectViewModel::class.java) ->
                    ConnectViewModel(repository!!)
                isAssignableFrom(MainViewModel::class.java) ->
                    MainViewModel()
                else ->
                    throw IllegalArgumentException("Unknown ViewModelClass $modelClass")
            }
        } as T
        return t
    }
}
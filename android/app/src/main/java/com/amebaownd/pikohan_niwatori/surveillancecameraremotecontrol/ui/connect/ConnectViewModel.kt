package com.amebaownd.pikohan_niwatori.surveillancecameraremotecontrol.ui.connect

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.amebaownd.pikohan_niwatori.surveillancecameraremotecontrol.data.Address
import com.amebaownd.pikohan_niwatori.surveillancecameraremotecontrol.repository.Repository
import com.amebaownd.pikohan_niwatori.surveillancecameraremotecontrol.util.Event
import com.amebaownd.pikohan_niwatori.surveillancecameraremotecontrol.util.isNotNullOrBlankOrEmpty

class ConnectViewModel(private val repository: Repository) : ViewModel() {


    var ipAddress = MutableLiveData<String>("192.168.10.10")
    var port = MutableLiveData<String>("60010")
    private var _connectEvent = MutableLiveData<Event<Address>>()
    val connectEvent:LiveData<Event<Address>> = _connectEvent

    fun onConnectButtonClicked(){
        if(ipAddress.value.isNotNullOrBlankOrEmpty()){
            if(ipAddress.value!!.split(".").size == 4){
                val address = Address(ipAddress = ipAddress.value!!,port=port.value!!.toInt())
                _connectEvent.value = Event(address)
            }
        }
    }
}
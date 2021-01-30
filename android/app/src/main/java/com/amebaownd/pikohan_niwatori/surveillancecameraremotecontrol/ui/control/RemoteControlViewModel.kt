package com.amebaownd.pikohan_niwatori.surveillancecameraremotecontrol.ui.control

import android.annotation.SuppressLint
import android.app.Application
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintSet
import androidx.databinding.BindingAdapter
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.amebaownd.pikohan_niwatori.surveillancecameraremotecontrol.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress
import java.net.SocketException

class RemoteControlViewModel(application: Application) : AndroidViewModel(application) {
    private lateinit var socket: DatagramSocket
    private lateinit var inetAddress: InetAddress

    private var buttonFlg = 0

    var sendFlg = true
    var port = -1
    fun start(ipAddress: String, port: Int) {
        this.port = port
        socket = DatagramSocket(port)
        inetAddress = InetAddress.getByName(ipAddress)
        sendMessage()
    }

    private fun sendMessage() {
        viewModelScope.launch(Dispatchers.IO) {
            while(sendFlg) {
                delay(100)
                if(buttonFlg == 0 || buttonFlg == 3) continue
                try {
                    val buffer = buttonFlg.toString().toByteArray()
                    val packet = DatagramPacket(buffer, buffer.size, inetAddress, port)
                    socket.send(packet)
                    Log.d("send message", buttonFlg.toString())
                } catch (e: SocketException) {
                    e.printStackTrace()
                }
            }
        }
    }

    fun onTouch(view:View,event: MotionEvent): Boolean {
        when(event.action){
            MotionEvent.ACTION_DOWN->{
                buttonFlg = when(view.id){
                    R.id.control_left -> (buttonFlg or 1)
                    R.id.control_right-> (buttonFlg or 2)
                    else -> return false
                }
                return false
            }
            MotionEvent.ACTION_UP -> {
                buttonFlg = when (view.id) {
                    R.id.control_left -> (buttonFlg xor 1)
                    R.id.control_right -> (buttonFlg xor 2)
                    else -> return false
                }
                return false
            }
        }
        return false
    }


    fun onDestroy() {
        sendFlg = false
        socket.close()
    }
}

@BindingAdapter("onTouch")
fun test(view: View, listener: View.OnTouchListener) {
    view.setOnTouchListener(listener)
}
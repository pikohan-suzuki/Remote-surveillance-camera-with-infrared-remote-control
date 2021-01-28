package com.amebaownd.pikohan_niwatori.surveillancecameraremotecontrol

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import androidx.activity.viewModels


import com.amebaownd.pikohan_niwatori.surveillancecameraremotecontrol.util.getViewModelFactory

class MainActivity :AppCompatActivity(){

        val viewModel:MainViewModel by viewModels{getViewModelFactory()}

        override fun onCreate(savedInstanceState:Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        }
}

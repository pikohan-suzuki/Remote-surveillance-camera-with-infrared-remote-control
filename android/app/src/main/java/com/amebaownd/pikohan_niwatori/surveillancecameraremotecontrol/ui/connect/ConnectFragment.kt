package com.amebaownd.pikohan_niwatori.surveillancecameraremotecontrol.ui.connect

import androidx.lifecycle.ViewModelProviders

import android.os.Bundle

import androidx.fragment.app.Fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.viewModels

import com.amebaownd.pikohan_niwatori.surveillancecameraremotecontrol.databinding.ConnectFragmentBinding
import com.amebaownd.pikohan_niwatori.surveillancecameraremotecontrol.util.getViewModelFactory

class ConnectFragment :Fragment(){

private val viewModel:ConnectViewModel by viewModels{getViewModelFactory()}
private lateinit var mainFragmentBinding:ConnectFragmentBinding

        override fun onCreateView(
        inflater:LayoutInflater,
        container:ViewGroup?,
        savedInstanceState:Bundle?
        ):View{
        mainFragmentBinding=ConnectFragmentBinding.inflate(inflater,container,false).apply{
        viewModel=this@ConnectFragment.viewModel
            lifecycleOwner=viewLifecycleOwner
                    }
                    return mainFragmentBinding.root
                    }

                    override fun onViewCreated(view:View,savedInstanceState:Bundle?){
                    super.onViewCreated(view,savedInstanceState)

                    }

//    private fun navigateToAaaa(){
//        val action = MainFragmentDirections
//            .actionMainFragmentToRecordFragment()
//        findNavController().navigate(action)
//    }

                    }
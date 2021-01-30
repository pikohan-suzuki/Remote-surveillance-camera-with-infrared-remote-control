package com.amebaownd.pikohan_niwatori.surveillancecameraremotecontrol.ui.control

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.viewModels
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.amebaownd.pikohan_niwatori.surveillancecameraremotecontrol.MainActivity
import com.amebaownd.pikohan_niwatori.surveillancecameraremotecontrol.data.Address

import com.amebaownd.pikohan_niwatori.surveillancecameraremotecontrol.databinding.RemoteControlFragmentBinding
import com.amebaownd.pikohan_niwatori.surveillancecameraremotecontrol.util.getViewModelFactory

class RemoteControlFragment : Fragment() {

    private val viewModel: RemoteControlViewModel by viewModels { getViewModelFactory((this.activity as MainActivity).application) }
    private lateinit var mainFragmentBinding: RemoteControlFragmentBinding
    private val args = navArgs<RemoteControlFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mainFragmentBinding = RemoteControlFragmentBinding.inflate(inflater, container, false).apply {
            viewModel = this@RemoteControlFragment.viewModel
            lifecycleOwner = viewLifecycleOwner
        }
        return mainFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.start(args.value.ipAddress,args.value.port)
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.onDestroy()
    }
}
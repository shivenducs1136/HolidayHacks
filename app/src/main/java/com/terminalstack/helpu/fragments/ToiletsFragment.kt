package com.terminalstack.helpu.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.terminalstack.helpu.Adapter.MallsAdapter
import com.terminalstack.helpu.Adapter.ToiletsAdapter
import com.terminalstack.helpu.R
import com.terminalstack.helpu.databinding.FragmentToiletsBinding
import com.terminalstack.helpu.network.MainRepository
import com.terminalstack.helpu.viewmodel.MallsVIewModel
import com.terminalstack.helpu.viewmodel.RestrauntsViewModelFactory
import com.terminalstack.helpu.viewmodel.ToiletsViewModel
import com.terminalstack.helpu.viewmodel.ToiletsViewModelFactory

class ToiletsFragment : Fragment() {

    lateinit var binding: FragmentToiletsBinding
    lateinit var viewModel:ToiletsViewModel
    private val restroAdapter: ToiletsAdapter by lazy{ ToiletsAdapter() }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentToiletsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val repository = MainRepository()
        val viewModelFactory = ToiletsViewModelFactory(repository)
        viewModel = ViewModelProvider(this,viewModelFactory).get(ToiletsViewModel::class.java)
        viewModel.getToilets()
        viewModel.myResponse.observe(viewLifecycleOwner, Observer {
            restroAdapter.setRestro(it)
        })
        binding.toiletsRecyclerView.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        binding.toiletsRecyclerView.adapter = restroAdapter


    }

}
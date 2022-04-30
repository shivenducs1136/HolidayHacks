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
import com.terminalstack.helpu.Adapter.HospitalsAdapter
import com.terminalstack.helpu.Adapter.ToiletsAdapter
import com.terminalstack.helpu.R
import com.terminalstack.helpu.databinding.FragmentHospitalsBinding
import com.terminalstack.helpu.network.MainRepository
import com.terminalstack.helpu.viewmodel.HospitalViewModel
import com.terminalstack.helpu.viewmodel.HospitalViewModelFactory
import com.terminalstack.helpu.viewmodel.RestrauntsViewModelFactory
import com.terminalstack.helpu.viewmodel.ToiletsViewModel

class HospitalsFragment : Fragment() {

    lateinit var binding: FragmentHospitalsBinding
    lateinit var viewModel: HospitalViewModel
    private val restroAdapter: HospitalsAdapter by lazy{ HospitalsAdapter() }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHospitalsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val repository = MainRepository()
        val viewModelFactory = HospitalViewModelFactory(repository)
        viewModel = ViewModelProvider(this,viewModelFactory).get(HospitalViewModel::class.java)
        viewModel.getHospital()
        viewModel.myResponse.observe(viewLifecycleOwner, Observer {
            restroAdapter.setRestro(it)
        })
        binding.hospitalsRecyclerView.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        binding.hospitalsRecyclerView.adapter = restroAdapter

    }

}
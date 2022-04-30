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
import com.terminalstack.helpu.Adapter.BanksAdapter
import com.terminalstack.helpu.Adapter.ToiletsAdapter
import com.terminalstack.helpu.R
import com.terminalstack.helpu.databinding.FragmentBanksBinding
import com.terminalstack.helpu.network.MainRepository
import com.terminalstack.helpu.viewmodel.BanksViewModel
import com.terminalstack.helpu.viewmodel.BanksViewModelFactory
import com.terminalstack.helpu.viewmodel.RestrauntsViewModelFactory
import com.terminalstack.helpu.viewmodel.ToiletsViewModel

class BanksFragment : Fragment() {

    lateinit var binding: FragmentBanksBinding
    lateinit var viewModel: BanksViewModel
    private val restroAdapter: BanksAdapter by lazy{ BanksAdapter() }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentBanksBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val repository = MainRepository()
        val viewModelFactory = BanksViewModelFactory(repository)
        viewModel = ViewModelProvider(this,viewModelFactory).get(BanksViewModel::class.java)
        viewModel.getBank()
        viewModel.myResponse.observe(viewLifecycleOwner, Observer {
            restroAdapter.setRestro(it)
        })
        binding.banksRecyclerview.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        binding.banksRecyclerview.adapter = restroAdapter


    }

}
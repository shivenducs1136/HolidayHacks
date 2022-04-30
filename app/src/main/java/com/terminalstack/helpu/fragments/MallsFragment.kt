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
import com.terminalstack.helpu.Adapter.RestroAdapter
import com.terminalstack.helpu.R
import com.terminalstack.helpu.databinding.FragmentMallsBinding
import com.terminalstack.helpu.network.MainRepository
import com.terminalstack.helpu.viewmodel.MallsVIewModel
import com.terminalstack.helpu.viewmodel.MallsViewModelFactory
import com.terminalstack.helpu.viewmodel.RestrauntsViewModel
import com.terminalstack.helpu.viewmodel.RestrauntsViewModelFactory


class MallsFragment : Fragment() {

    lateinit var binding:FragmentMallsBinding
    lateinit var viewModel:MallsVIewModel
    private val restroAdapter: MallsAdapter by lazy{ MallsAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMallsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val repository = MainRepository()
        val viewModelFactory = MallsViewModelFactory(repository)
        viewModel = ViewModelProvider(this,viewModelFactory).get(MallsVIewModel::class.java)
        viewModel.getMalls()
        viewModel.myResponse.observe(viewLifecycleOwner, Observer {
            restroAdapter.setRestro(it)
//            binding.progressBar.visibility = View.GONE
        })
        binding.mallsRecyclerView.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        binding.mallsRecyclerView.adapter = restroAdapter



    }
}
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
import com.terminalstack.helpu.Adapter.LibraryAdapter
import com.terminalstack.helpu.R
import com.terminalstack.helpu.databinding.FragmentLibraryBinding
import com.terminalstack.helpu.network.MainRepository
import com.terminalstack.helpu.viewmodel.BanksViewModel
import com.terminalstack.helpu.viewmodel.LibraryViewModel
import com.terminalstack.helpu.viewmodel.RestrauntsViewModel
import com.terminalstack.helpu.viewmodel.RestrauntsViewModelFactory


class LibraryFragment : Fragment() {

    lateinit var binding: FragmentLibraryBinding
    lateinit var viewModel: LibraryViewModel
    private val restroAdapter: LibraryAdapter by lazy{ LibraryAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLibraryBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val repository = MainRepository()
        val viewModelFactory = RestrauntsViewModelFactory(repository)
        viewModel = ViewModelProvider(this,viewModelFactory).get(LibraryViewModel::class.java)
        viewModel.getLibrary()
        viewModel.myResponse.observe(viewLifecycleOwner, Observer {
            restroAdapter.setRestro(it)
//            binding.progressBar.visibility = View.GONE
        })
        binding.libraryRecyclerView.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        binding.libraryRecyclerView.adapter = restroAdapter


    }


}
package com.terminalstack.helpu.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.terminalstack.helpu.network.MainRepository

class HospitalViewModelFactory(private val repository: MainRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HospitalViewModel(repository) as T

    }

}
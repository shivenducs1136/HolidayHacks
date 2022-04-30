package com.terminalstack.helpu.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.terminalstack.helpu.dataClass.Libraries
import com.terminalstack.helpu.dataClass.Malls
import com.terminalstack.helpu.network.MainRepository
import kotlinx.coroutines.launch

class MallsVIewModel (private val repository: MainRepository): ViewModel() {

    val myResponse: MutableLiveData<Malls> = MutableLiveData()
    fun getMalls(){
        viewModelScope.launch {
            val response: Malls = repository.getMalls()
            myResponse.value = response
        }
    }

}
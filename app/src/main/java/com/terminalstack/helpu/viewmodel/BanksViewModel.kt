package com.terminalstack.helpu.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.terminalstack.helpu.dataClass.Banks
import com.terminalstack.helpu.dataClass.Restraunts
import com.terminalstack.helpu.network.MainRepository
import kotlinx.coroutines.launch

class BanksViewModel (private val repository: MainRepository): ViewModel() {

    val myResponse: MutableLiveData<Banks> = MutableLiveData()
    fun getBank(){
        viewModelScope.launch {
            val response: Banks = repository.getBanks()
            myResponse.value = response
        }
    }

}
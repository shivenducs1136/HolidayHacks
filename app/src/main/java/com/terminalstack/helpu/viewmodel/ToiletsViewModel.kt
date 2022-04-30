package com.terminalstack.helpu.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.terminalstack.helpu.dataClass.Malls
import com.terminalstack.helpu.dataClass.Toilets
import com.terminalstack.helpu.network.MainRepository
import kotlinx.coroutines.launch

class ToiletsViewModel  (private val repository: MainRepository): ViewModel() {

    val myResponse: MutableLiveData<Toilets> = MutableLiveData()
    fun getToilets(){
        viewModelScope.launch {
            val response: Toilets = repository.getToilets()
            myResponse.value = response
        }
    }

}
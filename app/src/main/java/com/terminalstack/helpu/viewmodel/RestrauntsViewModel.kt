package com.terminalstack.helpu.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.terminalstack.helpu.dataClass.Restraunts
import com.terminalstack.helpu.network.MainRepository
import kotlinx.coroutines.launch

class RestrauntsViewModel (private val repository: MainRepository): ViewModel() {

    val myResponse: MutableLiveData<Restraunts> = MutableLiveData()
    fun getRestraunts(){
        viewModelScope.launch {
            val response: Restraunts = repository.getRestraunts()
            myResponse.value = response
        }
    }

}
package com.terminalstack.helpu.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.terminalstack.helpu.dataClass.Banks
import com.terminalstack.helpu.dataClass.Libraries
import com.terminalstack.helpu.network.MainRepository
import kotlinx.coroutines.launch

class LibraryViewModel (private val repository: MainRepository): ViewModel() {

    val myResponse: MutableLiveData<Libraries> = MutableLiveData()
    fun getLibrary(){
        viewModelScope.launch {
            val response: Libraries = repository.getLibraries()
            myResponse.value = response
        }
    }

}
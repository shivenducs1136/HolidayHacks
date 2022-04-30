package com.terminalstack.helpu.network

import com.terminalstack.helpu.api.RetrofitInstance
import com.terminalstack.helpu.dataClass.*
import retrofit2.http.GET

class MainRepository () {

    suspend fun getMalls(
    ): Malls{
        return RetrofitInstance.api.getMalls()
    }

    suspend fun getLibraries (
    ): Libraries{
        return RetrofitInstance.api.getLibraries()
    }

    suspend fun getToilets (
    ): Toilets{
        return RetrofitInstance.api.getToilets()
    }

    suspend fun getRestraunts (
    ): Restraunts{
        return RetrofitInstance.api.getRestraunts()
    }

    suspend fun getHospitals (
    ): Hospitals{
        return RetrofitInstance.api.getHospitals()
    }

    suspend fun getBanks (
    ): Banks{
        return RetrofitInstance.api.getBanks()
    }


}
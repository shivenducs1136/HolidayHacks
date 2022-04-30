package com.terminalstack.helpu.network

import com.terminalstack.dataClass.RestroItem
import com.terminalstack.helpu.dataClass.*
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    @GET("malls")
    suspend fun getMalls (
    ): Malls

    @GET("libraries")
    suspend fun getLibraries (
    ): Libraries

    @GET("toilets")
    suspend fun getToilets (
    ):Toilets

    @GET("restraunts")
    suspend fun getRestraunts (
    ):Restraunts

    @GET("hospitals")
    suspend fun getHospitals (
    ):Hospitals

    @GET("banks")
    suspend fun getBanks (
    ):Banks

}


package com.example.brewery.Network

import com.example.brewery.Model.Brewery
import com.skydoves.sandwich.ApiResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface BreweryService {
    @GET("breweries")
    fun getBreweryList(): Call<List<Brewery>>

    @GET("breweries/{id}")
    fun getBrewery(@Path("id") id : String?): ApiResponse<ResponseBody>

    @PUT("breweries/{id}")
    fun updateBrewery(@Path("id") id: String?, @Body brewery: Brewery): ApiResponse<ResponseBody>

    @POST("breweries")
    fun createBrewery(@Body brewery: Brewery): ApiResponse<ResponseBody>

    @DELETE("breweries/{id}")
    fun deleteBrewery(@Path("id") id: String?): ApiResponse<ResponseBody>
}
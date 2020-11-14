package com.example.assignment2.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface AnimalImageService {
    @GET("breed/{breed}/images")
    fun getRandomImageByBreed(@Path("breed") breed:String):Call<Animal>
}
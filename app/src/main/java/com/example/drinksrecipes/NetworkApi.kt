package com.example.drinksrecipes

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkApi {

    @GET("search.php")
    fun getAllPosts(@Query("s") name: String): Call<Recipes>

}
package com.example.drinksrecipes

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkApi2 {

    @GET("search.php")
    fun getAllPosts(@Query("f") name: String): Call<Recipes>
}
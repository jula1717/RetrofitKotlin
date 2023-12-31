package com.example.retrofitkotlin

import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface PhotoApi {
    companion object {
        const val BASE_URL = "https://api.unsplash.com/"
        const val CLIENT_ID = ApiKey.myKey
    }

    @Headers("Accept-Version: v1", "Authorization: Client-ID $CLIENT_ID")
    @GET("search/photos")
    suspend fun uploadPhotos(@Query("query") query:String, @Query("page") page:Int,@Query("per_page") perPage:Int) : PhotoResponse
}
package com.example.mvvmapicall.network

import com.example.mvvmapicall.network.models.NewsModel
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {

    @GET("top-headlines")
    suspend fun fetchNews(
        @Query("country") country: String?,
        @Query("pageSize") pagesize: Int,
        @Query("apiKey") apikey: String?
    ): NewsModel.Article?


    @GET("top-headlines")
    fun fetchNewsWithCat(
        @Query("country") country: String?,
        @Query("category") category: String?,
        @Query("pageSize") pagesize: Int,
        @Query("apiKey") apikey: String?
    ): NewsModel.Article?


}
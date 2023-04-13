package com.example.mygitrepos.network

import com.example.mygitrepos.model.Repository
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @GET("users/{username}/repos")
    fun getUserRepositories(
        @Path("username") username: String
    ): Observable<Response<ResponseBody>>

    @POST("/user/repos")
    fun createRepository(
        @Header("Authorization") token: String,
        @Body repo: Repository,
        @Query("owner") owner: String
    ): Observable<Response<ResponseBody>>
}
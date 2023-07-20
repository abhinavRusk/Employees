package com.example.employees
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("users?page=2")
   fun GetData(): Call<Contacts>
}
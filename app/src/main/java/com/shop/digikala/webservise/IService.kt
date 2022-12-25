package com.shop.digikala.webservise

import com.shop.digikala.model.BaseModel
import retrofit2.Call
import retrofit2.http.GET

interface IService {

    @GET("getCategories.php")
    fun getCategory(): Call<BaseModel?>?

}
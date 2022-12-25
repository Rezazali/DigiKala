package com.shop.digikala.webservise

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AppConfig {


    private fun ApiUtils() {}

    companion object{
        @Volatile
        var retrofit: Retrofit? = null


        @JvmName("getRetrofit1")

        fun  getRetrofit(): Retrofit? {
            if (retrofit == null) {
                synchronized(AppConfig::class.java) {

                    if (retrofit == null) {
                        retrofit = Retrofit.Builder()
                            .baseUrl("https://androidsupport.ir/pack/digiAndroid/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build()
                    }
                }
            }
            return retrofit
        }
    }

}
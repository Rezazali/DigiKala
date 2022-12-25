package com.shop.digikala

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.shop.digikala.model.BaseModel
import com.shop.digikala.webservise.AppConfig
import com.shop.digikala.webservise.IService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(application: Application) : AndroidViewModel(application) {


    lateinit var baseModel :MutableLiveData<BaseModel>


    fun getCategories():MutableLiveData<BaseModel>{

            baseModel = MutableLiveData()

             getCategory()

            //bro webservice ro erakon

        return baseModel
    }


    private fun getCategory(){

        val iService: IService? = AppConfig.getRetrofit()?.create(IService::class.java)

        iService?.getCategory()?.enqueue(object :Callback<BaseModel?> {
            override fun onResponse(call: Call<BaseModel?>, response: Response<BaseModel?>) {

                baseModel.value = response.body()
            }

            override fun onFailure(call: Call<BaseModel?>, t: Throwable) {

                baseModel.value = null
            }


        }  )
    }



}



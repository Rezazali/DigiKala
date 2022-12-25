package com.shop.digikala

import androidx.lifecycle.ViewModelProvider
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.shop.digikala.databinding.ActivityMainBinding
import com.shop.digikala.model.BaseModel


class MainActivity() : AppCompatActivity() {


    lateinit var binding: ActivityMainBinding

    lateinit var baseModel :MainViewModel

    lateinit var owner :LifecycleOwner




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        owner = this


        baseModel = ViewModelProvider(this)[MainViewModel::class.java]

        baseModel.getCategories().observe(owner,object :Observer<BaseModel?>{
            override fun onChanged(t: BaseModel?) {

                Log.d("","")
            }

        })


    }
}
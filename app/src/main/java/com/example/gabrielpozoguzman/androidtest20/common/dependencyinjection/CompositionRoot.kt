package com.example.gabrielpozoguzman.androidtest20.common.dependencyinjection

import com.example.gabrielpozoguzman.androidtest20.common.Constants
import com.example.gabrielpozoguzman.androidtest20.networking.MobgenApi
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CompositionRoot {
    companion object {
        fun getRetrofit(): Retrofit {
            return Retrofit.Builder().baseUrl(Constants.baseUrl)
                    .addCallAdapterFactory(CoroutineCallAdapterFactory())
                    .addConverterFactory(GsonConverterFactory.create()).build()

        }
    }

    fun getMobgenApi(): MobgenApi {
        return getRetrofit().create(MobgenApi::class.java)
    }
}
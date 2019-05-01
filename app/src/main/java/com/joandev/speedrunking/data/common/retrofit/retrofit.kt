package com.joandev.speedrunking.data.common.retrofit

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val retrofit: Retrofit = Retrofit.Builder()
  .baseUrl("https://www.speedrun.com/api/v1/")
  .addConverterFactory(GsonConverterFactory.create())
  .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
  .build()
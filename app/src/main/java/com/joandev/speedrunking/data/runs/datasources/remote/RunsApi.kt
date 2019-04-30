package com.joandev.speedrunking.data.runs.datasources.remote

import com.joandev.speedrunking.data.runs.datasources.model.RunData
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface RunsApi {

  @GET("runs")
  fun getRunById(@Query("game") runId: String): Single<RunData>
}
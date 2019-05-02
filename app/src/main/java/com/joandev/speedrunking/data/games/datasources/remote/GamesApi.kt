package com.joandev.speedrunking.data.games.datasources.remote

import com.joandev.speedrunking.data.games.model.GamesData
import io.reactivex.Single
import retrofit2.http.GET

interface GamesApi {

  @GET("games")
  fun getGames(): Single<GamesData>
}
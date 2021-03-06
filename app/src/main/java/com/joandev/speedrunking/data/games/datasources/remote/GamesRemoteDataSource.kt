package com.joandev.speedrunking.data.games.datasources.remote

import com.joandev.speedrunking.data.games.datasources.GamesDataSource
import com.joandev.speedrunking.data.games.model.mapToDomain
import com.joandev.speedrunking.domain.games.model.Game
import io.reactivex.Single
import retrofit2.Retrofit

class GamesRemoteDataSource(private val retrofit: Retrofit) :
  GamesDataSource {

  override fun getGames(): Single<List<Game>> =
    retrofit.create(GamesApi::class.java).getGames().map { it.mapToDomain() }
}
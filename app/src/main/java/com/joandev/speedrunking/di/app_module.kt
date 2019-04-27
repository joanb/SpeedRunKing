package com.joandev.speedrunking.di

import com.joandev.speedrunking.data.games.GamesDataRepository
import com.joandev.speedrunking.data.games.datasources.GamesRemoteDataSource
import com.joandev.speedrunking.data.games.datasources.RemoteDataSource
import com.joandev.speedrunking.data.retrofit.retrofit
import com.joandev.speedrunking.domain.games.GamesRepository
import com.joandev.speedrunking.domain.games.GetGames
import com.joandev.speedrunking.mobile.games.GamesPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.koin.dsl.module

val appModule = module {

  single<RemoteDataSource> { GamesRemoteDataSource(retrofit) }
  single<GamesRepository> { GamesDataRepository(get()) }

  factory { GetGames(get(), Schedulers.io(), AndroidSchedulers.mainThread()) }
  factory { GamesPresenter(get()) }
}
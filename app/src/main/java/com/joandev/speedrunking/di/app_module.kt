package com.joandev.speedrunking.di

import com.joandev.speedrunking.data.GamesDataRepository
import com.joandev.speedrunking.data.datasources.GamesRemoteDataSource
import com.joandev.speedrunking.domain.games.GamesRepository
import com.joandev.speedrunking.domain.games.GetGames
import com.joandev.speedrunking.mobile.games.GamesPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.koin.dsl.module

val appModule = module {

  single { GamesRemoteDataSource() }
  single<GamesRepository> { GamesDataRepository(get()) }

  factory { GetGames(get(), Schedulers.io(), AndroidSchedulers.mainThread()) }
  factory { GamesPresenter(get()) }
}
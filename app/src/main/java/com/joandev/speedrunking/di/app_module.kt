package com.joandev.speedrunking.di

import com.joandev.speedrunking.data.games.GamesDataRepository
import com.joandev.speedrunking.data.games.datasources.GamesDataSource
import com.joandev.speedrunking.data.games.datasources.remote.GamesRemoteDataSource
import com.joandev.speedrunking.data.common.retrofit.retrofit
import com.joandev.speedrunking.data.runs.RunsDataRepository
import com.joandev.speedrunking.data.runs.datasources.RunsDataSource
import com.joandev.speedrunking.data.runs.datasources.RunsRemoteDataSource
import com.joandev.speedrunking.domain.games.GamesRepository
import com.joandev.speedrunking.domain.games.GetGames
import com.joandev.speedrunking.domain.runs.GetGameRunById
import com.joandev.speedrunking.domain.runs.RunsRepository
import com.joandev.speedrunking.mobile.games.GamesPresenter
import com.joandev.speedrunking.mobile.runs.BestRunPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.koin.dsl.module

val appModule = module {

  single<GamesDataSource> { GamesRemoteDataSource(retrofit) }
  single<GamesRepository> { GamesDataRepository(get()) }

  single<RunsDataSource> { RunsRemoteDataSource(retrofit) }
  single<RunsRepository> { RunsDataRepository(get()) }

  factory { GetGameRunById(get(), Schedulers.io(), AndroidSchedulers.mainThread()) }
  factory { BestRunPresenter(get()) }

  factory { GetGames(get(), Schedulers.io(), AndroidSchedulers.mainThread()) }
  factory { GamesPresenter(get()) }
}
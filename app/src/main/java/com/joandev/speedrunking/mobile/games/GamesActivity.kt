package com.joandev.speedrunking.mobile.games

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.joandev.speedrunking.R
import com.joandev.speedrunking.domain.games.model.Game
import org.koin.android.ext.android.inject

class GamesActivity : AppCompatActivity(), GamesPresenter.GamesView {

  private val presenter: GamesPresenter by inject()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    presenter.attachView(this)
  }

  override fun showGames(games: List<Game>) {
    print("ALLGOOD")
  }

  override fun showLoading() {
  }

  override fun hideLoading() {
  }
}
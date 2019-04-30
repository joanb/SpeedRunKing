package com.joandev.speedrunking.mobile.games

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.joandev.speedrunking.R
import com.joandev.speedrunking.domain.games.model.Game
import com.joandev.speedrunking.mobile.games.adapter.GamesRecyclerViewAdapter
import com.joandev.speedrunking.mobile.runs.BestRunActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class GamesActivity : AppCompatActivity(), GamesPresenter.GamesView {

  private val presenter: GamesPresenter by inject()
  private val gamesRecyclerviewAdapter by lazy { GamesRecyclerViewAdapter(presenter::onGameSelected) }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    presenter.attachView(this)
  }

  override fun showGames(games: List<Game>) {
    gamesRecyclerviewAdapter.setItems(games)
  }

  override fun setupViews() = with(gamesRecyclerView) {
    layoutManager = LinearLayoutManager(context)
    setHasFixedSize(true)
    if (adapter == null) adapter = gamesRecyclerviewAdapter
  }

  override fun showGameRuns(game: Game) {
    startActivity(BestRunActivity.getIntent(this, game.runsUrl))
  }

  override fun showLoading() {}

  override fun hideLoading() {}
}
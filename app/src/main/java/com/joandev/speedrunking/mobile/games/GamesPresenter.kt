package com.joandev.speedrunking.mobile.games

import com.joandev.speedrunking.domain.games.GetGames
import com.joandev.speedrunking.domain.games.model.Game
import com.joandev.speedrunking.mobile.Presenter

class GamesPresenter(private val getGamesUseCase: GetGames) : Presenter<GamesPresenter.GamesView>() {

  override fun onViewAttached() {
    getView().setupViews()
    getView().showLoading()
    val disposable = getGamesUseCase.execute(null).subscribe(
      {
        getView().showGames(it)
        getView().hideLoading()
      },
      { getView().hideLoading() }
    )
    addDisposable(disposable)
  }

  fun onGameSelected(game: Game) {
    getView().showGameRuns(game)
  }

  interface GamesView : Presenter.View {
    fun showGames(games: List<Game>)
    fun setupViews()
    fun showGameRuns(game: Game)
  }
}
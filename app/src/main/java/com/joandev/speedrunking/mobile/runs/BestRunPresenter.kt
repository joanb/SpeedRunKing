package com.joandev.speedrunking.mobile.runs

import com.joandev.speedrunking.domain.runs.GetBestGameRunById
import com.joandev.speedrunking.domain.runs.model.GameRun
import com.joandev.speedrunking.mobile.Presenter

class BestRunPresenter(private val getBestGameRunById: GetBestGameRunById) : Presenter<BestRunPresenter.View>() {

  override fun onViewAttached() {
    getView().showGameData()
  }

  fun onGameIdGathered(gameId: String?) = with(getView()) {
    gameId?.let {
      showLoading()
      val disposable = getBestGameRunById.execute(gameId).subscribe(
        {
          showRunData(it)
          hideLoading()
        },
        { hideLoading() }
      )
      addDisposable(disposable)
    }
  }

  fun onVideoButtonClick(gameRun: GameRun) {
    getView().openUrl(gameRun.videoUrl)
  }

  interface View : Presenter.View {
    fun showGameData()
    fun showRunData(gameRun: GameRun)
    fun openUrl(videoUrl: String)
  }
}
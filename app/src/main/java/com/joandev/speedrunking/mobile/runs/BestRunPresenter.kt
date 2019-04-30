package com.joandev.speedrunking.mobile.runs

import com.joandev.speedrunking.domain.runs.GetGameRunById
import com.joandev.speedrunking.domain.runs.model.GameRun
import com.joandev.speedrunking.mobile.Presenter

class BestRunPresenter(private val getGameRunById: GetGameRunById) : Presenter<BestRunPresenter.View>() {

  override fun onViewAttached() {}

  fun onRunUrlGathered(runId: String?) = with(getView()) {
    runId?.let {
      showLoading()
      val disposable = getGameRunById.execute(runId).subscribe(
        {
          showRunData(it)
          hideLoading()
        },
        { hideLoading() }
      )
      addDisposable(disposable)
    }
  }

  interface View : Presenter.View {
    fun showRunData(gameRun: GameRun)
  }
}
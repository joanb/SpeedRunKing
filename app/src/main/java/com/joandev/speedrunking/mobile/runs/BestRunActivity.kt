package com.joandev.speedrunking.mobile.runs

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.joandev.speedrunking.R
import com.joandev.speedrunking.domain.runs.model.GameRun
import org.koin.android.ext.android.inject

class BestRunActivity : AppCompatActivity(), BestRunPresenter.View {

  private val presenter: BestRunPresenter by inject()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_detail)

    presenter.attachView(this)
    presenter.onRunUrlGathered(intent.extras.getString(RUN_URL_KEY))
  }

  override fun showRunData(gameRun: GameRun) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun showLoading() {}
  override fun hideLoading() {}

  companion object {
    private const val RUN_URL_KEY = "run_url_key"

    fun getIntent(context: Context, runUrl: String): Intent {
      return Intent(context, BestRunActivity::class.java).apply {
        putExtra(RUN_URL_KEY, runUrl)
      }
    }
  }
}

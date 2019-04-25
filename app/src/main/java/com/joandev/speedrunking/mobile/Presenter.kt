package com.joandev.speedrunking.mobile

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class Presenter<V : Presenter.View> {

  private var view: V? = null
  private val disposables = CompositeDisposable()

  fun attachView(view: V) {
    this.view = view
    onViewAttached()
  }

  protected abstract fun onViewAttached()

  open fun detachView() {
    this.view = null
    disposables.dispose()
  }

  fun dispose() {
    if (!disposables.isDisposed) {
      disposables.dispose()
    }
  }

  fun addDisposable(disposable: Disposable) {
    disposables.add(disposable)
  }

  fun getView(): V = view!!

  interface View {
    fun showLoading()
    fun hideLoading()
  }
}
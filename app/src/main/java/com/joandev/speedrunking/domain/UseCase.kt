package com.joandev.speedrunking.domain

import io.reactivex.Scheduler
import io.reactivex.Single

abstract class UseCase<in RQ, RS>(
    private val threadScheduler: Scheduler,
    private val postExecutionScheduler: Scheduler
) {

    internal abstract fun buildUseCaseSingle(params: RQ): Single<RS>

    fun execute(params: RQ): Single<RS> = buildUseCaseSingle(params)
        .subscribeOn(threadScheduler)
        .observeOn(postExecutionScheduler)
}
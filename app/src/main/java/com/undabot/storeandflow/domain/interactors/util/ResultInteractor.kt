package com.undabot.storeandflow.domain.interactors.util

import kotlinx.coroutines.withContext

abstract class ResultInteractor<in P, R> : Interactor {

  suspend operator fun invoke(params: P): R {
    return withContext(dispatcher) { doWork(params) }
  }

  protected abstract suspend fun doWork(params: P): R

}

suspend operator fun <R> ResultInteractor<Unit, R>.invoke() = invoke(Unit)

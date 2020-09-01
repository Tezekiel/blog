package com.undabot.storeandflow.domain.interactors.util

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn

abstract class StreamInteractor<P : Any, R> : Interactor {

  operator fun invoke(params: P): Flow<R> {
    return createStream(params).flowOn(dispatcher)
  }

  suspend operator fun invoke(params: P, receiver: (R) -> Unit) {
    createStream(params)
      .flowOn(dispatcher)
      .collect { receiver(it) }
  }

  protected abstract fun createStream(params: P): Flow<R>

}

operator fun <R> StreamInteractor<Unit, R>.invoke() = invoke(Unit)
suspend operator fun <R> StreamInteractor<Unit, R>.invoke(receiver: (R) -> Unit) = invoke(Unit, receiver)

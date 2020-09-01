package com.undabot.storeandflow.domain.interactors.util

import kotlinx.coroutines.CoroutineDispatcher

interface Interactor {
  /** Dispatcher where work is going to be executed */
  val dispatcher: CoroutineDispatcher
}

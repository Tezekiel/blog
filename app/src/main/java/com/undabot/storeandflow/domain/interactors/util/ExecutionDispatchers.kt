package com.undabot.storeandflow.domain.interactors.util

import kotlinx.coroutines.CoroutineDispatcher

data class ExecutionDispatchers(
  val io: CoroutineDispatcher,
  val computation: CoroutineDispatcher,
  val main: CoroutineDispatcher
)

package com.undabot.storeandflow.domain.interactors

import com.undabot.storeandflow.data.repository.MessagesRepository
import com.undabot.storeandflow.domain.interactors.util.ExecutionDispatchers
import com.undabot.storeandflow.domain.interactors.util.ResultInteractor

class DeleteMessage(
  private val repository: MessagesRepository,
  executionDispatchers: ExecutionDispatchers
) : ResultInteractor<String, Unit>() {

  override val dispatcher = executionDispatchers.io

  override suspend fun doWork(params: String) {
    return repository.deleteMessage(params)
  }
}
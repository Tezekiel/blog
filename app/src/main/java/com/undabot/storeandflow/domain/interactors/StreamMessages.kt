package com.undabot.storeandflow.domain.interactors

import com.dropbox.android.external.store4.StoreResponse
import com.undabot.storeandflow.domain.model.Message
import com.undabot.storeandflow.data.repository.MessagesRepository
import com.undabot.storeandflow.domain.interactors.util.ExecutionDispatchers
import com.undabot.storeandflow.domain.interactors.util.StreamInteractor
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class StreamMessages(
  private val repository: MessagesRepository,
  dispatchers: ExecutionDispatchers
) : StreamInteractor<Unit, StoreResponse<List<Message>>>(){

  override val dispatcher: CoroutineDispatcher = dispatchers.io

  override fun createStream(params: Unit): Flow<StoreResponse<List<Message>>> {
    return repository.streamQuestions()
  }
}
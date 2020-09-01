package com.undabot.storeandflow.di

import com.undabot.storeandflow.domain.interactors.DeleteMessage
import com.undabot.storeandflow.domain.interactors.StreamMessages
import com.undabot.storeandflow.domain.interactors.util.ExecutionDispatchers
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val interactorModule = module {
    single { ExecutionDispatchers(Dispatchers.IO, Dispatchers.Default, Dispatchers.Main) }
    single { StreamMessages(get(), get()) }
    single { DeleteMessage(get(), get()) }
}
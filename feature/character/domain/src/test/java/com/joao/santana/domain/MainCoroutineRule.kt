package com.joao.santana.domain

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.rules.TestWatcher
import org.junit.runner.Description
import kotlin.coroutines.ContinuationInterceptor

@ExperimentalCoroutinesApi
class MainCoroutineRule : TestWatcher(), TestCoroutineScope by TestCoroutineScope() {

    private val coroutineDispatcher = coroutineContext[ContinuationInterceptor] as TestCoroutineDispatcher

    override fun starting(description: Description) {
        super.starting(description)
        Dispatchers.setMain(coroutineDispatcher)
    }

    override fun finished(description: Description) {
        super.finished(description)
        cleanupTestCoroutines()
        Dispatchers.resetMain()
    }
}

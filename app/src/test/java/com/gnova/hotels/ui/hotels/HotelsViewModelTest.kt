package com.gnova.hotels.ui.hotels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.gnova.data.repositories.HotelsRepoImpl
import com.gnova.hotels.ui.RxImmediateSchedulerRule
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import org.junit.Assert.*
import org.junit.Before
import org.junit.ClassRule
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class HotelsViewModelTest {

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    companion object {
        @ClassRule
        @JvmField
        val schedulers = RxImmediateSchedulerRule()
    }


    @Mock
    lateinit var hotelsRepo: HotelsRepoImpl

    private lateinit var hotelsViewModel: HotelsViewModel





    @Before
    @Throws(Exception::class)
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        hotelsViewModel = HotelsViewModel(hotelsRepo)
    }

    @Test
    fun `GIVEN getHotels returns list WHEN onViewLoaded THEN viewState is Presenting`() {
        //GIVEN
        whenever(hotelsRepo.getHotels()).thenReturn(Single.just(listOf()))

        //WHEN
        hotelsViewModel.onViewLoaded()

        //THEN
        assertEquals(HotelsViewState.Presenting(listOf()), hotelsViewModel.viewState.value)
    }



}
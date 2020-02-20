package com.example.spacex

import First_stage
import SpaceBaseListModel
import com.example.spacex.presenter.ContractPresenter
import com.example.spacex.presenter.RocketsRepository
import com.example.spacex.presenter.SpacePresenter
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner
import java.lang.NullPointerException

@RunWith(MockitoJUnitRunner::class)
class PresenterTest {

    @Mock
    lateinit var view: ContractView

    @Mock
    lateinit var caller: RocketsRepository

    lateinit var presenter: ContractPresenter
    lateinit var list: SpaceBaseListModel

    @Before
    fun toSet() {
        presenter = SpacePresenter(view, caller)
        val sss = First_stage(22.2)
        list = SpaceBaseListModel(true, sss, "Azerbaijan", "Mangal")

    }

    @Test
    fun `get repo return correct`() {
        //given
        val testList = listOf(list)
        `when`(caller.getRocketsData()).thenReturn(Observable.just(testList))

        //when
        presenter.getRepo()

        //then
        verify(view).showRepo(testList)
    }

    @Test
    fun `get repo return error`() {
        //given
        var message = "error happened"
        var newException = NullPointerException(message)
        `when`(caller.getRocketsData()).thenReturn(Observable.error(newException))

        //when
        presenter.getRepo()

        //then
        verify(view).showError(newException)
    }

    @Test
    fun `hide loading after loading repo`() {
//      want to see if hideLoading is evoked after

        `when`(caller.getRocketsData()).thenReturn(Observable.just(emptyList()))
        presenter.getRepo()
        verify(view).hideLoading()
    }

    @Test
    fun `show loading when loading repo`() {
        `when`(caller.getRocketsData()).thenReturn(Observable.just(emptyList()))
        presenter.getRepo()
        verify(view).showLoading()

    }


}
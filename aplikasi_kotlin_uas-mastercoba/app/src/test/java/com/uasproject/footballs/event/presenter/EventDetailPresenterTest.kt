package com.uasproject.footballs.event.presenter

import com.google.gson.Gson
import com.uasproject.footballs.api.ApiRepository
import com.uasproject.footballs.team.model.Team
import com.uasproject.footballs.team.model.TeamResponse
import com.uasproject.footballs.util.CoroutineContextProviderTest
import com.uasproject.footballs.event.interfaces.EventDetailView
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class EventDetailPresenterTest {

    @Mock
    private lateinit var view: EventDetailView

    @Mock
    private lateinit var gson: Gson

    @Mock
    private lateinit var apiRepository: ApiRepository

    @Mock
    private lateinit var apiResponse: Deferred<String>

    private lateinit var presenter: EventDetailPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = EventDetailPresenter(view, apiRepository, gson, CoroutineContextProviderTest())
    }

    @Test
    fun getHomeTeam() {
        val teams: MutableList<Team> = mutableListOf()
        val response = TeamResponse(teams)
        val team = "135170"

        runBlocking {
            Mockito.`when`(apiRepository.doRequestAsync(ArgumentMatchers.anyString()))
                .thenReturn(apiResponse)

            Mockito.`when`(apiResponse.await()).thenReturn("")

            Mockito.`when`(
                gson.fromJson(
                    "",
                    TeamResponse::class.java
                )
            ).thenReturn(response)

            presenter.getHomeTeam(team)
            Mockito.verify(view).showLoading()
        }
    }

    @Test
    fun getAwayTeam() {
        val teams: List<Team> = listOf()
        val response = TeamResponse(teams)
        val team = "135162"

        runBlocking {
            Mockito.`when`(apiRepository.doRequestAsync(ArgumentMatchers.anyString()))
                .thenReturn(apiResponse)

            Mockito.`when`(apiResponse.await()).thenReturn("")

            Mockito.`when`(
                gson.fromJson(
                    "",
                    TeamResponse::class.java
                )
            ).thenReturn(response)

            presenter.getAwayTeam(team)
            Mockito.verify(view).showLoading()
            Mockito.verify(view).hideLoading()
        }
    }
}
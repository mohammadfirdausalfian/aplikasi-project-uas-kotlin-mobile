package com.uasproject.footballs.team.presenter

import com.google.gson.Gson
import com.uasproject.footballs.api.ApiRepository
import com.uasproject.footballs.api.DBApi
import com.uasproject.footballs.team.interfaces.TeamView
import com.uasproject.footballs.team.model.TeamResponse
import com.uasproject.footballs.util.CoroutineContextProvider
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class TeamPresenter(
    private val view: TeamView, private val apiRepository: ApiRepository, private val gson: Gson,
    private val context: CoroutineContextProvider = CoroutineContextProvider()
) {
    fun getData(id: String?) {
        view.showLoading()
        GlobalScope.launch(context.main) {
            val data = gson.fromJson(
                apiRepository.doRequestAsync(DBApi.getTeamLeague(id)).await(),
                TeamResponse::class.java
            )
            view.showData(data.teams)
            view.hideLoading()
        }
    }
}
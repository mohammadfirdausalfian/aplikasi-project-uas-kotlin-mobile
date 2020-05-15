package com.uasproject.footballs.player.presenter

import com.google.gson.Gson
import com.uasproject.footballs.api.ApiRepository
import com.uasproject.footballs.api.DBApi
import com.uasproject.footballs.player.interfaces.PlayerView
import com.uasproject.footballs.player.model.PlayerResponse
import com.uasproject.footballs.util.CoroutineContextProvider
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class PlayerPresenter(
    private val view: PlayerView,
    private val apiRepository: ApiRepository,
    private val gson: Gson,
    private val context: CoroutineContextProvider = CoroutineContextProvider()
) {

    fun getData(id: String?) {
        view.showLoading()
        GlobalScope.launch(context.main) {
            val data = gson.fromJson(
                apiRepository.doRequestAsync(DBApi.getPlayer(id)).await(),
                PlayerResponse::class.java
            )

            view.showData(data.player)
            view.hideLoading()
        }
    }
}
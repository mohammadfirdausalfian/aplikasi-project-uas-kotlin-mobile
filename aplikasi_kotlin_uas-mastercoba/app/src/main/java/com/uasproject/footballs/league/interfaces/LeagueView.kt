package com.uasproject.footballs.league.interfaces

import com.uasproject.footballs.league.model.League

interface LeagueView {
    fun showLoading()
    fun hideLoading()
    fun showData(data: List<League>?)
}
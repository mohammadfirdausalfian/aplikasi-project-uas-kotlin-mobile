package com.uasproject.footballs.event.interfaces

import com.uasproject.footballs.team.model.Team

interface EventDetailView {
    fun dataHome(homeTeam: Team)
    fun dataAway(awayTeam: Team)
    fun showLoading()
    fun hideLoading()
}
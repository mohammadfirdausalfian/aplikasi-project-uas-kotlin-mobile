package com.uasproject.footballs.search.interfaces

import com.uasproject.footballs.event.model.Event
import com.uasproject.footballs.team.model.Team

interface SearchView {
    fun showLoading()
    fun hideLoading()
    fun showEvent(data: List<Event>?)
    fun showTeam(data: List<Team>)
}
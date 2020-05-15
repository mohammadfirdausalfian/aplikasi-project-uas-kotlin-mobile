package com.uasproject.footballs.team.interfaces

import com.uasproject.footballs.team.model.Team

interface TeamView {
    fun showLoading()
    fun hideLoading()
    fun showData(data: List<Team>?)
}
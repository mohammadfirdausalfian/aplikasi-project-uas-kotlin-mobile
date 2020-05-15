package com.uasproject.footballs.league.interfaces

import com.uasproject.footballs.league.model.Standing

interface StandingView {
    fun showLoading()
    fun hideLoading()
    fun showData(data: List<Standing>?)
}
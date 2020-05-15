package com.uasproject.footballs.player.interfaces

import com.uasproject.footballs.player.model.Player

interface PlayerView {
    fun showLoading()
    fun hideLoading()
    fun showData(data: List<Player>?)
}
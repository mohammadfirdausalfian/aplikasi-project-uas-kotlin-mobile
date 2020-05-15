package com.uasproject.footballs.event.interfaces

import com.uasproject.footballs.event.model.Event

interface EventView {
    fun showLoading()
    fun hideLoading()
    fun showData(data: List<Event>?)
    fun showDataNext(data: List<Event>?)
    fun showDataPrev(data: List<Event>?)
}

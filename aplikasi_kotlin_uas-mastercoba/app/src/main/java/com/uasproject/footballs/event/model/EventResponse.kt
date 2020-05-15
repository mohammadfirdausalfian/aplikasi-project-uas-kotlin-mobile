package com.uasproject.footballs.event.model

import com.google.gson.annotations.SerializedName
import com.uasproject.footballs.event.model.Event

data class EventResponse(
    @SerializedName("events")
    val events: List<Event>
)
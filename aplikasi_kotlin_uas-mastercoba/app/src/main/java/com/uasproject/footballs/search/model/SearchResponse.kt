package com.uasproject.footballs.search.model

import com.google.gson.annotations.SerializedName
import com.uasproject.footballs.event.model.Event

data class SearchResponse(
    @SerializedName("event")
    val event: List<Event>
)
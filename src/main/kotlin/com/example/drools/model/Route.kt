package com.example.drools.model

data class Route(
    val routeId: Int,
    val distance: Int,
    private var state: String = "unknown"
) {
    fun setState(state: String) {
        this.state = state
    }

    fun getState(): String {
        return state
    }
}
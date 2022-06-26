package com.example.drools.model

data class RouteResult (val routeId: Int) {
    private var state: String = "unknown";

    fun setState(state: String) {
        this.state = state
    }

    fun getState(): String {
        return state
    }
}
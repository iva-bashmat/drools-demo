package com.example.drools.service

import com.example.drools.model.Route
import com.example.drools.model.RouteResult
import org.kie.api.runtime.KieContainer
import org.springframework.stereotype.Service


@Service
class RulesService (val kieContainer: KieContainer) {

    fun applyRule(route: Route): RouteResult {
        val kieSession = kieContainer.newKieSession()
        try {
            val routeResult = RouteResult(route.routeId)
            kieSession.setGlobal("routeResult", routeResult)
            kieSession.insert(route)
            kieSession.fireAllRules()
            return routeResult
        } finally {
            kieSession.dispose()
        }
    }
}
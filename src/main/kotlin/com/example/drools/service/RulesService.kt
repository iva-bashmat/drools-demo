package com.example.drools.service

import com.example.drools.model.Route
import org.kie.api.runtime.KieContainer
import org.springframework.stereotype.Service


@Service
class RulesService (val kieContainer: KieContainer) {

    fun applyRule(route: Route) {
        val kieSession = kieContainer.newKieSession()
        try {
            kieSession.insert(route)
            kieSession.fireAllRules()
        } finally {
            kieSession.dispose()
        }
    }
}
package com.example.drools.service

import com.example.drools.model.Route
import com.example.drools.model.RouteResult
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class RulesServiceTest {

    @Autowired
    private lateinit var rulesService: RulesService

    @Test
    fun `testAccept`() {
        var routeAccept = Route(47250, 3)

        var routeResult = RouteResult(1)
        routeResult.setState("no")

        assertEquals("accepted", rulesService.applyRule(routeAccept).getState())
    }

    @Test
    fun `testReject`() {
        var routeReject = Route(47250, 1027)
        var routeIgnore = Route(47250, 231)

        var routeResult = RouteResult(1)
        routeResult.setState("no")

        assertEquals("rejected", rulesService.applyRule(routeReject).getState())
    }

    @Test
    fun `testUnknown`() {
        var routeIgnore = Route(47250, 231)

        var routeResult = RouteResult(1)
        routeResult.setState("no")

        assertEquals("unknown", rulesService.applyRule(routeIgnore).getState())
    }
}
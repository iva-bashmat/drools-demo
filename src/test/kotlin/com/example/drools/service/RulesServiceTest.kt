package com.example.drools.service

import com.example.drools.model.Route
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class RulesServiceTest {

    @Autowired
    private lateinit var rulesService: RulesService

    @Test
    fun testAccept() {
        val routeAccept = Route(47250, 3)
        assertEquals("accepted", rulesService.applyRule(routeAccept).getState())
    }

    @Test
    fun testReject() {
        val routeReject = Route(47250, 1027)
        assertEquals("rejected", rulesService.applyRule(routeReject).getState())
    }

    @Test
    fun testUnknown() {
        val routeIgnore = Route(47250, 231)
        assertEquals("unknown", rulesService.applyRule(routeIgnore).getState())
    }
}
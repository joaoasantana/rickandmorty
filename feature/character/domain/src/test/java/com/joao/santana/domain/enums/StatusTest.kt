package com.joao.santana.domain.enums

import junit.framework.TestCase
import org.junit.Test

class StatusTest {

    @Test
    fun `test status alive`() {
        TestCase.assertEquals(Status.Alive.id, "Alive")
    }

    @Test
    fun `test status dead`() {
        TestCase.assertEquals(Status.Dead.id, "Dead")
    }

    @Test
    fun `test status unknown`() {
        TestCase.assertEquals(Status.Unknown.id, "unknown")
    }
}

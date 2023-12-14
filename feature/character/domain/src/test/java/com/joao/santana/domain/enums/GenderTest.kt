package com.joao.santana.domain.enums

import junit.framework.TestCase.assertEquals
import org.junit.Test

class GenderTest {

    @Test
    fun `test gender female`() {
        assertEquals(Gender.Female.id, "Female")
    }

    @Test
    fun `test gender male`() {
        assertEquals(Gender.Male.id, "Male")
    }

    @Test
    fun `test gender genderless`() {
        assertEquals(Gender.Genderless.id, "Genderless")
    }

    @Test
    fun `test gender unknown`() {
        assertEquals(Gender.Unknown.id, "unknown")
    }
}

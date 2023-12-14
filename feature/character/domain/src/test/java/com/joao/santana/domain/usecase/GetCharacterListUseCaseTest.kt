package com.joao.santana.domain.usecase

import com.joao.santana.domain.MainCoroutineRule
import com.joao.santana.domain.entity.Character
import com.joao.santana.domain.entity.CharacterFilter
import com.joao.santana.domain.enums.Gender
import com.joao.santana.domain.enums.Status
import com.joao.santana.domain.repository.CharacterRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import io.mockk.unmockkAll
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class GetCharacterListUseCaseTest {

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @MockK
    private lateinit var characterRepository: CharacterRepository

    private lateinit var useCase: GetCharacterListUseCase

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        useCase = GetCharacterListUseCase(characterRepository)
    }

    @After
    fun tearDown() {
        unmockkAll()
    }

    @Test
    fun `should returns an list of character when getCharacterList is success`() = runTest {
        val param = CharacterFilter()
        val expectedResult = mockCharacterList()

        coEvery { characterRepository.getCharacterList(any()) } returns flow { emit(mockCharacterList()) }

        useCase(param).collectLatest { actualResult ->
            assertEquals(expectedResult, actualResult)
        }

        coVerify { characterRepository.getCharacterList(param) }
    }

    @Test
    fun `should returns an exception when getCharacterList throw an error`() = runTest {
        val param = CharacterFilter()
        val expectedMessage = "Test123"

        coEvery { characterRepository.getCharacterList(any()) } returns flow { throw Exception(expectedMessage) }

        useCase(param).catch { actualResult ->
            assertTrue(actualResult is Exception)
            assertEquals(actualResult.message, expectedMessage)
        }.collect()

        coVerify { characterRepository.getCharacterList(param) }
    }

    private fun mockCharacterList(): List<Character> {
        return listOf(
            Character(1, "test", Status.Alive, "", "", Gender.Female, ""),
            Character(2, "test2", Status.Dead, "", "", Gender.Male, ""),
        )
    }
}

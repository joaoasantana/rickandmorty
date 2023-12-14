package com.joao.santana.domain.usecase

import com.joao.santana.domain.entity.Character
import com.joao.santana.domain.entity.CharacterFilter
import com.joao.santana.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow

class GetCharacterListUseCase(
    private val characterRepository: CharacterRepository
) {

    suspend operator fun invoke(filter: CharacterFilter): Flow<List<Character>> {
        return characterRepository.getCharacterList(filter)
    }
}

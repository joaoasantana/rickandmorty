package com.joao.santana.domain.repository

import com.joao.santana.domain.entity.Character
import com.joao.santana.domain.entity.CharacterFilter
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    suspend fun getCharacterList(filter: CharacterFilter): Flow<List<Character>>
}

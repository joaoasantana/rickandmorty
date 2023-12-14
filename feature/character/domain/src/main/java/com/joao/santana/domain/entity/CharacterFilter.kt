package com.joao.santana.domain.entity

import com.joao.santana.domain.enums.Gender
import com.joao.santana.domain.enums.Status

data class CharacterFilter(
    val gender: Gender? = null,
    val name: String? = null,
    val status: Status? = null,
    val species: String? = null,
    val type: String? = null,
)

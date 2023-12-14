package com.joao.santana.domain.entity

import com.joao.santana.domain.enums.Gender
import com.joao.santana.domain.enums.Status

data class Character(
    val id: Int,
    val name: String,
    val status: Status,
    val species: String,
    val type: String,
    val gender: Gender,
    val image: String,
)

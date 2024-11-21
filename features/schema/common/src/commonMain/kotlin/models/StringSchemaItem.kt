package dev.inmo.config_creator.features.schema.common.models

import dev.inmo.config_creator.features.schema.common.utils.RegexSerializer
import kotlinx.serialization.Serializable

@Serializable
data class StringSchemaItem(
    @Serializable(RegexSerializer::class)
    val regex: Regex? = null,
    val minSymbols: Int? = null,
    val maxSymbols: Int? = null
)

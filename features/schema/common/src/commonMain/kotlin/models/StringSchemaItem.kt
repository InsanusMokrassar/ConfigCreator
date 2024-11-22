package dev.inmo.config_creator.features.schema.common.models

import dev.inmo.config_creator.features.schema.common.utils.RegexSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("string")
data class StringSchemaItem(
    @Serializable(RegexSerializer::class)
    val regex: Regex? = null,
    val minSymbols: Int? = null,
    val maxSymbols: Int? = null
) : SchemaItem

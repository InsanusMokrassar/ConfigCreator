package dev.inmo.config_creator.features.schema.common.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("object")
data class MapSchemaItem(
    val items: Map<String, SchemaItem>,
    val requiredFields: Set<String>
) : SchemaItem.Collection

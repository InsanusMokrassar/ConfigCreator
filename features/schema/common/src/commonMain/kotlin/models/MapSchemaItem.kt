package dev.inmo.config_creator.features.schema.common.models

import kotlinx.serialization.Serializable

@Serializable
data class MapSchemaItem(
    val items: Map<String, SchemaItem>,
    val requiredFields: Set<String>
) : SchemaItem.Collection

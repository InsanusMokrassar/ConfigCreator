package dev.inmo.config_creator.features.schema.common.models

import kotlinx.serialization.Serializable

@Serializable
data class ArraySchemaItem(
    val itemsType: SchemaItem,
    val minItems: Int?,
    val maxItems: Int?,
) : SchemaItem.Collection

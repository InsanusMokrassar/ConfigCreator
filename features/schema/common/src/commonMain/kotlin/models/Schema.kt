package dev.inmo.config_creator.features.schema.common.models

import kotlinx.serialization.Serializable

@Serializable
data class Schema(
    val rootItem: SchemaItem
)

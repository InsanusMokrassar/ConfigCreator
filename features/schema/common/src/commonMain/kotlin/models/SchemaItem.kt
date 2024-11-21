package dev.inmo.config_creator.features.schema.common.models

import kotlinx.serialization.Serializable

@Serializable
sealed interface SchemaItem {
    @Serializable
    sealed interface Primitive : SchemaItem
    @Serializable
    sealed interface Collection : SchemaItem
}

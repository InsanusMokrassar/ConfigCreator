package dev.inmo.config_creator.features.schema.common.models

import dev.inmo.micro_utils.ksp.sealed.GenerateSealedWorkaround
import kotlinx.serialization.Serializable

@Serializable
sealed interface SchemaItem {
    val typeInfo: SchemaItemType

    @Serializable
    sealed interface Primitive : SchemaItem {
        override val typeInfo: Type

        sealed interface Type : SchemaItemType
    }
    @Serializable
    sealed interface Collection : SchemaItem {
        override val typeInfo: Type

        sealed interface Type : SchemaItemType
    }

    @Serializable
    @GenerateSealedWorkaround
    sealed interface SchemaItemType {
        fun createDefault(): SchemaItem
    }
}

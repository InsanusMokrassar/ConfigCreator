package dev.inmo.config_creator.features.schema.common.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
@SerialName("array")
data class ArraySchemaItem(
    val itemsType: SchemaItem,
    val minItems: Int?,
    val maxItems: Int?,
) : SchemaItem.Collection {
    @Transient
    override val typeInfo: Companion
        get() = Companion

    @Serializable
    sealed interface Error : SchemaItem.Error {
        @Serializable
        data class SizeExceedsBounds(
            val item: ArraySchemaItem,
            val arraySize: Int
        ) : Error
        @Serializable
        data class SubItemError(
            val item: ArraySchemaItem,
            val index: Int,
            val error: SchemaItem.Error
        ) : Error
    }

    companion object : SchemaItem.Collection.Type {
        override fun createDefault(): ArraySchemaItem = ArraySchemaItem(
            itemsType = StringSchemaItem.createDefault(),
            minItems = null,
            maxItems = null
        )
    }
}

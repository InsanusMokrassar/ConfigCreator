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
    companion object : SchemaItem.Collection.Type
}

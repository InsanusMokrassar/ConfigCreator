package dev.inmo.config_creator.features.schema.common.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
@SerialName("object")
data class MapSchemaItem(
    val items: List<Item>,
) : SchemaItem.Collection {
    @Transient
    override val typeInfo: Companion
        get() = Companion

    @Serializable
    data class Item(
        val fieldTitle: String,
        val item: SchemaItem,
        val isRequired: Boolean,
    )

    @Serializable
    sealed interface Error : SchemaItem.Error {
        @Serializable
        data class RequiredFieldAbsent(
            val item: MapSchemaItem,
            val subItem: Item,
        ) : Error
    }

    companion object : SchemaItem.Collection.Type {
        override fun createDefault(): SchemaItem = MapSchemaItem(
            items = emptyList(),
        )
    }
}

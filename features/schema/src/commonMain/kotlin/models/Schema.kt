package dev.inmo.config_creator.features.schema.common.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.decodeFromJsonElement

@Serializable
data class Schema(
    val rootItem: SchemaItem
) {
    fun serializeToJson() = Json.encodeToJsonElement(Schema.serializer(), this)
    fun serializeToString() = Json.encodeToString(Schema.serializer(), this)

    companion object {
        fun deserializeFromJson(
            jsonElement: JsonElement
        ) = Json.decodeFromJsonElement(Schema.serializer(), jsonElement)
        fun deserializeFromString(
            stringified: String
        ) = Json.decodeFromString(Schema.serializer(), stringified)
    }
}

private fun merge(first: SchemaItem, second: SchemaItem): SchemaItem {
    return if (first is MapSchemaItem && second is MapSchemaItem) {
        val firstItemsAsMap = first.items.associateBy { it.fieldTitle }
        val secondItemsAsMap = second.items.associateBy { it.fieldTitle }

        val keys = firstItemsAsMap.keys + secondItemsAsMap.keys

        val newItems = keys.mapNotNull {
            val firstData = firstItemsAsMap[it]
            val secondData = secondItemsAsMap[it]

            when {
                firstData != null && secondData != null -> {
                    val newItem = merge(firstData.item, secondData.item)
                    MapSchemaItem.Item(
                        it,
                        newItem,
                        firstData.isRequired || secondData.isRequired
                    )
                }
                else -> firstData ?: secondData
            }
        }

        MapSchemaItem(
            newItems.sortedBy { newItem ->
                (first
                    .items
                    .indexOfFirst { it.fieldTitle == newItem.fieldTitle }
                    .takeIf { it != -1 })
                    ?:
                    (second
                        .items
                        .indexOfFirst {
                            it.fieldTitle == newItem.fieldTitle
                        }
                        .plus(first.items.size))
            }
        )
    } else {
        first
    }
}

operator fun Schema.plus(other: Schema): Schema {
    return Schema(
        merge(rootItem, other.rootItem),
    )
}

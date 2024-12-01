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

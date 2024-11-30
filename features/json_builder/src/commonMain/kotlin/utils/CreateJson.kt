package dev.inmo.config_creator.features.json_builder.client.utils

import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive

fun Any.createJson(): JsonElement {
    return when (this) {
        is List<*> -> JsonArray(
            map { it!!.createJson() }
        )
        is Map<*, *> -> (this as Map<String, Any>).let {
            JsonObject(
                it.mapValues {
                    it.value.createJson()
                }
            )
        }
        is String -> JsonPrimitive(this)
        is Number -> JsonPrimitive(this)
        is Boolean -> JsonPrimitive(this)
        else -> error("Unknown type to convert to json: $this")
    }
}

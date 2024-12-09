package dev.inmo.config_creator.features.json_builder.client.utils

import kotlinx.serialization.json.*

fun Any.createJson(): JsonElement {
    return when (this) {
        is List<*> -> JsonArray(
            map { it!!.createJson() }
        )
        is Map<*, *> -> (this as Map<String, Any?>).let {
            JsonObject(
                it.filterValues {
                    it != null
                }.mapValues {
                    it.value ?.createJson() ?: JsonNull
                }
            )
        }
        is String -> JsonPrimitive(this)
        is Number -> JsonPrimitive(this)
        is Boolean -> JsonPrimitive(this)
        else -> error("Unknown type to convert to json: $this")
    }
}

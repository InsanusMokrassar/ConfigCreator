package dev.inmo.config_creator.features.json_builder.client.utils

import kotlinx.serialization.json.*

fun JsonElement.toStructureItem(): Any? = when {
    this is JsonObject -> {
        val mutableMap = mutableMapOf<String, Any?>()
        forEach {
            mutableMap[it.key] = it.value.toStructureItem()
        }
        mutableMap.toMap()
    }
    this is JsonArray -> {
        val mutableList = mutableListOf<Any?>()
        forEach {
            mutableList.add(it.toStructureItem())
        }
        mutableList.toList()
    }
    this is JsonPrimitive -> when {
        this.isString -> this.content
        this.booleanOrNull != null -> this.boolean
        this.doubleOrNull != null -> this.double
        this.longOrNull != null -> this.long
        else -> null
    }
    else -> null
}

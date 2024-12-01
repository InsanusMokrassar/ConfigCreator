package dev.inmo.config_creator.features.json_builder.client.utils

import dev.inmo.config_creator.features.schema.common.models.*

fun SchemaItem.SchemaItemType.title(
    capitalize: Boolean = true,
): String {
    return when (this) {
        StringSchemaItem -> "string"
        BooleanSchemaItem -> "boolean"
        NumberSchemaItem.WithFloatingPoint -> "double"
        NumberSchemaItem.WithoutFloatingPoint -> "long"
        ArraySchemaItem -> "array"
        MapSchemaItem -> "object"
    }.let { title ->
        title.takeIf {
            !capitalize
        } ?: title.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
    }
}

package dev.inmo.config_creator.features.json_builder.client.utils

import dev.inmo.config_creator.features.schema.common.models.*

fun SchemaItem.SchemaItemType.title(): String {
    return when (this) {
        StringSchemaItem -> "string"
        BooleanSchemaItem -> "boolean"
        NumberSchemaItem.WithFloatingPoint -> "double"
        NumberSchemaItem.WithoutFloatingPoint -> "long"
        ArraySchemaItem -> "array"
        MapSchemaItem -> "object"
    }
}

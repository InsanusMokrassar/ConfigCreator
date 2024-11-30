package dev.inmo.config_creator.features.json_builder.client.ui.schema

import androidx.compose.runtime.Composable
import dev.inmo.config_creator.features.common.client.ui.StandardRow
import dev.inmo.config_creator.features.common.client.ui.StandardSelect
import dev.inmo.config_creator.features.common.client.ui.StandardText
import dev.inmo.config_creator.features.schema.common.models.*

@Composable
fun SchemaTypeDrawer(
    type: SchemaItem.SchemaItemType,
) {
    StandardRow {
        StandardText("Type:")
        StandardText(
            when (type) {
                StringSchemaItem -> "string"
                BooleanSchemaItem -> "boolean"
                NumberSchemaItem.WithFloatingPoint -> "number with floating point"
                NumberSchemaItem.WithoutFloatingPoint -> "number without floating point"
                ArraySchemaItem -> "array"
                MapSchemaItem -> "object"
            }
        )
    }
}

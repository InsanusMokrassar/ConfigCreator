package dev.inmo.config_creator.features.schema_builder.client.ui.schema

import androidx.compose.runtime.Composable
import dev.inmo.config_creator.features.schema.common.models.*

@Composable
fun SchemaTypeDrawer(
    type: SchemaItem.SchemaItemType,
    onChange: (SchemaItem.SchemaItemType) -> Unit,
) {
    StandardRow {
        StandardText("Type:")
        StandardSelect(
            type,
            SchemaItem.SchemaItemType.values(),
            {
                when (it) {
                    StringSchemaItem -> "string"
                    BooleanSchemaItem -> "boolean"
                    NumberSchemaItem.WithFloatingPoint -> "number with floating point"
                    NumberSchemaItem.WithoutFloatingPoint -> "number without floating point"
                    ArraySchemaItem -> "array"
                    MapSchemaItem -> "object"
                }
            }
        ) {
            if (it == type) {
                // do nothing
            } else {
                onChange(
                    it
                )
            }
        }
    }
}

package dev.inmo.config_creator.features.json_builder.client.ui.schema

import androidx.compose.runtime.Composable
import dev.inmo.config_creator.features.schema.common.models.*
import kotlinx.serialization.json.JsonElement

@Composable
fun SchemaItemDrawer(
    item: SchemaItem,
    json: JsonElement,
    onChange: (SchemaItem) -> Unit
) {
    when (item) {
        is ArraySchemaItem -> ArraySchemaItemDrawer(item, onChange)
        is MapSchemaItem -> MapSchemaItemDrawer(item, onChange)
        is BooleanSchemaItem -> BooleanSchemaItemDrawer(item, onChange)
        is NumberSchemaItem.WithFloatingPoint -> NumberWithFloatingPointDrawer(item, onChange)
        is NumberSchemaItem.WithoutFloatingPoint -> NumberWithoutFloatingPointDrawer(item, onChange)
        is StringSchemaItem -> StringSchemaItemDrawer(item, onChange)
    }
}

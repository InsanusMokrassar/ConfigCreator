package dev.inmo.config_creator.features.json_builder.client.ui.schema

import androidx.compose.runtime.Composable
import dev.inmo.config_creator.features.schema.common.models.*

@Composable
fun SchemaItemDrawer(
    item: SchemaItem,
    value: Any,
    onChange: (Any) -> Unit
) {
    when (item) {
        is ArraySchemaItem -> ArraySchemaItemDrawer(item, value as List<Any>, onChange)
        is MapSchemaItem -> MapSchemaItemDrawer(item, value as Map<String, Any?>, onChange)
        is BooleanSchemaItem -> BooleanSchemaItemDrawer(item, value as Boolean, onChange)
        is NumberSchemaItem.WithFloatingPoint -> NumberWithFloatingPointDrawer(item, (value as Number).toDouble(), onChange)
        is NumberSchemaItem.WithoutFloatingPoint -> NumberWithoutFloatingPointDrawer(item, (value as Number).toLong(), onChange)
        is StringSchemaItem -> StringSchemaItemDrawer(item, value as String, onChange)
    }
}

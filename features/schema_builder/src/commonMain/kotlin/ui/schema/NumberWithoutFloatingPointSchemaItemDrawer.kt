package dev.inmo.config_creator.features.schema_builder.client.ui.schema

import androidx.compose.runtime.Composable
import dev.inmo.config_creator.features.schema.common.models.NumberSchemaItem

@Composable
fun NumberWithoutFloatingPointDrawer(
    item: NumberSchemaItem.WithoutFloatingPoint,
    onChange: (NumberSchemaItem.WithoutFloatingPoint) -> Unit
) {
    StandardColumnWithLeftPadding {
        StandardNumberInputDrawer(
            item.min
        ) {
            onChange(item.copy(min = it ?.toLong()))
        }
        StandardNumberInputDrawer(
            item.max
        ) {
            onChange(item.copy(max = it ?.toLong()))
        }
    }
}

package dev.inmo.config_creator.features.schema_builder.client.ui.schema

import androidx.compose.runtime.Composable
import dev.inmo.config_creator.features.schema.common.models.NumberSchemaItem

@Composable
fun NumberWithFloatingPointDrawer(
    item: NumberSchemaItem.WithFloatingPoint,
    onChange: (NumberSchemaItem.WithFloatingPoint) -> Unit
) {
    StandardColumnWithLeftPadding {
        StandardNumberInputDrawer(
            item.min
        ) {
            onChange(item.copy(min = it ?.toDouble()))
        }
        StandardNumberInputDrawer(
            item.max
        ) {
            onChange(item.copy(max = it ?.toDouble()))
        }
    }
}

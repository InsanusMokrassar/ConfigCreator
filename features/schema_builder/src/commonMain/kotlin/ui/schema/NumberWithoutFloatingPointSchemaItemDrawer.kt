package dev.inmo.config_creator.features.schema_builder.client.ui.schema

import androidx.compose.runtime.Composable
import dev.inmo.config_creator.features.common.client.ui.StandardColumnWithLeftPadding
import dev.inmo.config_creator.features.common.client.ui.StandardLongInputDrawer
import dev.inmo.config_creator.features.schema.common.models.NumberSchemaItem

@Composable
fun NumberWithoutFloatingPointDrawer(
    item: NumberSchemaItem.WithoutFloatingPoint,
    onChange: (NumberSchemaItem.WithoutFloatingPoint) -> Unit
) {
    StandardColumnWithLeftPadding {
        StandardLongInputDrawer(
            item.min,
            "Minimal value",
            "Empty means \"no minimal value\""
        ) {
            onChange(item.copy(min = it ?.toLong()))
        }
        StandardLongInputDrawer(
            item.max,
            "Maximal value",
            "Empty means \"no maximal value\""
        ) {
            onChange(item.copy(max = it ?.toLong()))
        }
    }
}

package dev.inmo.config_creator.features.json_builder.client.ui.schema

import androidx.compose.runtime.Composable
import dev.inmo.config_creator.features.common.client.ui.StandardColumnWithLeftPadding
import dev.inmo.config_creator.features.common.client.ui.StandardDoubleInputDrawer
import dev.inmo.config_creator.features.schema.common.models.NumberSchemaItem

@Composable
fun NumberWithFloatingPointDrawer(
    item: NumberSchemaItem.WithFloatingPoint,
    onChange: (NumberSchemaItem.WithFloatingPoint) -> Unit
) {
    StandardColumnWithLeftPadding {
        StandardDoubleInputDrawer(
            item.min,
            "Minimal value",
            "Empty means \"no minimal value\""
        ) {
            onChange(item.copy(min = it))
        }
        StandardDoubleInputDrawer(
            item.max,
            "Maximal value",
            "Empty means \"no maximal value\""
        ) {
            onChange(item.copy(max = it))
        }
    }
}

package dev.inmo.config_creator.features.json_builder.client.ui.schema

import androidx.compose.runtime.Composable
import dev.inmo.config_creator.features.common.client.ui.*
import dev.inmo.config_creator.features.json_builder.client.utils.title
import dev.inmo.config_creator.features.schema.common.models.NumberSchemaItem
import kotlin.math.roundToLong

@Composable
fun NumberWithFloatingPointDrawer(
    item: NumberSchemaItem.WithFloatingPoint,
    value: Double,
    onChange: (Double) -> Unit
) {
    StandardCard {
        StandardColumn {
            StandardRow {
                item.min ?.let {
                    StandardText("Min value: $it")
                } ?: StandardText("Min value: 0.0")
                item.max ?.let {
                    StandardText("Max value: $it")
                } ?: StandardText("Max value: Max Double")
            }
            StandardDoubleInputDrawer(value, null, null, ) {
                val newValue = it ?: value
                onChange(
                    newValue.coerceIn(
                        item.min ?: Double.MIN_VALUE,
                        item.max ?: Double.MAX_VALUE
                    )
                )
            }
        }
    }
}

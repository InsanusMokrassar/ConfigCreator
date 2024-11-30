package dev.inmo.config_creator.features.json_builder.client.ui.schema

import androidx.compose.runtime.Composable
import dev.inmo.config_creator.features.common.client.ui.*
import dev.inmo.config_creator.features.schema.common.models.NumberSchemaItem

@Composable
fun NumberWithoutFloatingPointDrawer(
    item: NumberSchemaItem.WithoutFloatingPoint,
    value: Long,
    onChange: (Long) -> Unit
) {
    StandardColumn {
        StandardRow {
            item.min?.let {
                StandardText("Min value: $it")
            }
            item.max?.let {
                StandardText("Max value: $it")
            }
        }
        StandardLongInputDrawer(value, null, null,) {
            val newValue = it ?: value
            onChange(
                newValue.coerceIn(
                    item.min ?: Long.MIN_VALUE,
                    item.max ?: Long.MAX_VALUE
                )
            )
        }
    }
}

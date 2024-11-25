package dev.inmo.config_creator.features.schema_builder.client.ui.schema

import androidx.compose.runtime.Composable
import dev.inmo.config_creator.features.schema.common.models.BooleanSchemaItem
import dev.inmo.config_creator.features.schema.common.models.StringSchemaItem

@Composable
fun BooleanSchemaItemDrawer(
    item: BooleanSchemaItem,
    onChange: (BooleanSchemaItem) -> Unit
) {
    val useDefault = item.default != null
    StandardColumnWithLeftPadding {
        StandardBooleanDrawer(
            useDefault
        ) {
            onChange(
                item.copy(
                    default = if (it) false else null
                )
            )
        }
        val defaultValue = item.default
        if (defaultValue != null) {
            StandardBooleanDrawer(
                defaultValue
            ) {
                onChange(
                    item.copy(
                        default = it
                    )
                )
            }
        }
    }
}

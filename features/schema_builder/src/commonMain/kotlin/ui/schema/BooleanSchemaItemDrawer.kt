package dev.inmo.config_creator.features.schema_builder.client.ui.schema

import androidx.compose.runtime.Composable
import dev.inmo.config_creator.features.schema.common.models.BooleanSchemaItem

@Composable
fun BooleanSchemaItemDrawer(
    item: BooleanSchemaItem,
    onChange: (BooleanSchemaItem) -> Unit
) {
    val useDefault = item.default != null
    StandardColumn {
        StandardBooleanDrawer(
            useDefault,
            "Use default"
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
                defaultValue,
                "Default value"
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

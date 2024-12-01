package dev.inmo.config_creator.features.json_builder.client.ui.schema

import androidx.compose.runtime.Composable
import dev.inmo.config_creator.features.common.client.ui.StandardBooleanDrawer
import dev.inmo.config_creator.features.common.client.ui.StandardCard
import dev.inmo.config_creator.features.schema.common.models.BooleanSchemaItem

@Composable
fun BooleanSchemaItemDrawer(
    item: BooleanSchemaItem,
    value: Boolean,
    onChange: (Boolean) -> Unit
) {
    StandardCard {
        StandardBooleanDrawer(
            value,
            "Value",
        ) {
            onChange(
                it
            )
        }
    }
}

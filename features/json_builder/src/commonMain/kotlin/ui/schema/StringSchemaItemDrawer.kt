package dev.inmo.config_creator.features.json_builder.client.ui.schema

import androidx.compose.runtime.Composable
import dev.inmo.config_creator.features.common.client.ui.StandardColumn
import dev.inmo.config_creator.features.common.client.ui.StandardIntInputDrawer
import dev.inmo.config_creator.features.common.client.ui.StandardTextInputDrawer
import dev.inmo.config_creator.features.schema.common.models.StringSchemaItem

@Composable
fun StringSchemaItemDrawer(
    item: StringSchemaItem,
    value: String,
    onChange: (String) -> Unit
) {
    StandardTextInputDrawer(
        value,
        null,
        null
    ) {
        onChange(it)
    }
}

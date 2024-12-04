package dev.inmo.config_creator.features.json_builder.client.ui.schema

import androidx.compose.runtime.Composable
import dev.inmo.config_creator.features.common.client.ui.*
import dev.inmo.config_creator.features.schema.common.models.StringSchemaItem

@Composable
fun StringSchemaItemDrawer(
    item: StringSchemaItem,
    value: String,
    onChange: (String) -> Unit
) {
    val placeholder = (item.minSymbols ?.let {
        "Min symbols: $it"
    } ?: "Min symbols: 0") + " " + (item.maxSymbols ?.let {
        "Max symbols: $it"
    } ?: "Max symbols: Unlimited")
    StandardTextInputDrawer(
        value,
        null,
        placeholder
    ) {
        onChange(it)
    }
}

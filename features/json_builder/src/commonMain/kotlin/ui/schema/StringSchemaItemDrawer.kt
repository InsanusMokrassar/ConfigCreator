package dev.inmo.config_creator.features.json_builder.client.ui.schema

import androidx.compose.runtime.Composable
import dev.inmo.config_creator.features.common.client.ui.*
import dev.inmo.config_creator.features.json_builder.client.utils.title
import dev.inmo.config_creator.features.schema.common.models.StringSchemaItem

@Composable
fun StringSchemaItemDrawer(
    item: StringSchemaItem,
    value: String,
    onChange: (String) -> Unit
) {
    StandardRow {
        StandardText("${item.typeInfo.title()}:")
        StandardColumn {
            StandardTextInputDrawer(
                value,
                null,
                null
            ) {
                onChange(it)
            }
            StandardRow {
                item.minSymbols ?.let {
                    StandardText("Min symbols: $it")
                }
                item.maxSymbols ?.let {
                    StandardText("Max symbols: $it")
                }
            }.takeIf { item.minSymbols != null || item.maxSymbols != null }
        }
    }
}

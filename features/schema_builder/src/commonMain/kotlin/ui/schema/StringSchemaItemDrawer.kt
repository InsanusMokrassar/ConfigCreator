package dev.inmo.config_creator.features.schema_builder.client.ui.schema

import androidx.compose.runtime.Composable
import dev.inmo.config_creator.features.schema.common.models.StringSchemaItem

@Composable
fun StringSchemaItemDrawer(
    item: StringSchemaItem,
    onChange: (StringSchemaItem) -> Unit
) {
    StandardColumn {
        StandardNumberInputDrawer(
            item.maxSymbols
        ) {
            onChange(
                item.copy(
                    maxSymbols = it ?.toInt()
                )
            )
        }
        StandardNumberInputDrawer(
            item.minSymbols
        ) {
            onChange(
                item.copy(
                    minSymbols = it ?.toInt()
                )
            )
        }
    }
}

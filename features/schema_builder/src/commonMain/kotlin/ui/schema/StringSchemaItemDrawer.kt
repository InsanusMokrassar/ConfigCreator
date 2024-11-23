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
            item = item.minSymbols,
            label = "Minimal symbols",
            placeholder = "Empty means \"no minimal symbols restrictions\""
        ) {
            onChange(
                item.copy(
                    minSymbols = it ?.toInt()
                )
            )
        }
        StandardNumberInputDrawer(
            item = item.maxSymbols,
            label = "Maximal symbols",
            placeholder = "Empty means \"no maximal symbols restrictions\""
        ) {
            onChange(
                item.copy(
                    maxSymbols = it ?.toInt()
                )
            )
        }
    }
}

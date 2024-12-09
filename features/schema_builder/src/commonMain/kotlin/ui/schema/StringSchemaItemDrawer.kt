package dev.inmo.config_creator.features.schema_builder.client.ui.schema

import androidx.compose.runtime.Composable
import dev.inmo.config_creator.features.common.client.ui.StandardColumn
import dev.inmo.config_creator.features.common.client.ui.StandardIntInputDrawer
import dev.inmo.config_creator.features.schema.common.models.StringSchemaItem

@Composable
fun StringSchemaItemDrawer(
    item: StringSchemaItem,
    onChange: (StringSchemaItem) -> Unit
) {
    StandardColumn {
        StandardIntInputDrawer(
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
        StandardIntInputDrawer(
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

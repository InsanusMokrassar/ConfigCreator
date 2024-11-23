package dev.inmo.config_creator.features.schema_builder.client.ui.schema

import androidx.compose.runtime.Composable
import dev.inmo.config_creator.features.schema.common.models.*

@Composable
fun MapSchemaItemDrawer(
    item: MapSchemaItem,
    onChange: (MapSchemaItem) -> Unit
) {
    StandardColumn {
        item.items.forEach { subItem ->
            StandardTextInputDrawer(
                item = subItem.key,
                label = "Title",
                placeholder = "Empty means absence of field"
            ) { newKey ->
                onChange(
                    item.copy(
                        items = item.items.toMutableMap().apply {
                            remove(subItem.key)
                            put(newKey, subItem.value)
                        }.toMap()
                    )
                )
            }
            SchemaTypeDrawer(subItem.value.typeInfo) {
                onChange(
                    item.copy(
                        items = item.items + (subItem.key to it.createDefault())
                    )
                )
            }
            SchemaItemDrawer(
                subItem.value
            ) {
                onChange(
                    item.copy(
                        items = item.items + (subItem.key to it)
                    )
                )
            }
        }
    }
}

package dev.inmo.config_creator.features.schema_builder.client.ui.schema

import androidx.compose.runtime.Composable
import dev.inmo.config_creator.features.schema.common.models.*

@Composable
fun MapSchemaItemDrawer(
    item: MapSchemaItem,
    onChange: (MapSchemaItem) -> Unit
) {
    StandardColumnWithLeftPadding {
        item.items.forEach { subItem ->
            StandardTextInputDrawer(subItem.key) { newKey ->
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
            StandardColumnWithLeftPadding {
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
}

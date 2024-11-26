package dev.inmo.config_creator.features.schema_builder.client.ui.schema

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import dev.inmo.config_creator.features.schema.common.models.*
import dev.inmo.micro_utils.common.withReplaced

@Composable
fun MapSchemaItemDrawer(
    item: MapSchemaItem,
    onChange: (MapSchemaItem) -> Unit
) {
    StandardColumnWithLeftPadding {
        item.items.forEach { subItem ->
            val (title, subItemItem, isRequired) = subItem
            StandardTextInputDrawer(
                item = title,
                label = "Title",
                placeholder = "Empty means absence of field"
            ) { newKey ->
                onChange(
                    item.copy(
                        items = item.items.withReplaced(subItem) {
                            subItem.copy(
                                fieldTitle = newKey
                            )
                        }
                    )
                )
            }
            StandardBooleanDrawer(
                isRequired,
                "Required"
            ) { newIsRequired ->
                onChange(
                    item.copy(
                        items = item.items.withReplaced(subItem) {
                            subItem.copy(
                                isRequired = newIsRequired
                            )
                        }
                    )
                )
            }
            SchemaTypeDrawer(subItem.item.typeInfo) { newTypeInfo ->
                onChange(
                    item.copy(
                        items = item.items.withReplaced(
                            subItem
                        ) {
                            subItem.copy(
                                item = newTypeInfo.createDefault()
                            )
                        }
                    )
                )
            }
            StandardColumnWithLeftPadding {
                SchemaItemDrawer(
                    subItemItem
                ) { newItem ->
                    onChange(
                        item.copy(
                            items = item.items.withReplaced(
                                subItem
                            ) {
                                subItem.copy(
                                    item = newItem
                                )
                            }
                        )
                    )
                }
            }
        }
        DisposableEffect(item.items) {
            if (item.items.none { it.fieldTitle.isBlank() }) {
                onChange(
                    item.copy(
                        item.items + (
                                MapSchemaItem.Item(
                                    fieldTitle = "",
                                    item = StringSchemaItem(),
                                    isRequired = false
                                )
                            )
                    )
                )
            }
            onDispose {  }
        }
    }
}

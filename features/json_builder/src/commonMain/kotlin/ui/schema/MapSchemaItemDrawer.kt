package dev.inmo.config_creator.features.json_builder.client.ui.schema

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import dev.inmo.config_creator.features.common.client.ui.*
import dev.inmo.config_creator.features.schema.common.models.*
import dev.inmo.micro_utils.common.withReplaced
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonObject

@Composable
fun MapSchemaItemDrawer(
    item: MapSchemaItem,
    json: JsonElement,
    onChange: (MapSchemaItem) -> Unit
) {
    StandardColumnWithLeftPadding {
        item.items.forEach { subItem ->
            val (title, subItemItem, isRequired) = subItem
            StandardRow {
                StandardText(title + " $json")
            }
//            StandardRow {
//                StandardTextInputDrawer(
//                    item = title,
//                    label = "Title",
//                    placeholder = "Empty means absence of field"
//                ) { newKey ->
//                    onChange(
//                        item.copy(
//                            items = item.items.withReplaced(subItem) {
//                                subItem.copy(
//                                    fieldTitle = newKey
//                                )
//                            }
//                        )
//                    )
//                }
//            }
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
    }
}

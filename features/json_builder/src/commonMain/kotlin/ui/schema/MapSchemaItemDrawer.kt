package dev.inmo.config_creator.features.json_builder.client.ui.schema

import androidx.compose.runtime.Composable
import dev.inmo.config_creator.features.common.client.ui.*
import dev.inmo.config_creator.features.json_builder.client.utils.createDefaultNew
import dev.inmo.config_creator.features.json_builder.client.utils.title
import dev.inmo.config_creator.features.schema.common.models.*
import dev.inmo.micro_utils.common.withReplaced
import kotlinx.serialization.json.JsonElement

@Composable
fun MapSchemaItemDrawer(
    item: MapSchemaItem,
    map: Map<String, Any?>,
    onChange: (Map<String, Any?>) -> Unit
) {
    StandardBorder {
        StandardColumnWithLeftPadding {
            item.items.forEach { subItem ->
                val currentValue = map[subItem.fieldTitle]
                StandardRow {
                    StandardBooleanDrawer(
                        currentValue != null || subItem.isRequired,
                        "Title: ${subItem.fieldTitle}",
                        disabled = subItem.isRequired
                    ) {
                        val mutableMap = map.toMutableMap()
                        mutableMap[subItem.fieldTitle] = when (it) {
                            true -> subItem.item.createDefaultNew()
                            false -> null
                        }
                        onChange(
                            mutableMap.toMap()
                        )
                    }
                }
                StandardColumnWithLeftPadding {
                    if (currentValue == null) {
                        return@StandardColumnWithLeftPadding
                    } else {
                        SchemaItemDrawer(
                            subItem.item,
                            currentValue,
                        ) {
                            val mutableMap = map.toMutableMap()
                            mutableMap[subItem.fieldTitle] = it
                            onChange(
                                mutableMap.toMap()
                            )
                        }
                    }
                }
            }
        }
    }
}

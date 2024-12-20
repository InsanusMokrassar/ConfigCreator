package dev.inmo.config_creator.features.json_builder.client.ui.schema

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import dev.inmo.config_creator.features.common.client.ui.*
import dev.inmo.config_creator.features.json_builder.client.utils.createDefaultNew
import dev.inmo.config_creator.features.json_builder.client.utils.title
import dev.inmo.config_creator.features.schema.common.models.ArraySchemaItem
import dev.inmo.micro_utils.common.withReplaced

@Composable
fun ArraySchemaItemDrawer(
    item: ArraySchemaItem,
    value: List<Any>,
    onChange: (List<Any>) -> Unit
) {
    item.minItems ?.let { minItems ->
        SideEffect {
            onChange(
                value + (value.size until minItems).map {
                    item.itemsType.createDefaultNew()
                }
            )
        }
    }

    StandardBorder {
        StandardColumnWithLeftPadding {
            val minItems = item.minItems
            val maxItems = item.maxItems
            StandardRow {
                StandardText("Type: ${item.typeInfo.title()}")
                minItems ?.let {
                    StandardText("Min items: $it")
                }
                maxItems ?.let {
                    StandardText("Max items: $it")
                }
            }
            StandardColumnWithLeftPadding {
                value.forEach { subValue ->
                    StandardRow {
                        SchemaItemDrawer(
                            item.itemsType,
                            subValue
                        ) { newSubValue ->
                            onChange(
                                value.withReplaced(
                                    subValue
                                ) { _ ->
                                    newSubValue
                                }
                            )
                        }
                        if (minItems == null || value.size > minItems) {
                            StandardButton("Remove item") {
                                onChange(
                                    value - subValue
                                )
                            }
                        }
                    }
                }
            }
            if (maxItems == null || value.size < maxItems) {
                StandardRow {
                    StandardButton("Add item") {
                        onChange(
                            value + item.itemsType.createDefaultNew()
                        )
                    }
                }
            }
        }
    }
}

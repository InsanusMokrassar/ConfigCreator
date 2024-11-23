package dev.inmo.config_creator.features.schema_builder.client.ui.schema

import androidx.compose.runtime.Composable
import dev.inmo.config_creator.features.schema.common.models.ArraySchemaItem

@Composable
fun ArraySchemaItemDrawer(
    item: ArraySchemaItem,
    onChange: (ArraySchemaItem) -> Unit
) {
    StandardColumn {
        StandardNumberInputDrawer(
            item.minItems,
            "Min items",
            "Empty means \"no min number\""
        ) {
            onChange(
                item.copy(minItems = it ?.toInt())
            )
        }
        StandardNumberInputDrawer(
            item.maxItems,
            "Max items",
            "Empty means \"no max number\""
        ) {
            onChange(
                item.copy(maxItems = it ?.toInt())
            )
        }
        SchemaTypeDrawer(item.itemsType.typeInfo) {
            onChange(
                item.copy(
                    itemsType = it.createDefault()
                )
            )
        }
        SchemaItemDrawer(
            item.itemsType
        ) {
            onChange(
                item.copy(itemsType = it)
            )
        }
    }
}

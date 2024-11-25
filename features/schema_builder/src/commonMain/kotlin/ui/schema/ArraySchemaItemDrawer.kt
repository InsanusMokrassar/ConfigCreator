package dev.inmo.config_creator.features.schema_builder.client.ui.schema

import androidx.compose.runtime.Composable
import dev.inmo.config_creator.features.schema.common.models.ArraySchemaItem
import dev.inmo.config_creator.features.schema.common.models.BooleanSchemaItem
import dev.inmo.config_creator.features.schema.common.models.StringSchemaItem

@Composable
fun ArraySchemaItemDrawer(
    item: ArraySchemaItem,
    onChange: (ArraySchemaItem) -> Unit
) {
    StandardColumnWithLeftPadding {
        SchemaTypeDrawer(item.itemsType.typeInfo) {
            onChange(
                item.copy(
                    itemsType = it.createDefault()
                )
            )
        }
        StandardColumnWithLeftPadding {
            SchemaItemDrawer(
                item.itemsType
            ) {
                onChange(
                    item.copy(itemsType = it)
                )
            }
        }
        StandardNumberInputDrawer(
            item.minItems
        ) {
            onChange(
                item.copy(minItems = it ?.toInt())
            )
        }
        StandardNumberInputDrawer(
            item.maxItems
        ) {
            onChange(
                item.copy(maxItems = it ?.toInt())
            )
        }
    }
}

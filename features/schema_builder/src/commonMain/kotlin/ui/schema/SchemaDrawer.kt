package dev.inmo.config_creator.features.schema_builder.client.ui.schema

import androidx.compose.runtime.Composable
import dev.inmo.config_creator.features.common.client.ui.StandardButton
import dev.inmo.config_creator.features.common.client.ui.StandardColumn
import dev.inmo.config_creator.features.common.client.ui.StandardRow
import dev.inmo.config_creator.features.schema.common.models.MapSchemaItem
import dev.inmo.config_creator.features.schema.common.models.Schema

@Composable
expect fun BeforeSchemaDrawer()

@Composable
fun SchemaDrawer(
    schema: Schema,
    onSaveSchema: ((Schema) -> Unit)? = null,
    onAddSchema: (() -> Unit)? = null,
    onSchemaChanged: (schema: Schema) -> Unit
) {
    BeforeSchemaDrawer()

    if (onSaveSchema != null || onAddSchema != null) {
        StandardRow {
            onSaveSchema ?.let {
                StandardButton("Save") {
                    it(schema)
                }
            }
            onAddSchema ?.let {
                StandardButton("Load") {
                    onSchemaChanged(Schema(MapSchemaItem.createDefault()))
                    onAddSchema()
                }
            }
            onAddSchema ?.let {
                StandardButton("Add") {
                    onAddSchema()
                }
            }
        }
    }

    StandardColumn {
        SchemaTypeDrawer(schema.rootItem.typeInfo) {
            onSchemaChanged(
                Schema(it.createDefault())
            )
        }
        SchemaItemDrawer(
            schema.rootItem
        ) {
            onSchemaChanged(
                Schema(it)
            )
        }
    }
    onSaveSchema ?.let {
        StandardButton("Save") {
            it(schema)
        }
    }
}

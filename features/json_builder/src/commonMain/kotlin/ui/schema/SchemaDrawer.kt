package dev.inmo.config_creator.features.json_builder.client.ui.schema

import androidx.compose.runtime.Composable
import dev.inmo.config_creator.features.common.client.ui.StandardButton
import dev.inmo.config_creator.features.common.client.ui.StandardColumn
import dev.inmo.config_creator.features.schema.common.models.Schema

@Composable
expect fun BeforeSchemaDrawer()

@Composable
fun SchemaDrawer(
    schema: Schema,
    onSaveSchema: ((Schema) -> Unit)? = null,
    onOpenSchema: (() -> Unit)? = null,
    onSchemaChanged: (schema: Schema) -> Unit
) {
    BeforeSchemaDrawer()
    onSaveSchema ?.let {
        StandardButton("Save") {
            it(schema)
        }
    }
    onOpenSchema ?.let {
        StandardButton("Load") {
            onOpenSchema()
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

package dev.inmo.config_creator.features.schema_builder.client.ui.schema

import androidx.compose.runtime.Composable
import dev.inmo.config_creator.features.schema.common.models.Schema

@Composable
expect fun BeforeSchemaDrawer()

@Composable
fun SchemaDrawer(
    schema: Schema,
    onSchemaChanged: (schema: Schema) -> Unit
) {
    BeforeSchemaDrawer()
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
}

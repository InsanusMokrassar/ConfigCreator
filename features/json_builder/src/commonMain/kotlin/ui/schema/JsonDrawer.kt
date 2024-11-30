package dev.inmo.config_creator.features.json_builder.client.ui.schema

import androidx.compose.runtime.Composable
import dev.inmo.config_creator.features.common.client.ui.StandardButton
import dev.inmo.config_creator.features.common.client.ui.StandardRow
import dev.inmo.config_creator.features.json_builder.client.utils.createJson
import dev.inmo.config_creator.features.schema.common.models.*
import kotlinx.serialization.json.*

@Composable
expect fun BeforeJsonDrawer()

@Composable
fun JsonDrawer(
    schema: Schema?,
    root: Any,
    onSaveJson: ((JsonElement) -> Unit)? = null,
    onOpenJson: (() -> Unit)? = null,
    onRootChanged: (root: Any) -> Unit
) {
    BeforeJsonDrawer()
    StandardRow {
        onSaveJson ?.let {
            StandardButton("Save") {
                it(root.createJson())
            }
        }
        onOpenJson ?.let {
            StandardButton("Load") {
                onOpenJson()
            }
        }
    }
    schema ?.let {
        SchemaItemDrawer(it.rootItem, root) {
            onRootChanged(it)
        }
    }
}

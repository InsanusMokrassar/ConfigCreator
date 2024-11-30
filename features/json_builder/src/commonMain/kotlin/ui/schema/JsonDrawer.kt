package dev.inmo.config_creator.features.json_builder.client.ui.schema

import androidx.compose.runtime.Composable
import dev.inmo.config_creator.features.common.client.ui.StandardButton
import dev.inmo.config_creator.features.common.client.ui.StandardRow
import dev.inmo.config_creator.features.schema.common.models.*
import kotlinx.serialization.json.*

@Composable
expect fun BeforeJsonDrawer()

@Composable
fun JsonDrawer(
    schema: Schema?,
    json: JsonElement,
    onSaveJson: ((JsonElement) -> Unit)? = null,
    onOpenJson: (() -> Unit)? = null,
    onJsonChanged: (json: JsonElement) -> Unit
) {
    BeforeJsonDrawer()
    StandardRow {
        onSaveJson ?.let {
            StandardButton("Save") {
                it(json)
            }
        }
        onOpenJson ?.let {
            StandardButton("Load") {
                onOpenJson()
            }
        }
    }
    schema ?.let {
        SchemaItemDrawer(it.rootItem) {
            onJsonChanged(json)
        }
    }
}

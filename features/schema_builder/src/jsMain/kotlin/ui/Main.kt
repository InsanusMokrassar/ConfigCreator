package dev.inmo.config_creator.features.schema_builder.client.ui

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import dev.inmo.config_creator.features.schema.common.models.MapSchemaItem
import dev.inmo.config_creator.features.schema.common.models.Schema
import dev.inmo.config_creator.features.schema.common.models.StringSchemaItem
import dev.inmo.config_creator.features.schema_builder.client.ui.schema.SchemaDrawer
import kotlinx.browser.document
import org.jetbrains.compose.web.renderComposable

fun main() {
    renderComposable("root") {
        val schemaState = remember { mutableStateOf<Schema>(Schema(MapSchemaItem(emptyMap(), emptySet()))) }
        SchemaDrawer(schemaState.value) {
            schemaState.value = it
        }
    }
}

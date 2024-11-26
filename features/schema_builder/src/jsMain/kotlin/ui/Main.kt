package dev.inmo.config_creator.features.schema_builder.client.ui

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import dev.inmo.config_creator.features.schema.common.models.MapSchemaItem
import dev.inmo.config_creator.features.schema.common.models.Schema
import dev.inmo.config_creator.features.schema.common.models.StringSchemaItem
import dev.inmo.config_creator.features.schema_builder.client.ui.schema.SchemaDrawer
import dev.inmo.config_creator.features.schema_builder.client.ui.schema.SchemaDrawerStyleSheet
import dev.inmo.micro_utils.common.*
import dev.inmo.micro_utils.coroutines.compose.enableStyleSheetsAggregator
import dev.inmo.micro_utils.mime_types.KnownMimeTypes
import dev.inmo.micro_utils.mime_types.MimeType
import kotlinx.browser.document
import kotlinx.browser.window
import org.jetbrains.compose.web.renderComposable
import org.w3c.dom.mediasource.MediaSource
import org.w3c.dom.url.URL
import org.w3c.files.Blob

fun main() {
    renderComposable("root") {
        enableStyleSheetsAggregator(setOf(SchemaDrawerStyleSheet))
        val schemaState = remember { mutableStateOf<Schema>(Schema(MapSchemaItem(emptyList(), emptySet()))) }
        SchemaDrawer(
            schemaState.value,
            {
                val json = it.serializeToString()
                triggerDownloadFile(
                    filename = "schema.json",
                    fileLink = URL.createObjectURL(Blob(arrayOf(json)))
                )
            },
            {
                selectFile({
                    it.accept = KnownMimeTypes.Application.Json.raw
                }) {
                    it.readBytesPromise().then {
                        schemaState.value = Schema.deserializeFromString(it.decodeToString())
                    }
                }
            }
        ) {
            schemaState.value = it
        }
    }
}

package dev.inmo.config_creator.features.json_builder.client.ui

import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import dev.inmo.config_creator.features.common.client.ui.StandardButton
import dev.inmo.config_creator.features.common.client.ui.StandardElementsStyleSheet
import dev.inmo.config_creator.features.common.client.ui.stylesheet.ResetStyles
import dev.inmo.config_creator.features.json_builder.client.ui.schema.JsonDrawer
import dev.inmo.config_creator.features.json_builder.client.utils.createDefaultNew
import dev.inmo.config_creator.features.schema.common.models.*
import dev.inmo.micro_utils.common.*
import dev.inmo.micro_utils.coroutines.compose.enableStyleSheetsAggregator
import dev.inmo.micro_utils.mime_types.KnownMimeTypes
import kotlinx.serialization.json.*
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.renderComposable
import org.w3c.dom.url.URL
import org.w3c.files.Blob

fun main() {
    renderComposable("root") {
        enableStyleSheetsAggregator(setOf(StandardElementsStyleSheet, ResetStyles))
        val schemaState = remember { mutableStateOf<Schema?>(null) }
        val jsonState = remember {
            mutableStateOf(
                schemaState.value ?.rootItem ?.createDefaultNew()
            )
        }
        StandardButton("Load schema") {
            selectFile({
                it.accept = KnownMimeTypes.Application.Json.raw
            }) {
                it.readBytesPromise().then {
                    val newSchema = Schema.deserializeFromString(it.decodeToString())
                    schemaState.value = newSchema
                    jsonState.value = newSchema.rootItem.createDefaultNew()
                }
            }
        }
        jsonState.value ?.let {
            JsonDrawer(
                schemaState.value,
                it,
                {
                    val json = Json.encodeToString(JsonElement.serializer(), it)
                    triggerDownloadFile(
                        filename = "config.json",
                        fileLink = URL.createObjectURL(Blob(arrayOf(json)))
                    )
                },
                {
                    selectFile({
                        it.accept = KnownMimeTypes.Application.Json.raw
                    }) {
                        it.readBytesPromise().then {
                            jsonState.value = Json.decodeFromString(JsonElement.serializer(), it.decodeToString())
                        }
                    }
                }
            ) {
                jsonState.value = it
            }
        }
    }
}

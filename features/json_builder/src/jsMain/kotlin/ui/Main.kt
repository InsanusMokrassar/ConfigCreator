package dev.inmo.config_creator.features.json_builder.client.ui

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import dev.inmo.config_creator.features.common.client.ui.StandardElementsStyleSheet
import dev.inmo.config_creator.features.json_builder.client.ui.schema.JsonDrawer
import dev.inmo.config_creator.features.schema.common.models.*
import dev.inmo.micro_utils.common.*
import dev.inmo.micro_utils.coroutines.compose.enableStyleSheetsAggregator
import dev.inmo.micro_utils.mime_types.KnownMimeTypes
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import org.jetbrains.compose.web.renderComposable
import org.w3c.dom.url.URL
import org.w3c.files.Blob

fun main() {
    renderComposable("root") {
        enableStyleSheetsAggregator(setOf(StandardElementsStyleSheet))
        val schemaState = remember { mutableStateOf<Schema?>(null) }
        val jsonState = remember {
            mutableStateOf(
                when (val rootItem = schemaState.value ?.rootItem) {
                    is ArraySchemaItem -> JsonArray(emptyList())
                    null,
                    is MapSchemaItem -> JsonObject(emptyMap())
                    is BooleanSchemaItem -> JsonPrimitive(false)
                    is NumberSchemaItem.WithFloatingPoint -> JsonPrimitive(rootItem.min ?: 0.0)
                    is NumberSchemaItem.WithoutFloatingPoint -> JsonPrimitive(rootItem.min ?: 0.0)
                    is StringSchemaItem -> JsonPrimitive("")
                }
            )
        }
        JsonDrawer(
            schemaState.value,
            jsonState.value,
            {
//                val json = it.serializeToString()
//                triggerDownloadFile(
//                    filename = "schema.json",
//                    fileLink = URL.createObjectURL(Blob(arrayOf(json)))
//                )
            },
            {
//                selectFile({
//                    it.accept = KnownMimeTypes.Application.Json.raw
//                }) {
//                    it.readBytesPromise().then {
//                        schemaState.value = Schema.deserializeFromString(it.decodeToString())
//                    }
//                }
            }
        ) {
            jsonState.value = it
        }
    }
}

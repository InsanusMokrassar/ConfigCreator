import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import dev.inmo.config_creator.features.common.client.ui.StandardButton
import dev.inmo.config_creator.features.common.client.ui.stylesheet.ResetStyles
import dev.inmo.config_creator.features.json_builder.client.ui.schema.JsonDrawer
import dev.inmo.config_creator.features.json_builder.client.utils.createDefaultNew
import dev.inmo.config_creator.features.json_builder.client.utils.toStructureItem
import dev.inmo.config_creator.features.schema.common.models.MapSchemaItem
import dev.inmo.config_creator.features.schema.common.models.Schema
import dev.inmo.config_creator.features.schema.common.models.plus
import dev.inmo.config_creator.features.schema_builder.client.ui.schema.SchemaDrawer
import dev.inmo.micro_utils.common.compose.tagClasses
import dev.inmo.micro_utils.common.readBytesPromise
import dev.inmo.micro_utils.common.selectFile
import dev.inmo.micro_utils.common.triggerDownloadFile
import dev.inmo.micro_utils.coroutines.compose.enableStyleSheetsAggregator
import dev.inmo.micro_utils.coroutines.compose.includeInStyleSheetsAggregator
import dev.inmo.micro_utils.mime_types.KnownMimeTypes
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.renderComposable
import org.w3c.dom.url.URL
import org.w3c.files.Blob

private object BuilderStyleSheet : StyleSheet() {
    val container by style {
        display(DisplayStyle.Grid)
        position(Position.Absolute)
        left(0.px)
        top(0.px)
        right(0.px)
        bottom(0.px)
        gridTemplateColumns("1fr auto 1fr")
        overflow("hidden")
    }
    @OptIn(ExperimentalComposeWebApi::class)
    val side by style {
        display(DisplayStyle.Flex)
        alignItems(AlignItems.Center)
        justifyContent(JustifyContent.Center)
        transform {
            this.scale(1, 1)
        }
        (self + hover) style {
            cursor("pointer")
            backgroundColor(Color("#7a757f10"))
            transform {
                this.scale(1.1, 1.1)
            }
        }
        transitions {
            this.properties("background-color", "transform") {
                this.timingFunction = AnimationTimingFunction.EaseIn
                this.duration = 130.ms
            }
        }
    }
    val divider by style {
        width(64.px)
    }

    init {
        includeInStyleSheetsAggregator()
    }
}

suspend fun main() {
    renderComposable("root") {
        enableStyleSheetsAggregator(setOf(ResetStyles))
        val showSchemaBuilder = remember { mutableStateOf<Boolean?>(null) }

        val showSchemaBuilderValue = showSchemaBuilder.value

        if (showSchemaBuilderValue != null) {
            Div {
                StandardButton("Back") {
                    showSchemaBuilder.value = null
                }
            }
            if (showSchemaBuilderValue) {
                val schemaState = remember { mutableStateOf<Schema>(Schema(MapSchemaItem(emptyList()))) }
                SchemaDrawer(
                    schema = schemaState.value,
                    onSaveSchema = {
                        val json = it.serializeToString()
                        triggerDownloadFile(
                            filename = "schema.json",
                            fileLink = URL.createObjectURL(Blob(arrayOf(json)))
                        )
                    },
                    onAddSchema = {
                        selectFile({
                            it.accept = KnownMimeTypes.Application.Json.raw
                        }) {
                            it.readBytesPromise().then {
                                schemaState.value += Schema.deserializeFromString(it.decodeToString())
                            }
                        }
                    }
                ) {
                    schemaState.value = it
                }
            } else {
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
                            val json = Json { prettyPrint = true }.encodeToString(JsonElement.serializer(), it)
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
                                    jsonState.value = Json.decodeFromString(JsonElement.serializer(), it.decodeToString()).toStructureItem()
                                }
                            }
                        }
                    ) {
                        jsonState.value = it
                    }
                }
            }
        } else {
            Div(tagClasses((BuilderStyleSheet.container))) {
                Div({
                    classes(BuilderStyleSheet.side)
                    onClick {
                        showSchemaBuilder.value = true
                    }
                }) {
                    Text("Schema builder")
                }
                Div(tagClasses(BuilderStyleSheet.divider))
                Div({
                    classes(BuilderStyleSheet.side)
                    onClick {
                        showSchemaBuilder.value = false
                    }
                }) {
                    Text("Json builder")
                }
            }
        }
    }
}
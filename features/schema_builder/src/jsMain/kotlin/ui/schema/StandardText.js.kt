package dev.inmo.config_creator.features.schema_builder.client.ui.schema

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.Text

@Composable
actual fun StandardText(text: String) {
    Text(text)
}
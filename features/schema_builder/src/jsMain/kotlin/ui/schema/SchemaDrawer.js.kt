package dev.inmo.config_creator.features.schema_builder.client.ui.schema

import androidx.compose.runtime.Composable
import dev.inmo.config_creator.features.schema_builder.client.ui.schema.stylesheet.BooleanStyleSheet
import dev.inmo.config_creator.features.schema_builder.client.ui.schema.stylesheet.InputStyleSheet
import dev.inmo.config_creator.features.schema_builder.client.ui.schema.stylesheet.ResetStyles
import dev.inmo.config_creator.features.schema_builder.client.ui.schema.stylesheet.SelectStyleSheet
import org.jetbrains.compose.web.css.Style

@Composable
actual fun BeforeSchemaDrawer() {
    Style(ResetStyles)
    Style(SchemaDrawerStyleSheet)
    Style(SelectStyleSheet)
    Style(InputStyleSheet)
    Style(BooleanStyleSheet)
}
package dev.inmo.config_creator.features.schema_builder.client.ui.schema

import androidx.compose.runtime.Composable
import dev.inmo.config_creator.features.schema.common.models.BooleanSchemaItem
import dev.inmo.config_creator.features.schema.common.models.StringSchemaItem

@Composable
expect fun StandardBooleanDrawer(
    item: Boolean,
    onChange: (Boolean) -> Unit
)

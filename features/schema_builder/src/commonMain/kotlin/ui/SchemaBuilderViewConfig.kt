package dev.inmo.config_creator.features.schema_builder.client.ui

import dev.inmo.config_creator.features.schema.common.models.Schema
import kotlinx.serialization.Serializable

@Serializable
data class SchemaBuilderViewConfig(
    val initialSchema: Schema
)

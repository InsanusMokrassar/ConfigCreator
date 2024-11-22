package dev.inmo.config_creator.features.schema.common.models

import dev.inmo.config_creator.features.schema.common.utils.RegexSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
data object BooleanSchemaItem: SchemaItem.Primitive, SchemaItem.Primitive.Type {
    @Transient
    override val typeInfo: BooleanSchemaItem
        get() = this
}

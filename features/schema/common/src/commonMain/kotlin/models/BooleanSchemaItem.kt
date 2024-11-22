package dev.inmo.config_creator.features.schema.common.models

import dev.inmo.config_creator.features.schema.common.utils.RegexSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
data class BooleanSchemaItem(
    val default: Boolean? = null
): SchemaItem.Primitive {
    @Transient
    override val typeInfo: Companion
        get() = Companion

    companion object : SchemaItem.Primitive.Type {
        override fun createDefault(): SchemaItem = BooleanSchemaItem()
    }
}

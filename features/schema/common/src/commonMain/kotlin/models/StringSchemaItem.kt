package dev.inmo.config_creator.features.schema.common.models

import dev.inmo.config_creator.features.schema.common.utils.RegexSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
@SerialName("string")
data class StringSchemaItem(
    @Serializable(RegexSerializer::class)
    val regex: Regex? = null,
    val minSymbols: Int? = null,
    val maxSymbols: Int? = null
) : SchemaItem.Primitive {
    @Transient
    override val typeInfo: Companion
        get() = Companion
    companion object : SchemaItem.Primitive.Type {
        override fun createDefault(): StringSchemaItem {
            return StringSchemaItem()
        }
    }
}

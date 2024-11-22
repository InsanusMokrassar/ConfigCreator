package dev.inmo.config_creator.features.schema.common.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
sealed interface NumberSchemaItem<T : Any> : SchemaItem {
    val min: T?
    val max: T?
    override val typeInfo: Type

    sealed interface Type : SchemaItem.Primitive.Type

    @Serializable
    @SerialName("double")
    data class WithFloatingPoint(
        override val min: Double? = null,
        override val max: Double? = null,
    ) : NumberSchemaItem<Double> {
        @Transient
        override val typeInfo: Companion
            get() = Companion
        companion object : Type
}

    @Serializable
    @SerialName("long")
    data class WithoutFloatingPoint(
        override val min: Long? = null,
        override val max: Long? = null,
    ) : NumberSchemaItem<Long> {
        @Transient
        override val typeInfo: Companion
            get() = Companion
        companion object : Type
    }
}

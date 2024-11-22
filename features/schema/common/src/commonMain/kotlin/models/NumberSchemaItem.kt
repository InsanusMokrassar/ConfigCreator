package dev.inmo.config_creator.features.schema.common.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
sealed interface NumberSchemaItem<T : Any> : SchemaItem {
    val min: T?
    val max: T?

    @Serializable
    @SerialName("double")
    data class WithFloatingPoint(
        override val min: Double? = null,
        override val max: Double? = null,
    ) : NumberSchemaItem<Double>

    @Serializable
    @SerialName("long")
    data class WithoutFloatingPoint(
        override val min: Long? = null,
        override val max: Long? = null,
    ) : NumberSchemaItem<Long>
}

package dev.inmo.config_creator.features.schema.common.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
sealed interface NumberSchemaItem<T : Any> : SchemaItem.Primitive {
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
        
        @Serializable
        sealed interface Error : SchemaItem.Error {
            data class ValueExceedsItsBounds(
                val item: WithFloatingPoint,
                val value: Double
            ) : Error
        }

        companion object : Type {
            override fun createDefault(): WithFloatingPoint = WithFloatingPoint()
        }
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
        
        @Serializable
        sealed interface Error : SchemaItem.Error {
            data class ValueExceedsItsBounds(
                val item: WithoutFloatingPoint,
                val value: Long
            ) : Error
        }

        companion object : Type {
            override fun createDefault(): WithoutFloatingPoint = WithoutFloatingPoint()
        }
    }
}

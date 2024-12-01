package dev.inmo.config_creator.features.schema.common.utils

import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

object RegexSerializer : KSerializer<Regex> {
    override val descriptor: SerialDescriptor
        get() = String.serializer().descriptor

    override fun deserialize(decoder: Decoder): Regex {
        return Regex(decoder.decodeString())
    }

    override fun serialize(encoder: Encoder, value: Regex) {
        encoder.encodeString(
            value.pattern
        )
    }
}


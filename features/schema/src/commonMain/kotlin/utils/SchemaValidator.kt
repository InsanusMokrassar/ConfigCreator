package dev.inmo.config_creator.features.schema.common.utils

import dev.inmo.config_creator.features.schema.common.models.*
import kotlinx.serialization.json.*

class SchemaValidator {
    val JsonElement.schemaItemType: SchemaItem.SchemaItemType?
        get() = when (this) {
            is JsonArray -> ArraySchemaItem.Companion
            is JsonObject -> MapSchemaItem.Companion
            is JsonPrimitive -> {
                when {
                    this.isString -> StringSchemaItem.Companion
                    this.longOrNull != null -> NumberSchemaItem.WithoutFloatingPoint.Companion
                    this.doubleOrNull != null -> NumberSchemaItem.WithFloatingPoint.Companion
                    this.booleanOrNull != null -> BooleanSchemaItem.Companion
                    else -> null
                }
            }
            JsonNull -> null
        }

    fun validate(json: JsonElement, schemaItem: SchemaItem, path: String): List<Pair<String, SchemaItem.Error>> {
        val errors = mutableListOf<Pair<String, SchemaItem.Error>>()
        if (json.schemaItemType != schemaItem.typeInfo) {
            path to SchemaItem.Error.WrongTypeOfItem(
                schemaItem.typeInfo,
                json.schemaItemType
            )
        }
        when (schemaItem) {
            is ArraySchemaItem -> {
                (json as? JsonArray) ?.let {
                    when {
                        (schemaItem.maxItems != null && json.size > schemaItem.maxItems)
                                || schemaItem.minItems != null && json.size < schemaItem.minItems -> {
                            errors.add(
                                path to ArraySchemaItem.Error.SizeExceedsBounds(
                                    schemaItem,
                                    json.size
                                )
                            )
                        }
                    }
                    json.forEachIndexed { i, jsonElement ->
                        errors.addAll(
                            validate(jsonElement, schemaItem.itemsType, "$path$i/")
                        )
                    }
                }
            }
            is MapSchemaItem -> {
                (json as? JsonObject) ?.let {
                    schemaItem.items.forEach {
                        val value = json[it.fieldTitle]
                        when {
                            value == null && it.isRequired -> {
                                errors.add(
                                    path to MapSchemaItem.Error.RequiredFieldAbsent(
                                        schemaItem,
                                        it
                                    )
                                )
                                return@forEach
                            }
                        }
                        if (value == null) {
                            return@forEach
                        }
                        errors.addAll(
                            validate(value, it.item, "${path}${it.fieldTitle}/")
                        )
                    }
                }
            }
            is BooleanSchemaItem -> (json as? JsonPrimitive) ?.booleanOrNull ?.let {
                // do nothing for now
            }
            is NumberSchemaItem.WithFloatingPoint -> (json as? JsonPrimitive) ?.let {
                val asDouble = (it.doubleOrNull ?: it.long).toDouble()

                when {
                    (schemaItem.max != null && asDouble > schemaItem.max)
                    || (schemaItem.min != null && asDouble < schemaItem.min) -> {
                        errors.add(
                            path to NumberSchemaItem.WithFloatingPoint.Error.ValueExceedsItsBounds(
                                schemaItem,
                                asDouble
                            )
                        )
                    }
                }

                Unit
            }
            is NumberSchemaItem.WithoutFloatingPoint -> (json as? JsonPrimitive) ?.let {
                val asLong = it.long

                when {
                    (schemaItem.max != null && asLong > schemaItem.max)
                            || (schemaItem.min != null && asLong < schemaItem.min) -> {
                        errors.add(
                            path to NumberSchemaItem.WithoutFloatingPoint.Error.ValueExceedsItsBounds(
                                schemaItem,
                                asLong
                            )
                        )
                    }
                }

                Unit
            }
            is StringSchemaItem -> (json as? JsonPrimitive) ?.let {
                val asString = it.content

                when {
                    schemaItem.regex != null && schemaItem.regex.matches(asString) -> errors.add(
                        path to StringSchemaItem.Error.RegexDoNotMatch(
                            schemaItem,
                            asString
                        )
                    )
                    (schemaItem.maxSymbols != null && schemaItem.maxSymbols < asString.length)
                    || (schemaItem.maxSymbols != null && schemaItem.maxSymbols < asString.length) -> errors.add(
                        path to StringSchemaItem.Error.StringLengthExceedsItsBounds(
                            schemaItem,
                            asString
                        )
                    )
                }

                Unit
            }
        }

        return errors
    }
    fun validate(json: JsonElement, schema: Schema): List<Pair<String, SchemaItem.Error>> {
        return validate(json, schema.rootItem, "/")
    }
}
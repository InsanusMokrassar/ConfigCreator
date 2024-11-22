// THIS CODE HAVE BEEN GENERATED AUTOMATICALLY
// TO REGENERATE IT JUST DELETE FILE
// ORIGINAL FILE: SchemaItem.kt
package dev.inmo.config_creator.features.schema.common.models

import kotlin.collections.Set

private val values: Set<SchemaItem.SchemaItemType> = setOf(ArraySchemaItem.Companion,
    BooleanSchemaItem,
    MapSchemaItem.Companion,
    NumberSchemaItem.WithFloatingPoint.Companion,
    NumberSchemaItem.WithoutFloatingPoint.Companion,
    StringSchemaItem.Companion)

public fun SchemaItem.SchemaItemType.Companion.values(): Set<SchemaItem.SchemaItemType> = values

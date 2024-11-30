package dev.inmo.config_creator.features.json_builder.client.utils

import dev.inmo.config_creator.features.schema.common.models.*

fun SchemaItem.createDefaultNew(): Any = when (this) {
    is ArraySchemaItem -> {
        val mutableList = mutableListOf<Any>()
        minItems ?.let {
            while (mutableList.size < it) {
                mutableList.add(
                    itemsType.createDefaultNew()
                )
            }
        }
        mutableList.toList()
    }
    is MapSchemaItem -> {
        val mutableMap = mutableMapOf<String, Any?>()
        items.forEach {
            if (it.isRequired) {
                mutableMap[it.fieldTitle] = it.item.createDefaultNew()
            }
        }
        mutableMap.toMap()
    }
    is BooleanSchemaItem -> {
        false
    }
    is NumberSchemaItem.WithFloatingPoint -> {
        min ?: max ?: 0.0
    }
    is NumberSchemaItem.WithoutFloatingPoint -> {
        min ?: max ?: 0
    }
    is StringSchemaItem -> {
        ""
    }
}
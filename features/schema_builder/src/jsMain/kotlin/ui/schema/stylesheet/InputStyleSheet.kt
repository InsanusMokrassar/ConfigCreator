package dev.inmo.config_creator.features.schema_builder.client.ui.schema.stylesheet

import org.jetbrains.compose.web.css.*

object InputStyleSheet : StyleSheet() {

    init {
        "input::-webkit-outer-spin-button, input::-webkit-inner-spin-button" style {
            property("-webkit-appearance", "none")
            margin(0.px)
        }
        "input[type=number]" style {
            property("-moz-appearance", "textfield")
        }
    }
    val textInput by style {
        minWidth(256.px)
        padding(12.px)
        fontSize(1.15.em)
        outline("none")
        backgroundColor(Color.black)
        borderRadius(0.5.em)
        border {
            style(LineStyle.Solid)
            color(Color.black)
            height(2.px)
        }
        color(Color.white)
        property("transition", "all 0.5s")
        hover style {
            border {
                style(LineStyle.Solid)
                color(rgba(0, 0, 0, .5))
                height(2.px)
            }
        }
        focus style {
            border {
                style(LineStyle.Solid)
                color(rgba(0, 0, 0, .5))
                height(2.px)
            }
            backgroundColor(Color.darkslategray)
        }
    }
}
package dev.inmo.config_creator.features.common.common

import dev.inmo.micro_utils.startup.plugin.createStartupPluginAndRegister

@ExperimentalStdlibApi
@EagerInitialization
@JsExport
@ExperimentalJsExport
private val jsModuleLoader = createStartupPluginAndRegister("{{\$1}}.CommonJSPlugin") { CommonJSPlugin }
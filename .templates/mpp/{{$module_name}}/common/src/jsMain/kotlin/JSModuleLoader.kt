package {{$root_package_group}}.{{$root_package_name}}.{{$module_package}}.common

import dev.inmo.micro_utils.startup.plugin.createStartupPluginAndRegister

@ExperimentalStdlibApi
@EagerInitialization
@JsExport
@ExperimentalJsExport
private val jsModuleLoader = createStartupPluginAndRegister("{{\$1}}.CommonJSPlugin") { CommonJSPlugin }

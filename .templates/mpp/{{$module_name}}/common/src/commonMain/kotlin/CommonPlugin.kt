package {{$root_package_group}}.{{$root_package_name}}.{{$module_package}}.common

import dev.inmo.micro_utils.startup.plugin.StartPlugin
import kotlinx.serialization.json.JsonObject
import org.koin.core.module.Module

object CommonPlugin : StartPlugin {
    override fun Module.setupDI(config: JsonObject) {

    }
}

package {{$root_package_group}}.{{$root_package_name}}.{{$module_package}}.client

import {{$root_package_group}}.{{$root_package_name}}.{{$module_package}}.common.CommonJVMPlugin
import {{$root_package_group}}.{{$root_package_name}}.{{$module_package}}.common.CommonJVMPlugin.setupDI
import dev.inmo.micro_utils.startup.plugin.StartPlugin
import kotlinx.serialization.json.JsonObject
import org.koin.core.Koin
import org.koin.core.module.Module

object ClientJVMPlugin : StartPlugin {
    override fun Module.setupDI(config: JsonObject) {
        with(CommonJVMPlugin) { setupDI(config) }
        with(ClientPlugin) { setupDI(config) }
    }

    override suspend fun startPlugin(koin: Koin) {
        super.startPlugin(koin)
        CommonJVMPlugin.startPlugin(koin)
        ClientPlugin.startPlugin(koin)
    }
}

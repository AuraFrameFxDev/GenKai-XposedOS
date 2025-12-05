package collabcanvas

import com.highcapable.yukihookapi.annotation.xposed.InjectYukiHookWithXposed
import com.highcapable.yukihookapi.hook.factory.configs
import com.highcapable.yukihookapi.hook.factory.encase
import com.highcapable.yukihookapi.hook.xposed.proxy.IYukiHookXposedInit

@InjectYukiHookWithXposed
class HookEntry : IYukiHookXposedInit {

    override fun onInit() = configs {
        com.highcapable.yukihookapi.YukiHookAPI.Configs.isDebug = true // Enable debug logs
    }

    override fun onHook() = encase {
        // Load App Hooks
        loadApp(name = "com.android.systemui") {
            // Future SystemUI hooks will go here
        }
    }
}

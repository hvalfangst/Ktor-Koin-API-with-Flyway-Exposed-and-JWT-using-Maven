import common.config.AppConfig
import common.config.AuthConfig
import common.config.RouteConfig
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    val appConfig = AppConfig()
    val authConfig = AuthConfig()
    val routeConfig = RouteConfig()

    appConfig.configure(this)
    authConfig.configure(this)
    routeConfig.configure(this)
}


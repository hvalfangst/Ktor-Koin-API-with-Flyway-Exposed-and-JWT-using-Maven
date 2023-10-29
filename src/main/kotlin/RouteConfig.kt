import common.config.initializeAppConfigSingleton
import common.security.JwtUtil
import io.ktor.server.application.*
import io.ktor.server.routing.*
import repositories.AbilityRepository
import repositories.HeroRepository
import repositories.UserRepository
import routes.abilitiesRoute
import routes.heroesRoute
import routes.usersRoute
import services.AbilityService
import services.HeroService
import services.UserService

class RouteConfig {
    fun configure(application: Application) {
        val jwtUtil = JwtUtil(initializeAppConfigSingleton(application.environment))

        application.install(Routing) {
            usersRoute(jwtUtil, UserService(UserRepository()))
            heroesRoute(HeroService(HeroRepository()))
            abilitiesRoute(AbilityService(AbilityRepository()))
        }
    }
}

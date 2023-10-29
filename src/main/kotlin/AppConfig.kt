import common.config.initializeAppConfigSingleton
import common.db.DatabaseManager
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*

class AppConfig {
    fun configure(application: Application) {
        // Initialize singleton for accessing environment variables derived from 'application.yml'
        val configSingleton = initializeAppConfigSingleton(application.environment)

        // Connect to the database and run Flyway migrations
        DatabaseManager.connectAndMigrate(configSingleton)

        // Configure content negotiation to handle JSON
        application.install(ContentNegotiation) {
            json()
        }
    }
}

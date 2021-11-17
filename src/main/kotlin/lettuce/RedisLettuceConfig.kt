package lettuce

import io.lettuce.core.ExperimentalLettuceCoroutinesApi
import io.lettuce.core.RedisClient
import io.lettuce.core.RedisURI
import io.lettuce.core.api.StatefulRedisConnection
import io.lettuce.core.api.coroutines
import io.lettuce.core.api.coroutines.RedisCoroutinesCommands


object RedisLettuceConfig {

    @OptIn(ExperimentalLettuceCoroutinesApi::class)
    fun api(): RedisCoroutinesCommands<String, String> {
        val redisHost = "127.0.0.1"
        val redisPort = 6379
        val redisPwd: String? = null
        val uriBuilder = RedisURI.Builder.redis(redisHost, redisPort)
        if (redisPwd != null) {
            uriBuilder.withPassword(redisPwd as CharSequence)
        }
        val redisURI = uriBuilder.build()
//        log.debug("[Standalone Mode] connecting to redis: {}", redisURI)
        val redisClient = RedisClient.create(redisURI)

        val connection: StatefulRedisConnection<String, String> = redisClient.connect()
        return connection.coroutines()
    }
}
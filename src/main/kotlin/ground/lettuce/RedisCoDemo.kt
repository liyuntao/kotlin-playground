package ground.lettuce

import io.lettuce.core.api.coroutines.RedisSetCoroutinesCommands
import ground.lettuce.RedisLettuceConfig.api

suspend fun main(args: Array<String>) {
    val redisApi = api()
    val redisSetApi = redisApi as RedisSetCoroutinesCommands<String, String>
//    redisApi.set("test-key", "OK")
//    redisApi.set("test-key2", "NOT OK")
//    println(redisApi.get("test-key"))
//    println(redisApi.keys("test-*"))

    redisSetApi.sadd("whitelist", "1231231")
    redisSetApi.sadd("whitelist", "17457")
    redisSetApi.sadd("whitelist", "1581412412")

    redisApi.sismember("whitelist", "17457").let {
        println("sismember $it")
    }
}
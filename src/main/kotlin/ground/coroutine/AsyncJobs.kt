package ground.coroutine

import kotlinx.coroutines.*

suspend fun main() {
    println("starting...")

    val start = System.currentTimeMillis()

    // Start a coroutine
    val job = GlobalScope.launch {
        val a1 = async { jobTask1() }
        val a2 = async { jobTask2() }
        println("${a1.await() + a2.await()}")
    }
    job.join()
    val end = System.currentTimeMillis()
    println("App Stop ${end-start}ms")
}

suspend fun jobTask1(): Int {
    delay(7000)
    println("jobTask1 done")
    return 2
}

suspend fun jobTask2(): Int {
    delay(3000)
    println("jobTask2 done")
    return 7
}
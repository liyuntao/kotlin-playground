package lv0

object Idioms {

    @JvmStatic
    fun main(args: Array<String>) {
        // lazy variable
        val p: String by lazy {
            // compute the string
            Thread.sleep(2000)
            "ok"
        }
        println("started")
        println(p)
        println(p)

        // if not null
        val files: Array<String>? = null
        println("---")
        println(files?.size)
        println("---")

        // Execute if not
        val data = null
        data?.let {
            println("")
        }

        // Single-expression functions


    }
}

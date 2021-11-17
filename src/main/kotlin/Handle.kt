import java.io.File

fun main() {
    val regex = """put\("(.+)", "(.+)"\);""".toRegex()
    val lines: List<String> = File("./brokerList.txt").readLines()

    val map = linkedMapOf<String, String>()
    lines.forEach() {
        val matchResult = regex.find(it)
        val (name, short) = matchResult!!.destructured
//        println("$name  $short")
        map[name] = short
    }

    println(lines.size)
    println(map.size)
    map.forEach { t, u ->  println("""put("$t", "$u");""") }
}
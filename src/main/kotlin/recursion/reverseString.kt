package recursion

fun main() {
    println(reverseString("s"))
}

fun reverseString(s: String): String {
    return if(s.length <= 1)
        s
    else
        s[s.length-1].toString() + s.subSequence(0, s.length-1)
}
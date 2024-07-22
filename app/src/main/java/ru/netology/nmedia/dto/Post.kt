package ru.netology.nmedia.dto

data class Post(
    val id: Int,
    val author: String,
    val authorAvatar: String,
    val published: String,
    val content: String,
    var likes: Int = 0,
    var likedByMe: Boolean = false,
    var share: Int = 0,
    var toShare: Boolean = false
)

fun reformat(i: Int): String {
    val a = i / 1000
    val b = i / 100 % 10
    val c = i / 1000000
    val d = i / 100000 % 10
    var result = ""
    when {
        i <= 999 -> result = i.toString()
        a in 1..9 && b == 0 -> result = "${a}K"
        b in 1..9 && i < 10000 -> result = "${a}.${b}K"
        b in 0..9 && i in 10000..999999 -> result = "${a}K"
        i >= 1000000 && d in 0..9 -> result = "${c}M"
        c <= 1 && d in 1..9 -> result = "${c}.${d}M"
    }
    return result
}

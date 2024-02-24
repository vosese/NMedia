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
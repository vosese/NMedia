package ru.netology.nmedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import ru.netology.nmedia.databinding.ActivityMainBinding
import ru.netology.nmedia.dto.Post

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val post = Post(
            id = 1,
            author = "Нетология. Университет интернет-профессий будущего.",
            authorAvatar = "@sample/posts_avatars",
            published = "21 мая в 18:36",
            content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дезайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое вжное остаётся с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть бельше. целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать цепочку перемен → http://netolo.gy/fyb",
            likes = 999,
            share = 999
        )

        with(binding) {
            authorTextView.text = post.author
            publishedTextView.text = post.published
            contentTextView.text = post.content
            likeTextView.text = post.likes.toString()
            shareTextView.text = post.share.toString()
            if (post.likedByMe) {
                likeButton.setImageResource(R.drawable.red_heart)
            }
            likeButton.setOnClickListener {
                if (post.likedByMe) post.likes-- else post.likes++
                post.likedByMe = !post.likedByMe
                likeButton.setImageResource(if (post.likedByMe) R.drawable.red_heart else R.drawable.baseline_favorite_border_24)
                likeTextView.text = post.likes.toString()
            }

            if (post.toShare) {
                shareButton.setImageResource(R.drawable.baseline_share_24)
            }
            shareButton.setOnClickListener {
                if (post.toShare) post.share-- else post.share++
                shareTextView.text = post.share.toString()

            }
        }
    }
}
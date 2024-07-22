package ru.netology.nmedia

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ru.netology.nmedia.databinding.ActivityMainBinding
import ru.netology.nmedia.dto.Post
import ru.netology.nmedia.dto.reformat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

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
            textAuthor.text = post.author
            published.text = post.published
            content.text = post.content
            likeTextView.text = "${post.likes}"
            shareTextView.text = "${post.share}"
            if (post.likedByMe) {
                likeButton.setImageResource(R.drawable.red_heart_24)
            }
            likeButton.setOnClickListener {
                if (post.likedByMe) post.likes-- else post.likes++
                post.likedByMe = !post.likedByMe
                likeButton.setImageResource(if (post.likedByMe) R.drawable.red_heart_24 else R.drawable.baseline_favorite_border_24)
                likeTextView.text = reformat(post.likes)
            }
            shareButton.setOnClickListener {
                if (post.toShare) post.share-- else post.share++
                shareTextView.text = reformat(post.share)
            }


        }


    }
}
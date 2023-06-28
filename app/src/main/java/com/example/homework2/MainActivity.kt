package com.example.homework2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.animation.Animation
import android.view.animation.DecelerateInterpolator
import android.view.animation.RotateAnimation
import androidx.core.view.setPadding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.homework2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    var startPoint = 0f
    var endPoint = 0f


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.startButton.setOnClickListener{
            val angle = (720..1080).random().toFloat()
            endPoint = angle + startPoint
            val animation = RotateAnimation(
                startPoint,
                endPoint,
                Animation.RELATIVE_TO_SELF,
                0.5f,Animation.RELATIVE_TO_SELF, 0.5f)
            animation.interpolator = DecelerateInterpolator()
            animation.repeatCount = 0
            animation.duration= 2000
            animation.fillAfter = true

            binding.ivCircle.startAnimation(animation)
            Log.d("randomValue0000", "startPoint: $startPoint")
            startPoint = endPoint

            //counter = startPoint + (360..720).random().toFloat()

            Log.d("randomValue0000", "end: $endPoint")
            //val index = (360f- (endPoint % 360)) / (360f / 7)
            val index = (endPoint % 360) / (360f / 7)
            val result = utils.list[index.toInt()]
            //binding.tv1.text = utils.list[index.toInt()]


            val numofRows= endPoint % 360






            animation.setAnimationListener(object: Animation.AnimationListener{
                override fun onAnimationStart(p0: Animation?) {
                    binding.tvResultText.setPadding(0)
                    binding.ivResultImage.setImageDrawable(null)
                    binding.tvResultText.text = ""
                }

                override fun onAnimationEnd(animate: Animation?) {
                    when(result) {
                        "Красный" -> {
                            binding.ivResultImage.setImageDrawable(null)
                            binding.tvResultText.text = "Red text"
                            binding.tvResultText.setTextColor(Color.RED)
                            binding.tvResultText.setPadding(40)

                        }
                        "Фиолетовый" -> {
                            binding.ivResultImage.setImageDrawable(null)
                            binding.tvResultText.text = "Violet Text"
                            binding.tvResultText.setTextColor(Color.MAGENTA)
                            binding.tvResultText.setPadding(40)
                        }
                        "Синий" -> {
                            binding.tvResultText.text = ""

                            val url = "https://upload.wikimedia.org/wikipedia/commons/b/b8/Мыс_Лударь%2C_17_июня_2013_года.jpg"
                            Glide.with(this@MainActivity)
                                .load(url)
                                .fitCenter()
                                .skipMemoryCache(true)
                                .diskCacheStrategy(DiskCacheStrategy.NONE)
                                .into(binding.ivResultImage)
                        }
                        "Голубой" -> {
                            binding.ivResultImage.setImageDrawable(null)
                            binding.tvResultText.text = "Light Blue Text"
                            binding.tvResultText.setTextColor(Color.CYAN)
                            binding.tvResultText.setPadding(40)
                        }
                        "Зеленый" -> {
                            binding.tvResultText.text = ""
                            val url = "https://visit-saint-petersburg.ru/attachments/Image/bGya4QP57QQ_1.jpg?template=generic"
                            Glide.with(this@MainActivity)
                                .load(url)
                                .fitCenter()
                                .skipMemoryCache(true)
                                .diskCacheStrategy(DiskCacheStrategy.NONE)
                                .into(binding.ivResultImage)
                        }
                        "Желтый" -> {
                            binding.ivResultImage.setImageDrawable(null)
                            binding.tvResultText.text = "Yellow text"
                            binding.tvResultText.setTextColor(Color.YELLOW)
                            binding.tvResultText.setPadding(40)
                        }
                        "Оранжевый" -> {
                            val url = "https://img.freepik.com/free-photo/eye-of-mythological-dragon-on-fire-generative-ai_188544-12557.jpg?w=2000"
                            binding.tvResultText.text = ""
                            Glide.with(this@MainActivity)
                                .load(url)
                                .fitCenter()
                                .skipMemoryCache(true)
                                .diskCacheStrategy(DiskCacheStrategy.NONE)
                                .into(binding.ivResultImage)
                        }
                    }
                    Log.d("randomValue0000000", "animation has ended")
                }

                override fun onAnimationRepeat(p0: Animation?) {

                }

            })

        }
    }
}
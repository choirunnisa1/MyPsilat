package com.apps.mypsilat.elakan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.apps.mypsilat.ContentItem
import com.apps.mypsilat.ContentTeknikAdapter
import com.apps.mypsilat.R
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import kotlinx.android.synthetic.main.activity_kuda_belakang.*

class ElakanSampingActivity : AppCompatActivity() {

    private lateinit var contentTeknikAdapter: ContentTeknikAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_elakan_samping)
        setOnContentItems()
        setupIndicator()
        setCurrentIndicator(0)

        video_kuda_depan.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                val videoId = "Gl10h1lUHQA"
                youTubePlayer.loadVideo(videoId, 0f)
            }
        })

        back_button.setOnClickListener {
            onBackPressed()
        }

    }

    private fun setOnContentItems() {
        contentTeknikAdapter = ContentTeknikAdapter(
                listOf(
                        ContentItem(
                                R.drawable.elakan_samping_satu,
                                R.drawable.elakan_samping_dua,
                                "1",
                                "Sikap awal menggunakan kuda – kuda tengah"
                        ),
                        ContentItem(
                                R.drawable.elakan_samping_tiga,
                                null,
                                "2",
                                "Sikap tangan waspada (tangan berada di depan dada)"
                        ),
                        ContentItem(
                                R.drawable.elakan_samping_empat,
                                R.drawable.elakan_samping_lima,
                                "3",
                                "Saat mengelak pindahkan titik berat badan ke samping kanan atau kiri dari kuda – kuda tengah tanpa memindahkan letak telapak kaki"
                        ),
                        ContentItem(
                                R.drawable.elakan_samping_enam,
                                R.drawable.elakan_samping_tujuh,
                                "4",
                                "Sikap akhir kembali menggunakan kuda – kuda tengah dengan sikap tangan waspada"
                        )


                )


        )

        background_content.adapter = contentTeknikAdapter
        background_content.registerOnPageChangeCallback(object :
                ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (position > 0) {
                    imgLeft.visibility = View.VISIBLE
                } else {
                    imgLeft.visibility = View.INVISIBLE
                }
                if (position < contentTeknikAdapter.itemCount - 1) imgRight.visibility =
                        View.VISIBLE else imgRight.visibility = View.INVISIBLE
                setCurrentIndicator(position)
            }
        })
        (background_content.getChildAt(0) as RecyclerView).overScrollMode =
                RecyclerView.OVER_SCROLL_ALWAYS


        imgRight.setOnClickListener {
            Log.d("current", "item = ${background_content.currentItem}")
            Log.d("item", "adapter = ${contentTeknikAdapter.itemCount}")
            if (background_content.currentItem + 1 < contentTeknikAdapter.itemCount) {
                background_content.currentItem += 1
            }
        }

        imgLeft.setOnClickListener {
            if (background_content.currentItem < contentTeknikAdapter.itemCount) {
                background_content.currentItem -= 1
            }
        }

    }

    private fun setupIndicator() {
        val indicator = arrayOfNulls<ImageView>(contentTeknikAdapter.itemCount)
        val layoutParams: LinearLayout.LayoutParams =
                LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                )
        layoutParams.setMargins(8, 0, 8, 0)
        for (i in indicator.indices) {
            indicator[i] = ImageView(applicationContext)
            indicator[i]?.let {
                it.setImageDrawable(
                        ContextCompat.getDrawable(
                                applicationContext,
                                R.drawable.indicator_inactive
                        )
                )
                it.layoutParams = layoutParams
                indicatorContent.addView(it)

            }
        }
    }

    private fun setCurrentIndicator(position: Int) {

        val childCount = indicatorContent.childCount
        for (i in 0 until childCount) {
            val imageView = indicatorContent.getChildAt(i) as ImageView
            if (i == position) {
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(
                                applicationContext,
                                R.drawable.indicator_active
                        )
                )
            } else {
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(
                                applicationContext,
                                R.drawable.indicator_inactive
                        )
                )
            }
        }

    }
}
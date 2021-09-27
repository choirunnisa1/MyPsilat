package com.apps.mypsilat.hindar

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

class HindaranSisiActivity : AppCompatActivity() {
    private lateinit var contentTeknikAdapter: ContentTeknikAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hindaran_sisi)
        setOnContentItems()
        setupIndicator()
        setCurrentIndicator(0)

        video_kuda_depan.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                val videoId = "8obHvX94EyI"
                youTubePlayer.loadVideo(videoId, 0f)
            }
        })

        video_kuda_depan.enableBackgroundPlayback(false)

        back_button.setOnClickListener {
            onBackPressed()
        }

    }


    private fun setOnContentItems() {
        contentTeknikAdapter = ContentTeknikAdapter(
                listOf(
                        ContentItem(
                                R.drawable.h_s_satu,
                                R.drawable.h_s_dua,
                                "1",
                                "Sikap awal menggunakan kuda – kuda depan"
                        ),
                        ContentItem(
                                R.drawable.h_s_tiga,
                                null,
                                "2",
                                "Sikap kedua tangan waspada (berada di depan dada)"
                        ),
                        ContentItem(
                                R.drawable.h_s_empat,
                                R.drawable.h_s_lima,
                                "3",
                                "Menghindar ke samping lawan, hindaran ini dengan melangkahkan kaki ke samping kanan/kiri"
                        ),
                        ContentItem(
                                R.drawable.h_s_enam,
                                R.drawable.h_s_tujuh,
                                "4",
                                "Serong depan kakan/kiri, ataupun serong belakang kanan/kiri"
                        ),
                        ContentItem(
                                R.drawable.h_s_delapan,
                                R.drawable.h_s_sembilan,
                                "5",
                                "Sikap akhir kembali menggunakan kuda – kuda depan dengan sikap tangan waspada"
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
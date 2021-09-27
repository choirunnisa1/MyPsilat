package com.apps.mypsilat.kuda

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.apps.mypsilat.ContentItem
import com.apps.mypsilat.ContentTeknikAdapter
import com.apps.mypsilat.R
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import kotlinx.android.synthetic.main.activity_kuda_depan.*

class KudaDepanActivity : AppCompatActivity() {

    private lateinit var contentTeknikAdapter: ContentTeknikAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kuda_depan)
        setOnContentItems()
        setupIndicator()
        setCurrentIndicator(0)

        video_kuda_depan.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                val videoId = "bJtY-pmIUZE"
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
                    R.drawable.kuda_depan_satu,
                    R.drawable.kuda_depan_dua,
                    "1",
                    "Posisi awal tubuh berdiri tegak"
                ),
                ContentItem(
                    R.drawable.kuda_depan_tiga,
                    R.drawable.kuda_depan_empat,
                    "2",
                    "Kaki kiri di depan kaki kanan atau sebaliknya"
                ),
                ContentItem(
                    R.drawable.kuda_depan_lima,
                    R.drawable.kuda_depan_enam,
                    "3",
                    "Keduanya terletak satu garis"
                ),
                ContentItem(
                    R.drawable.kuda_depan_tujuh,
                    R.drawable.kuda_depan_delapan,
                    "4",
                    "Kaki yang di depan ditekuk dan kaki yang belakang lurus"
                ),
                ContentItem(
                    R.drawable.kuda_depan_lima,
                    R.drawable.kuda_depan_enam,
                    "5",
                    "Berat badan 90% diletakkan di atas kaki depan"
                ),
                ContentItem(
                    R.drawable.kuda_depan_tujuh,
                    R.drawable.kuda_depan_delapan,
                    "6",
                    "Posisi kedua tangan mengepal disamping pinggang"
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
            LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
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
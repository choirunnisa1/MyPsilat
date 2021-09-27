package com.apps.mypsilat.tangkis

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

class TangkisanLuarActivity : AppCompatActivity() {
    private lateinit var contentTeknikAdapter: ContentTeknikAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tangkisan_luar)
        setOnContentItems()
        setupIndicator()
        setCurrentIndicator(0)

        video_kuda_depan.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                val videoId = "VMK2StOpKzo"
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
                                R.drawable.tlu_satu,
                                R.drawable.tlu_dua,
                                "1",
                                "Sikap awal menggunakan kuda – kuda tengah"
                        ),
                        ContentItem(
                                R.drawable.tlu_tiga,
                                R.drawable.tlu_empat,
                                "2(a)",
                                "Tangan yang digunakan untuk menangkis arah gerakkanya dari dalam ke luar menangkis serangan lurus khusunya pukulan dengan perkenaan pada lengan bawah bagian dalam"
                        ),
                        ContentItem(
                                R.drawable.tlu_lima,
                                R.drawable.tlu_enam,
                                "2(b)",
                                "Tangan yang digunakan untuk menangkis arah gerakkanya dari dalam ke luar menangkis serangan lurus khusunya pukulan dengan perkenaan pada lengan bawah bagian dalam"
                        ),
                        ContentItem(
                                R.drawable.tlu_tujuh,
                                R.drawable.tlu_delapan,
                                "2(c)",
                                "Tangan yang digunakan untuk menangkis arah gerakkanya dari dalam ke luar menangkis serangan lurus khusunya pukulan dengan perkenaan pada lengan bawah bagian dalam"
                        ),
                        ContentItem(
                                R.drawable.tlu_sembilan,
                                R.drawable.tlu_sepuluh,
                                "2(d)",
                                "Tangan yang digunakan untuk menangkis arah gerakkanya dari dalam ke luar menangkis serangan lurus khusunya pukulan dengan perkenaan pada lengan bawah bagian dalam"
                        ),
                        ContentItem(
                                R.drawable.tlu_sebelas,
                                null,
                                "3",
                                "Tangan yang tidak digunakan untuk menangkis berada disamping pinggang mengepal menghadap ke atas"
                        ),
                        ContentItem(
                                R.drawable.tlu_sebelas,
                                null,
                                "3",
                                "Tangan yang tidak digunakan untuk menangkis berada disamping pinggang mengepal menghadap ke atas"
                        ),
                        ContentItem(
                                R.drawable.tlu_dua_belas,
                                R.drawable.tlu_tigabelas,
                                "4",
                                "Sikap akhir kembali menggunakan kuda – kuda tengah"
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
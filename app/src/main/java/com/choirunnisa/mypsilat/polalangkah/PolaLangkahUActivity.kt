package com.choirunnisa.mypsilat.polalangkah

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.choirunnisa.mypsilat.ContentItem
import com.choirunnisa.mypsilat.ContentTeknikAdapter
import com.choirunnisa.mypsilat.R
import kotlinx.android.synthetic.main.activity_kuda_belakang.*

class PolaLangkahUActivity : AppCompatActivity() {
    private lateinit var contentTeknikAdapter: ContentTeknikAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pola_langkah_v)
        setOnContentItems()
        setupIndicator()
        setCurrentIndicator(0)

        video_kuda_depan.settings.javaScriptEnabled = true
        video_kuda_depan.loadUrl("https://www.youtube.com/embed/UWly_UC49yg")


        back_button.setOnClickListener {
            video_kuda_depan.onPause()
            onBackPressed()
        }

    }

    private fun setOnContentItems() {
        contentTeknikAdapter = ContentTeknikAdapter(
                listOf(
                        ContentItem(
                                R.drawable.plu_satu,
                                R.drawable.plu_dua,
                                "1",
                                "Posisi awal menggunakan kuda – kuda tengah"
                        ),
                        ContentItem(
                                R.drawable.plu_tiga,
                                null,
                                "2",
                                "Sikap kedua tangan waspada (berada di depan dada)"
                        ),
                        ContentItem(
                                R.drawable.plu_empat,
                                R.drawable.plu_lima,
                                "3",
                                "Gerakan pertama yaitu ke kiri depan lurus dengan kaki kiri berada di depan dan kaki kanan berada di belakang"
                        ),
                        ContentItem(
                                R.drawable.plu_enam,
                                R.drawable.plu_tujuh,
                                "4",
                                "Gerakan kedua yaitu kembali ke posisi awal (kuda – kuda depan dengan sikap kedua tangan waspada)"
                        ),
                        ContentItem(
                                R.drawable.plu_delapan,
                                R.drawable.plu_sembilan,
                                "5",
                                "Gerakan ketiga yaitu ke kanan depan lurus dengan kaki kanan berada di depan dan kaki kiri berada di belakang"
                        ),
                        ContentItem(
                                R.drawable.plu_satu,
                                R.drawable.plu_dua,
                                "6",
                                "Gerakan terakhir yaitu kembali ke posisi awal (kuda – kuda depan dengan sikap kedua tangan waspada). Sehingga jika digabungkan dari gerakan tersebut terbentuk pola lintasan seperti huruf U"
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
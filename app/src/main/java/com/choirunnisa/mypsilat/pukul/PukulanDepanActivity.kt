package com.choirunnisa.mypsilat.pukul

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

class PukulanDepanActivity : AppCompatActivity() {
    private lateinit var contentTeknikAdapter: ContentTeknikAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pukulan_depan)
        setOnContentItems()
        setupIndicator()
        setCurrentIndicator(0)


        video_kuda_depan.settings.javaScriptEnabled = true
        video_kuda_depan.loadUrl("https://www.youtube.com/embed/Jl43fYZ1UMY")


        back_button.setOnClickListener {
            video_kuda_depan.onPause()
            onBackPressed()
        }

    }

    private fun setOnContentItems() {
        contentTeknikAdapter = ContentTeknikAdapter(
                listOf(
                        ContentItem(
                                R.drawable.pd_satu,
                                R.drawable.pd_dua,
                                "1",
                                "Sikap awal kuda – kuda tengah"
                        ),
                        ContentItem(
                                R.drawable.pd_tiga,
                                null,
                                "2",
                                "Kepalkan kedua tangan di samping pinggang (kepalan tangan menghadap ke atas)"
                        ),
                        ContentItem(
                                R.drawable.pd_empat,
                                R.drawable.pd_lima,
                                "3(a)",
                                "Selanjutnya pukulkan tangan  lurus ke depan dengan sasaran dada, pada saat memukul kepalan tangan yang digunakan untuk memukul menghadap ke bawah"   ),
                        ContentItem(
                                R.drawable.pd_enam,
                                R.drawable.pd_tujuh,
                                "3(b)",
                                "Selanjutnya pukulkan tangan  lurus ke depan dengan sasaran dada, pada saat memukul kepalan tangan yang digunakan untuk memukul menghadap ke bawah"
                        ),
                        ContentItem(
                                R.drawable.pd_delapan,
                                null,
                                "4",
                                "Sedangkan posisi tangan yang tidak digunakan untuk memukul berada disamping pinggang mengepal menghadap ke atas"
                        ),
                        ContentItem(
                                R.drawable.pd_sembilan,
                                R.drawable.pd_sepuluh,
                                "5",
                                "Sikap terakhir kembali menggunakan kuda – kuda tengah"
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
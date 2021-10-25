package com.choirunnisa.mypsilat.kuda

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
import kotlinx.android.synthetic.main.activity_kuda_samping.*

private lateinit var contentTeknikAdapter: ContentTeknikAdapter

class KudaSampingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kuda_samping)

        setOnContentItems()
        setupIndicator()
        setCurrentIndicator(0)

        video_kuda_depan.settings.javaScriptEnabled = true
        video_kuda_depan.loadUrl("https://www.youtube.com/embed/OHONCipdVW4")

        back_button.setOnClickListener {
            video_kuda_depan.onPause()
            onBackPressed()
        }
    }
    private fun setOnContentItems() {
        contentTeknikAdapter = ContentTeknikAdapter(
            listOf(
                ContentItem(
                    R.drawable.kuda_samping_satu,
                    R.drawable.kuda_samping_dua,
                    "1",
                    "Posisi awal tubuh berdiri tegak"
                ),
                ContentItem(
                    R.drawable.kuda_samping_tiga,
                    null,
                    "2",
                    "Kaki kanan sejajar dengan kaki kiri"
                ),
                ContentItem(
                    R.drawable.kuda_samping_empat,
                   null,
                    "3",
                    "Kaki kanan ditekuk dan kaki sebelah kiri lurus"
                ),
                ContentItem(
                    R.drawable.kuda_samping_lima,
                    null,
                    "4",
                    "Berat badan 90% diletakkan pada kaki yang ditekuk"),
                ContentItem(
                    R.drawable.kuda_samping_lima,
                    null,
                    "5",
                    "Kuda – kuda dengan berat badan ke samping kiri atau kanan dengan posisi badan tegap condong samping kiri atau kanan."
                ),
                ContentItem(
                    R.drawable.kuda_samping_enam,
                    null,
                    "6",
                    "Kaki terbuka menyamping"
                ),
                ContentItem(
                    R.drawable.kuda_samping_lima,
                    null,
                    "7",
                    "Kaki kanan atau kiri ditekuk sesuai dengan arah kuda – kudanya"
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
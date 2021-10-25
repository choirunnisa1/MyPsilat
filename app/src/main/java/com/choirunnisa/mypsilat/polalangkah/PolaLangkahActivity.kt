package com.choirunnisa.mypsilat.polalangkah

import android.content.Intent
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.choirunnisa.mypsilat.R
import kotlinx.android.synthetic.main.activity_kuda_depan.back_button
import kotlinx.android.synthetic.main.activity_pola_langkah.*

class PolaLangkahActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pola_langkah)

        back_button.setOnClickListener {
            onBackPressed()
        }

        more_langkah_lurus.paintFlags = more_langkah_lurus.paintFlags or Paint.UNDERLINE_TEXT_FLAG
        more_langkah_lurus.setOnClickListener {
            startActivity(Intent(this, PolaLangkahLurusActivity::class.java))
        }


        more_langkah_v.paintFlags = more_langkah_v.paintFlags or Paint.UNDERLINE_TEXT_FLAG
        more_langkah_v.setOnClickListener {
            startActivity(Intent(this, PolaLangkahUActivity::class.java))
        }


        more_langkah_segitiga.paintFlags = more_langkah_segitiga.paintFlags or Paint.UNDERLINE_TEXT_FLAG
        more_langkah_segitiga.setOnClickListener {
            startActivity(Intent(this, PolaLangkahSegitigaActivity::class.java))
        }

    }
}
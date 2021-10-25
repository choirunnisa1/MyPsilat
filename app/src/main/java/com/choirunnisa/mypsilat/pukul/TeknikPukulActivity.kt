package com.choirunnisa.mypsilat.pukul

import android.content.Intent
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.choirunnisa.mypsilat.R
import kotlinx.android.synthetic.main.activity_kuda_depan.back_button
import kotlinx.android.synthetic.main.activity_teknik_pukul.*

class TeknikPukulActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teknik_pukul)
        back_button.setOnClickListener {
            onBackPressed()
        }

        more_pukul_depan.paintFlags = more_pukul_depan.paintFlags or Paint.UNDERLINE_TEXT_FLAG
        more_pukul_depan.setOnClickListener {
            startActivity(Intent(this, PukulanDepanActivity::class.java))
        }


        more_pukul_lingkar.paintFlags = more_pukul_lingkar.paintFlags or Paint.UNDERLINE_TEXT_FLAG
        more_pukul_lingkar.setOnClickListener {
            startActivity(Intent(this, PukulanLingkarActivity::class.java))
        }


        more_pukul_sangkal.paintFlags = more_pukul_sangkal.paintFlags or Paint.UNDERLINE_TEXT_FLAG
        more_pukul_sangkal.setOnClickListener {
            startActivity(Intent(this, PukulanSangkalActivity::class.java))
        }

    }
}
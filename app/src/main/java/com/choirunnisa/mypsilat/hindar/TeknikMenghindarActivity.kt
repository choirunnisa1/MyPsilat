package com.choirunnisa.mypsilat.hindar

import android.content.Intent
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.choirunnisa.mypsilat.R
import kotlinx.android.synthetic.main.activity_kuda_depan.back_button
import kotlinx.android.synthetic.main.activity_teknik_menghindar.*

class TeknikMenghindarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teknik_menghindar)

        back_button.setOnClickListener {
            onBackPressed()
        }

        more_hindar_sisi.paintFlags = more_hindar_sisi.paintFlags or Paint.UNDERLINE_TEXT_FLAG
        more_hindar_sisi.setOnClickListener {
            startActivity(Intent(this, HindaranSisiActivity::class.java))
        }


        more_hindar_ak.paintFlags = more_hindar_ak.paintFlags or Paint.UNDERLINE_TEXT_FLAG
        more_hindar_ak.setOnClickListener {
            startActivity(Intent(this, HindaranAngkatKakiActivity::class.java))
        }


        more_hindar_ks.paintFlags = more_hindar_ks.paintFlags or Paint.UNDERLINE_TEXT_FLAG
        more_hindar_ks.setOnClickListener {
            startActivity(Intent(this, HindaranKakiSilangActivity::class.java))
        }

    }
}
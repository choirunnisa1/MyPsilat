package com.apps.mypsilat.elakan

import android.content.Intent
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.apps.mypsilat.R
import kotlinx.android.synthetic.main.activity_kuda_depan.*
import kotlinx.android.synthetic.main.activity_kuda_depan.back_button
import kotlinx.android.synthetic.main.activity_teknik_mengelak.*
import kotlinx.android.synthetic.main.activity_teknik_menghindar.*

class TeknikMengelakActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teknik_mengelak)

        back_button.setOnClickListener {
            onBackPressed()
        }

        more_elak_atas.paintFlags = more_elak_atas.paintFlags or Paint.UNDERLINE_TEXT_FLAG
        more_elak_atas.setOnClickListener {
            startActivity(Intent(this, ElakanAtasActivity::class.java))
        }


        more_elak_bawah.paintFlags = more_elak_bawah.paintFlags or Paint.UNDERLINE_TEXT_FLAG
        more_elak_bawah.setOnClickListener {
            startActivity(Intent(this, ElakanBawahActivity::class.java))
        }


        more_elak_samping.paintFlags = more_elak_samping.paintFlags or Paint.UNDERLINE_TEXT_FLAG
        more_elak_samping.setOnClickListener {
            startActivity(Intent(this, ElakanSampingActivity::class.java))
        }

    }
}
package com.choirunnisa.mypsilat.tendang

import android.content.Intent
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.choirunnisa.mypsilat.R
import kotlinx.android.synthetic.main.activity_kuda_depan.back_button
import kotlinx.android.synthetic.main.activity_teknik_menendang.*

class TeknikMenendangActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teknik_menendang)

        back_button.setOnClickListener {
            onBackPressed()
        }

        more_tendangan_sabit.paintFlags =
            more_tendangan_sabit.paintFlags or Paint.UNDERLINE_TEXT_FLAG
        more_tendangan_sabit.setOnClickListener {
            startActivity(Intent(this, TendanganSabitActivity::class.java))
        }


        more_tendangan_lurus.paintFlags = more_tendangan_lurus.paintFlags or Paint.UNDERLINE_TEXT_FLAG
        more_tendangan_lurus.setOnClickListener {
            startActivity(Intent(this, TendanganLurusActivity::class.java))
        }


        more_tendangan_t.paintFlags = more_tendangan_t.paintFlags or Paint.UNDERLINE_TEXT_FLAG
        more_tendangan_t.setOnClickListener {
            startActivity(Intent(this, TendanganTActivity::class.java))
        }

    }
}
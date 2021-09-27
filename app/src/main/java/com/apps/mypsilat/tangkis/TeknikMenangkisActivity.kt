package com.apps.mypsilat.tangkis

import android.content.Intent
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.apps.mypsilat.R
import kotlinx.android.synthetic.main.activity_kuda_depan.*
import kotlinx.android.synthetic.main.activity_teknik_menangkis.*
import kotlinx.android.synthetic.main.activity_teknik_menghindar.*

class TeknikMenangkisActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teknik_menangkis)

                back_buttons.setOnClickListener {
            onBackPressed()
        }

                more_tangkis_atas.paintFlags = more_tangkis_atas.paintFlags or Paint.UNDERLINE_TEXT_FLAG
        more_tangkis_atas.setOnClickListener {
                    startActivity(Intent(this, TangkisanAtasActivity::class.java))
                }


        more_tangkis_bawah.paintFlags = more_tangkis_bawah.paintFlags or Paint.UNDERLINE_TEXT_FLAG
        more_tangkis_bawah.setOnClickListener {
                    startActivity(Intent(this, TangkisanBawahActivity::class.java))
                }


        more_tangkis_dalam.paintFlags =more_tangkis_dalam.paintFlags or Paint.UNDERLINE_TEXT_FLAG
        more_tangkis_dalam.setOnClickListener {
                    startActivity(Intent(this, TangkisanDalamActivity::class.java))
                }

        more_tangkis_luar.paintFlags =more_tangkis_luar.paintFlags or Paint.UNDERLINE_TEXT_FLAG
        more_tangkis_luar.setOnClickListener {
            startActivity(Intent(this,TangkisanLuarActivity::class.java))
        }

    }
}
package com.choirunnisa.mypsilat.kuda

import android.content.Intent
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.choirunnisa.mypsilat.R
import kotlinx.android.synthetic.main.activity_kuda_depan.back_button
import kotlinx.android.synthetic.main.activity_sikap_kuda.*

class SikapKudaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sikap_kuda)

        back_button.setOnClickListener {
            onBackPressed()
        }

        more_kuda_depan.paintFlags = more_kuda_depan.paintFlags or Paint.UNDERLINE_TEXT_FLAG
        more_kuda_depan.setOnClickListener {
            startActivity(Intent(this, KudaDepanActivity::class.java))
        }


        more_kuda_samping.paintFlags = more_kuda_samping.paintFlags or Paint.UNDERLINE_TEXT_FLAG
        more_kuda_samping.setOnClickListener {
            startActivity(Intent(this, KudaSampingActivity::class.java))
        }


        more_kuda_tengah.paintFlags = more_kuda_tengah.paintFlags or Paint.UNDERLINE_TEXT_FLAG
        more_kuda_tengah.setOnClickListener {
            startActivity(Intent(this, KudaTengahActivity::class.java))
        }


        more_kuda_belakang.paintFlags = more_kuda_belakang.paintFlags or Paint.UNDERLINE_TEXT_FLAG
        more_kuda_belakang.setOnClickListener {
            startActivity(Intent(this, KudaBelakangActivity::class.java))
        }
    }
}
package com.choirunnisa.mypsilat

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_kuda_belakang.back_button
import kotlinx.android.synthetic.main.activity_teknik_jurus.*

class TeknikJurusActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teknik_jurus)

        video_jurus.settings.javaScriptEnabled = true
        video_jurus.loadUrl("https://www.youtube.com/embed/5nSR_w3hB9w")


        back_button.setOnClickListener {
            video_jurus.onPause()
            onBackPressed()
        }
    }
}
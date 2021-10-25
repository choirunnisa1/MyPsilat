package com.choirunnisa.mypsilat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sarana.*

class PerlengkapanTandingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perlengkapan_tanding)

        back_button.setOnClickListener {
            onBackPressed()
        }

    }
}
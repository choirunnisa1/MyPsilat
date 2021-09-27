package com.apps.mypsilat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sarana.*

class SaranaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sarana)

        back_button.setOnClickListener {
            onBackPressed()
        }

        more_lap.setOnClickListener {
            startActivity(Intent(this,LapanganActivity::class.java))
        }

        more_gel.setOnClickListener {
            startActivity(Intent(this,PerlengkapanLapActivity::class.java))
        }

        more_per.setOnClickListener {
            startActivity(Intent(this,PerlengkapanTandingActivity::class.java))
        }
    }
}
package com.choirunnisa.mypsilat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        seputar_menu.setOnClickListener {
            startActivity(Intent(this,SeputarActivity::class.java))
        }

        sarana.setOnClickListener {
            startActivity(Intent(this,SaranaActivity::class.java))
        }

        teknik.setOnClickListener {
            startActivity(Intent(this, TeknikActivity::class.java))
        }

        evaluasi.setOnClickListener {
            startActivity(Intent(this, EvaluasiActivity::class.java))
        }

        tentang.setOnClickListener {
            startActivity(Intent(this, TentangActivity::class.java))
        }

        reference.setOnClickListener {
            startActivity(Intent(this, ReferenceActivity::class.java))
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}
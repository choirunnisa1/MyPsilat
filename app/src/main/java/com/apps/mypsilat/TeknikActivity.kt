package com.apps.mypsilat

import android.content.Intent
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.apps.mypsilat.elakan.TeknikMengelakActivity
import com.apps.mypsilat.hindar.TeknikMenghindarActivity
import com.apps.mypsilat.kuda.SikapKudaActivity
import com.apps.mypsilat.polalangkah.PolaLangkahActivity
import com.apps.mypsilat.pukul.TeknikPukulActivity
import com.apps.mypsilat.tangkis.TeknikMenangkisActivity
import com.apps.mypsilat.tendang.TeknikMenendangActivity
import kotlinx.android.synthetic.main.activity_teknik.*

class TeknikActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teknik)

        back_button.setOnClickListener {
            onBackPressed()
        }

        more_kuda.paintFlags = more_kuda.paintFlags or Paint.UNDERLINE_TEXT_FLAG

        more_kuda.setOnClickListener {
            startActivity(Intent(this, SikapKudaActivity::class.java ))
        }

        more_hindar.paintFlags = more_hindar.paintFlags or Paint.UNDERLINE_TEXT_FLAG

        more_hindar.setOnClickListener {
            startActivity(Intent(this, TeknikMenghindarActivity::class.java ))
        }

        more_langkah.paintFlags = more_langkah.paintFlags or Paint.UNDERLINE_TEXT_FLAG

        more_langkah.setOnClickListener {
            startActivity(Intent(this, PolaLangkahActivity::class.java ))
        }

        more_tangkis.paintFlags = more_tangkis.paintFlags or Paint.UNDERLINE_TEXT_FLAG

        more_tangkis.setOnClickListener {
            startActivity(Intent(this, TeknikMenangkisActivity::class.java ))
        }

        more_tendang.paintFlags = more_tendang.paintFlags or Paint.UNDERLINE_TEXT_FLAG

        more_tendang.setOnClickListener {
            startActivity(Intent(this, TeknikMenendangActivity::class.java ))
        }

        more_mengelak.paintFlags = more_mengelak.paintFlags or Paint.UNDERLINE_TEXT_FLAG

        more_mengelak.setOnClickListener {
            startActivity(Intent(this, TeknikMengelakActivity::class.java ))
        }

        more_pukul.paintFlags = more_pukul.paintFlags or Paint.UNDERLINE_TEXT_FLAG

        more_pukul.setOnClickListener {
            startActivity(Intent(this, TeknikPukulActivity::class.java ))
        }

        more_jurus.paintFlags = more_jurus.paintFlags or Paint.UNDERLINE_TEXT_FLAG

        more_jurus.setOnClickListener {
            startActivity(Intent(this, TeknikJurusActivity::class.java ))
        }


    }
}
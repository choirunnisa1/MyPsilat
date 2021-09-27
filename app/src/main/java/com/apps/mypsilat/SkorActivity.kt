package com.apps.mypsilat

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_skor.*

class SkorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skor)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        val totalCorrectAnswer = intent.getIntExtra(Constants.CORRECT_ANSWER,0)

        val score = totalCorrectAnswer/4*10

        val tv_score = findViewById<TextView>(R.id.tv_score)
        tv_score.text = "Skor Anda adalah $score dari 100"


        btn_finish.setOnClickListener {
            val closeIntent = Intent(this, MainActivity::class.java)
            closeIntent.addCategory(Intent.CATEGORY_HOME)
            closeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(closeIntent)
        }
    }
}
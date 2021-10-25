package com.choirunnisa.mypsilat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_seputar.*

class SeputarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seputar)

        back_button.setOnClickListener {
                val closeIntent = Intent(this, MainActivity::class.java)
                closeIntent.addCategory(Intent.CATEGORY_HOME)
                closeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(closeIntent)
        }
    }
}
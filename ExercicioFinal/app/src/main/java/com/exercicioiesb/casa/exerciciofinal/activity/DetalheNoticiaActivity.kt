package com.exercicioiesb.casa.exerciciofinal.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.exercicioiesb.casa.exerciciofinal.R
import kotlinx.android.synthetic.main.activity_detalhe_noticia.*

class DetalheNoticiaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe_noticia)

        imgFechar.setOnClickListener {
            finish()
        }

    }
}
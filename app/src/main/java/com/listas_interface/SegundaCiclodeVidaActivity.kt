package com.listas_interface

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.listas_interface.singleton.ListaControle

class SegundaCiclodeVidaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda_ciclode_vida)

        ListaControle.nomes.remove("Arthur")
    }
}
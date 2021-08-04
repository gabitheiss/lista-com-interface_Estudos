package com.listas_interface

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import com.listas_interface.singleton.ListaControle

class CicloDeVida_MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ciclo_de_vida_main)
        findViewById<Button>(R.id.buttonNextPage).setOnClickListener{
            val intentSegundaTela = Intent (this, SegundaCiclodeVidaActivity::class.java)
            startActivity(intentSegundaTela)
        }

    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        Snackbar.make(window.decorView, "Lisata com: ${ListaControle.nomes.size} elementos", Snackbar.LENGTH_LONG).show()
        super.onResume()
    }

    override fun onRestart() {
        super.onRestart()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
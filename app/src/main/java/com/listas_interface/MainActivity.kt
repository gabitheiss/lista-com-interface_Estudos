package com.listas_interface

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.listas_interface.model.product
import com.listas_interface.adapter.AdapterList
import com.listas_interface.adapter.InterfaceClickableCarrinho

class MainActivity : AppCompatActivity(), InterfaceClickableCarrinho {

    // variavel irá receber a instancia do recycler view que vem do xml
    private lateinit var listaRecyclerView : RecyclerView
    private lateinit var produtosAdapterList: AdapterList



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // usamos o mutable para conseguir trabalhar com a lista
        val listOfProduct = mutableListOf<product>(
            product("TV","R$2.000,00"),
            product("Smarphone","R$3.000,00"),
            product("Soundbar","R$1.500,00"),
            product("Ar Condicionado","R$1.800,00"),
            product("Aparelho de Som","R$1.000,00"),

        )

        //iniciamos a instancia do adapter parrando o array como parametro
        produtosAdapterList = AdapterList(listOfProduct, this)


        //variavel listaRecyclerView está recebendo o recycler que vem do xml
        listaRecyclerView = findViewById(R.id.recyclerView)
        // define a forma que a lista irá trabalhar (GRID, LINEAR, SCROLL VERTICAL OU HORIZONTAL)
        listaRecyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        // adicionar o adapter no recycler view
        listaRecyclerView.adapter = produtosAdapterList



    }

    override fun onEdit(product: product) {

    }

    override fun onDelete(product: product) {
        if (listaRecyclerView.adapter is AdapterList) {
            (listaRecyclerView.adapter as AdapterList).removeAt(product)
        }
    }

    override fun onNew(product: product) {
        if (listaRecyclerView.adapter is AdapterList) {
            (listaRecyclerView.adapter as AdapterList).add(product("Microondas", "R$700,00",))
        }
      }
    }
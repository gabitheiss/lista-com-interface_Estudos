package com.listas_interface

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.BaseTransientBottomBar.LENGTH_LONG
import com.google.android.material.snackbar.Snackbar
import com.listas_interface.model.product
import com.listas_interface.adapter.AdapterList
import com.listas_interface.adapter.InterfaceClickableCarrinho

class MainActivity : AppCompatActivity(), InterfaceClickableCarrinho {

    // variavel irá receber a instancia do recycler view que vem do xml
    private lateinit var listaRecyclerView: RecyclerView
    private lateinit var produtosAdapterList: AdapterList


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // usamos o mutable para conseguir trabalhar com a lista
        val listOfProduct = mutableListOf<product>(
            product("TV", "R$2.000,00"),
            product("Smarphone", "R$3.000,00"),
            product("Soundbar", "R$1.500,00"),
            product("Ar Condicionado", "R$1.800,00"),
            product("Aparelho de Som", "R$1.000,00"),

            )

        //iniciamos a instancia do adapter parrando o array como parametro
        produtosAdapterList = AdapterList(listOfProduct, this)


        //variavel listaRecyclerView está recebendo o recycler que vem do xml
        listaRecyclerView = findViewById(R.id.recyclerView)
        // define a forma que a lista irá trabalhar (GRID, LINEAR, SCROLL VERTICAL OU HORIZONTAL)
        listaRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        // adicionar o adapter no recycler view
        listaRecyclerView.adapter = produtosAdapterList


    }

    override fun onEdit(product: product) {
        //foi criado uma extension com o nome concatWithCompany
        //showMessage(listaRecyclerView, produtosAdapterList.nome.concatNameWithCompany)
    }

    override fun onDelete(product: product) {
        if (listaRecyclerView.adapter is AdapterList) {
            (listaRecyclerView.adapter as AdapterList).removeAt(product)
        }
    }

    override fun onNew(product: product) {
        if (listaRecyclerView.adapter is AdapterList) {
            (listaRecyclerView.adapter as AdapterList).add(product("Microondas", "R$700,00"))
        }
    }
}

fun AppCompatActivity.showMessage(view: View, message: String) {
    Snackbar.make(view, message, LENGTH_LONG).show()
}


//criando e aplicando extension



fun String.removeCaracter(): String {
    return replace(".", "").replace("-", "")
}



fun String.cpf() : String? {
   if (length == 11){
       return substring(0, 3) + "." +
               substring(3,6) + "." +
               substring(6,9) + "-" +
               substring(9,11)
   }
    //se o cpf não tiver 11 caracteres, vai retornar null
    return null
}

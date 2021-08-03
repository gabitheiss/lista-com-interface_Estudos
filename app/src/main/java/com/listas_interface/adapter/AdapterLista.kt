package com.listas_interface.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.listas_interface.R
import com.listas_interface.model.Product

//depois criar o viewholder -> passar a classe do tipo adapter : RecyclerView.Adapter<ItensCarrinhoViewHolder>()
class AdapterList(
    var listOfProduct: MutableList<Product>,
    var interfaceClickableCarrinho: InterfaceClickableCarrinho) : RecyclerView.Adapter<ItensCarrinhoViewHolder>() {



   //define o layout para cada item da lista, link com arquivo xml novo
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItensCarrinhoViewHolder {
        //convertemos o nosso xml em uma view
       val itemView = LayoutInflater.from(parent.context).inflate(R.layout.itens_lista, parent, false)
        return ItensCarrinhoViewHolder(itemView)
    }


    //aqui que manipulamos os dados de cada item (tela x elementos + index) e jogamos os dados para a tela, add os eventos como o click
    override fun onBindViewHolder(itensCarrinhoViewHolder: ItensCarrinhoViewHolder, position: Int) {

        val produtoSelecionado = listOfProduct[position]

        itensCarrinhoViewHolder.itemView.findViewById<TextView>(R.id.idProduct).apply {
           text = produtoSelecionado.product
       }

        itensCarrinhoViewHolder.itemView.findViewById<TextView>(R.id.idValue).apply {
            text = produtoSelecionado.value
        }


        itensCarrinhoViewHolder.itemView.findViewById<Button>(R.id.buttonDelete).setOnClickListener {
            interfaceClickableCarrinho.onDelete(produtoSelecionado)
        }
        itensCarrinhoViewHolder.itemView.findViewById<Button>(R.id.buttonNew).setOnClickListener {
            interfaceClickableCarrinho.onNew(produtoSelecionado)
        }



    }


   //define quantos elementos o recycler view irá precisar criar
    override fun getItemCount(): Int {
        return listOfProduct.size
    }


    fun removeAt(product: Product){
        listOfProduct.remove(product)
        notifyDataSetChanged()

    } fun add(product: Product){
        listOfProduct.add(product)
        notifyDataSetChanged()
    }



}

// primeiro criar esta classe
class ItensCarrinhoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {




}
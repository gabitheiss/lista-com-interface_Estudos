package com.listas_interface.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.Button
import android.widget.ListAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.listas_interface.MainActivity
import com.listas_interface.R

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

//        listOfProduct[position].apply {
//            ItensCarrinhoViewHolder.bind(this)
//        }


        itensCarrinhoViewHolder.itemView.findViewById<Button>(R.id.buttonDelete).setOnClickListener {
            val produtoSelecionadoParaDeletar = listOfProduct[position]
            interfaceClickableCarrinho.onDelete(produtoSelecionadoParaDeletar)
        }
        itensCarrinhoViewHolder.itemView.findViewById<Button>(R.id.buttonNew).setOnClickListener {
            val produtoSelecionadoParaAdd = listOfProduct[position]
            interfaceClickableCarrinho.onNew(produtoSelecionadoParaAdd)
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


    fun bind(product: Product) {

        itemView.findViewById<TextView>(R.id.idProduct).apply {
            text = product.product
        }
        itemView.findViewById<TextView>(R.id.idValue).apply {
            text = product.value

        }

    }
}
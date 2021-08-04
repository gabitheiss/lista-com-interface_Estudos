package com.listas_interface.adapter

import com.listas_interface.model.product

interface InterfaceClickableCarrinho {

    fun onEdit (product : product)
    fun onDelete (product : product)
    fun onNew (product : product)
}
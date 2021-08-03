package com.listas_interface.adapter

import com.listas_interface.model.Product

interface InterfaceClickableCarrinho {

    fun onEdit (product : Product)
    fun onDelete (product : Product)
    fun onNew (product : Product)
}
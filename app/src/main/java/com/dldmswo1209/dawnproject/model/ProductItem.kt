package com.dldmswo1209.dawnproject.model

data class ProductItem(
    val image: Int,
    val brand: String,
    val detail: String,
    val sale: String,
    val price: String,
    val type: String,
    var like: Boolean
)

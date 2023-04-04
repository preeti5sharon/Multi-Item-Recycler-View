package com.example.recyclerview

sealed class ItemClass(val viewType: Int) {
    data class ItemString(val data: String) : ItemClass(RVAdapter.VIEW_TYPE_ONE)
    data class ItemList(val data: List<String>) : ItemClass(RVAdapter.VIEW_TYPE_TWO)
}

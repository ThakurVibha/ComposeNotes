package com.example.cleanarchitechturenotesapp.util

sealed class OrderType{

    object Ascending :OrderType()
    object Descending:OrderType()
}

package com.devspace.recyclerview

import androidx.annotation.DrawableRes

data class Contact(
    val name : String,
    val phone : String,
    val city : String,
    @DrawableRes val icon : Int
)

package com.example.androidadvanceddevlopment.Que_4.Model

data class Singer(
    var id : Int,
    var name :String
){
    override fun toString(): String {
        return name
    }
}

package me.vaimon.aspenexample.ui.models

data class State(
    val name: String,
    val code: String?
){
    override fun toString(): String {
        return name
    }
}
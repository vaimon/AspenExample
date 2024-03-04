package me.vaimon.aspenexample.utill

sealed class Resource<out T: Any> {
    data class Success<out T: Any>(val data: T): Resource<T>()
    data class Error(val exception: Throwable): Resource<Nothing>()
    data object Loading: Resource<Nothing>()
}
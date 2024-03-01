package me.vaimon.aspenexample.utill

interface Mapper<T, E> {
    fun from(e: E): T

    fun to(t: T): E
}
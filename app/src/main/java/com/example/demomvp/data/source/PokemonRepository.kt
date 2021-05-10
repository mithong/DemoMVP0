package com.example.demomvp.data.source

import com.example.demomvp.data.model.Pokemon
import com.example.demomvp.data.source.local.PokemonLocalDataSource
import com.example.demomvp.data.source.remote.OnFetchDataJsonListener
import com.example.demomvp.data.source.remote.PokemonRemoteDataSource

class PokemonRepository private constructor(private val remote: PokemonDataSource.Remote,
                                            private val local: PokemonDataSource.Local) {

    private object Holder {
        val INSTANCE = PokemonRepository(
            remote = PokemonRemoteDataSource.instance,
            local = PokemonLocalDataSource.instance)
    }

    fun getPokemon(listener: OnFetchDataJsonListener<MutableList<Pokemon>>) {
        remote.getPokemon(listener)
    }

    companion object {
        val instance: PokemonRepository by lazy { Holder.INSTANCE }
    }

}

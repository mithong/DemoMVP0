package com.example.demomvp.data.source

import com.example.demomvp.data.model.Pokemon
import com.example.demomvp.data.source.remote.OnFetchDataJsonListener

interface PokemonDataSource {

    interface Local

    interface Remote{
        fun getPokemon(listener: OnFetchDataJsonListener<MutableList<Pokemon>>)
    }
}

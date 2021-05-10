package com.example.demomvp.data.source.local

import com.example.demomvp.data.source.PokemonDataSource

class PokemonLocalDataSource : PokemonDataSource, PokemonDataSource.Local {

    private object Holder {
        val INSTANCE = PokemonLocalDataSource()
    }

    companion object {
        val instance: PokemonLocalDataSource by lazy { Holder.INSTANCE }
    }

}

package com.example.demomvp.screen

import com.example.demomvp.data.model.Pokemon
import com.example.demomvp.utils.BasePresenter

interface MainContract {
    /**
     * View
     */
    interface View {
        fun onGetPokemonSuccess(pokemon: MutableList<Pokemon>)
        fun onError(exception: Exception?)
    }

    /**
     * Presenter
     */
    interface Presenter : BasePresenter<View> {
        fun getPokemon()
    }
}

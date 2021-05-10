package com.example.demomvp.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demomvp.R
import com.example.demomvp.data.model.Pokemon
import com.example.demomvp.data.source.PokemonRepository
import com.example.demomvp.screen.adapter.MainAdapter
import com.example.demomvp.utils.OnItemRecyclerViewClickListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View {

    private val adapter by lazy { MainAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        initData()
    }

    private fun initView() {
        recyclerPokemon.setHasFixedSize(true)
        recyclerPokemon.adapter = adapter
        recyclerPokemon.layoutManager = LinearLayoutManager(this)
        adapter.registerItemRecyclerViewClickListener{
            Toast.makeText(this, it.name, Toast.LENGTH_SHORT).show()
        }
    }

    private fun initData() {
        val presenter = MainPresenter(PokemonRepository.instance)
        presenter.setView(this@MainActivity)
        presenter.onStart()
    }

    override fun onGetPokemonSuccess(pokemon: MutableList<Pokemon>) = adapter.updateData(pokemon)

    override fun onError(exception: Exception?) {
        Toast.makeText(this, exception?.message, Toast.LENGTH_SHORT).show()
    }

}

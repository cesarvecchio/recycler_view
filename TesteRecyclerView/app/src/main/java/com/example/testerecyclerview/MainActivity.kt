package com.example.testerecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testerecyclerview.adapter.RestauranteAdapter
import com.example.testerecyclerview.adapter.RestauranteItemClickListener
import com.example.testerecyclerview.model.Restaurante

class MainActivity : AppCompatActivity(),
    RestauranteItemClickListener {

    lateinit var tvTexto: TextView
    lateinit var rvRestaurante: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvTexto = findViewById(R.id.tv_texto)
        rvRestaurante = findViewById(R.id.rv_restaurantes)

        initRestaurante()
    }

    fun initRestaurante() {
        var lista: List<Restaurante>?

        lista = listOf(
            Restaurante("a", "Rua Iolanda Diorio Franca, 29", "a"),
            Restaurante("a", "R. Serra dos Cristais - Vila Minerva", "a")
        )

        val restauranteAdapter = RestauranteAdapter(
            this,
            lista,
            this
        )
        rvRestaurante.adapter = restauranteAdapter
        rvRestaurante.layoutManager = GridLayoutManager(
            this,
            1,
            LinearLayoutManager.VERTICAL,
            false
        )
    }

    override fun onRestauranteClick(restaurante: Restaurante) {
        tvTexto.text = restaurante.endereco
    }

}
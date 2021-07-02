package com.example.recycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.recycle.adapter.NotasAdapter
import com.example.recycle.modelo.Nota
import kotlinx.coroutines.launch
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    lateinit var recyclerNotas:RecyclerView

    lateinit var app:NotaApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerNotas = findViewById(R.id.listaNotas)
        app = applicationContext as NotaApp

        val notas = ArrayList<Nota>()
        notas.add(Nota(titulo = "Primera nota", descripcion = "Una descripcion"))
        notas.add(Nota(titulo = "Primera nota -1", descripcion = "Una descripcion un poco más larga"))
        notas.add(Nota(titulo = "Primera nota 0", descripcion = "Una descripcion"))
        notas.add(Nota(titulo = "Primera nota 1", descripcion = "Una descripcion"))
        notas.add(Nota(titulo = "Primera nota 2", descripcion = "Una descripcion muchisisisisisisisisisisisisissisisimo "))
        notas.add(Nota(titulo = "Primera nota 3", descripcion = "Una descripcion"))
        notas.add(Nota(titulo = "Primera nota 4", descripcion = "Una descripcion"))
        notas.add(Nota(titulo = "Primera nota 5", descripcion = "Una descripcion"))

        recyclerNotas.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recyclerNotas.setHasFixedSize(true)
        recyclerNotas.adapter = NotasAdapter(notas, this)

    }

    override fun onResume() {
        super.onResume()
        lifecycleScope.launch{
            val notas = app.room.notaDao().obtenerTodas()

            for (nota in notas){
                Log.i("Notas",nota.titulo)
            }
        }
    }
}
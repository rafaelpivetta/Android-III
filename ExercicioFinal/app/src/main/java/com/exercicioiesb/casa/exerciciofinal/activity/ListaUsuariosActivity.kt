package com.exercicioiesb.casa.exerciciofinal.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.exercicioiesb.casa.exerciciofinal.R
import com.exercicioiesb.casa.exerciciofinal.R.*
import com.exercicioiesb.casa.exerciciofinal.adapter.UsuarioAdapter
import com.exercicioiesb.casa.exerciciofinal.entity.Usuario
import com.google.firebase.database.*
import java.util.ArrayList

class ListaUsuariosActivity : AppCompatActivity() {

    private var mRecycleViewUsuarios: RecyclerView? = null
    private var adapter: UsuarioAdapter? = null
    private var usuarios: MutableList<Usuario>? = null
    private var referenciaFirebase: DatabaseReference? = null
    private var usuario: Usuario? = null
    private var mLayoutManagerTodosUsuarios: LinearLayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_lista_usuarios)

        mRecycleViewUsuarios = findViewById(R.id.recycleViewTodosUsuarios) as RecyclerView
        mRecycleViewUsuarios!!.itemAnimator = DefaultItemAnimator()
        mRecycleViewUsuarios!!.layoutManager = LinearLayoutManager(this)

        carregarTodosUsuarios()
    }

    private fun carregarTodosUsuarios() {

        mRecycleViewUsuarios!!.setHasFixedSize(true)
        mLayoutManagerTodosUsuarios = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mRecycleViewUsuarios!!.setLayoutManager(mLayoutManagerTodosUsuarios)
        usuarios = ArrayList<Usuario>()
        referenciaFirebase = FirebaseDatabase.getInstance().reference

        referenciaFirebase!!.child("usuarios").orderByChild("nome").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                for (postSnapshot in dataSnapshot.children) {

                    usuario = postSnapshot.getValue<Usuario>(Usuario::class.java)

                    usuarios!!.add(usuario!!)

                }

                adapter!!.notifyDataSetChanged()
            }

            override fun onCancelled(databaseError: DatabaseError) {

            }
        })

        adapter = UsuarioAdapter(usuarios!!, this)
        mRecycleViewUsuarios!!.setAdapter(adapter)

    }
}

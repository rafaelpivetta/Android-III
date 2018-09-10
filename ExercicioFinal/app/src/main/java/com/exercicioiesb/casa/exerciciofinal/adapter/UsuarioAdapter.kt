package com.exercicioiesb.casa.exerciciofinal.adapter

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.exercicioiesb.casa.exerciciofinal.entity.Usuario
import com.google.firebase.database.*
import com.exercicioiesb.casa.exerciciofinal.R
import com.exercicioiesb.casa.exerciciofinal.activity.DetalheNoticiaActivity
import com.exercicioiesb.casa.exerciciofinal.activity.MainActivity

class UsuarioAdapter(private val mUsuarioList: List<Usuario>, private val context: Context) : RecyclerView.Adapter<UsuarioAdapter.ViewHolder>() {

    private var referenciaFirebase: DatabaseReference? = null
    private var usuarios: MutableList<Usuario>? = null
    private var usuario: Usuario? = null

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): UsuarioAdapter.ViewHolder {

        val itemView = LayoutInflater.from(context).inflate(R.layout.cell_usuarios, viewGroup, false)

        return UsuarioAdapter.ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UsuarioAdapter.ViewHolder, position: Int) {

        val item = mUsuarioList[position]

//        usuarios = ArrayList<Usuario>()
//
//        referenciaFirebase = FirebaseDatabase.getInstance().reference
//
//        referenciaFirebase!!.child("usuarios").orderByChild("nome").equalTo(item.email).addValueEventListener(object : ValueEventListener {
//            override fun onDataChange(dataSnapshot: DataSnapshot) {
//                usuarios!!.clear()
//
//                for (postSnapshot in dataSnapshot.children) {
//                    usuario = postSnapshot.getValue<Usuario>(Usuario::class.java)
//
//                    usuarios!!.add(usuario!!)
//
////                    val displayMetrics = context.resources.displayMetrics
////
////                    val height = displayMetrics.heightPixels / 4
////                    val width = displayMetrics.widthPixels / 2
//
////                    Picasso.get().load(usuario!!.foto).resize(width, height).centerCrop().into(holder.fotoProdutoCardapio)
//                }
//            }
//
//            override fun onCancelled(databaseError: DatabaseError) {
//
//            }
//        })

        holder.txtNome.text = item.nome
        holder.txtMatricula.text = item.matricula
        holder.txtEmail.text = item.email

        holder.linearLayoutUsuario.setOnClickListener {
            val intent = Intent(context, DetalheNoticiaActivity::class.java)
//            Toast.makeText(context, "Direcionar para chat.", Toast.LENGTH_LONG).show()
        }
    }

    override fun getItemCount(): Int {
        return mUsuarioList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var txtNome: TextView
        var txtMatricula: TextView
        var txtEmail: TextView
        var linearLayoutUsuario: LinearLayout

        init {
//            itemView.setOnClickListener {
//                val intent = Intent(, DetalheNoticiaActivity::class.java)
//                startActivity(intent)
//            }
            txtNome = itemView.findViewById(R.id.txtNome) as TextView
            txtMatricula = itemView.findViewById(R.id.txtMatricula) as TextView
            txtEmail = itemView.findViewById(R.id.txtEmail) as TextView
            linearLayoutUsuario = itemView.findViewById(R.id.linearLayoutUsuario) as LinearLayout

        }

    }
}
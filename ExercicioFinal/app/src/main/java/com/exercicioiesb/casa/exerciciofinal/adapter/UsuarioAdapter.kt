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
import com.exercicioiesb.casa.exerciciofinal.activity.ChatActivity
import com.exercicioiesb.casa.exerciciofinal.activity.DetalheNoticiaActivity
import com.exercicioiesb.casa.exerciciofinal.activity.MainActivity
import com.exercicioiesb.casa.exerciciofinal.activity.NovoUsuarioActivity
import com.google.firebase.auth.FirebaseAuth


class UsuarioAdapter(private val mUsuarioList: List<Usuario>, private val context: Context) : RecyclerView.Adapter<UsuarioAdapter.ViewHolder>() {

    private var referenciaFirebase: DatabaseReference? = null
    private var usuarios: MutableList<Usuario>? = null
    private var usuario: Usuario? = null
    private var autenticacao: FirebaseAuth? = null

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): UsuarioAdapter.ViewHolder {

        val itemView = LayoutInflater.from(context).inflate(R.layout.cell_usuarios, viewGroup, false)
        autenticacao = FirebaseAuth.getInstance()

        return UsuarioAdapter.ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UsuarioAdapter.ViewHolder, position: Int) {


        val item = mUsuarioList[position]

        if (!autenticacao!!.currentUser!!.email.equals(item.email)){
            usuarios = ArrayList<Usuario>()

            referenciaFirebase = FirebaseDatabase.getInstance().reference

            referenciaFirebase!!.child("usuarios").orderByChild("email").equalTo(item.email).addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    usuarios!!.clear()

                    for (postSnapshot in dataSnapshot.children) {
                        usuario = postSnapshot.getValue<Usuario>(Usuario::class.java)

                        usuarios!!.add(usuario!!)

    //                      val displayMetrics = context.resources.displayMetrics
    //
    //                      val height = displayMetrics.heightPixels / 4
    //                      val width = displayMetrics.widthPixels / 2
    //
    //                      Picasso.get().load(usuario!!.foto).resize(width, height).centerCrop().into(holder.imgAvatar)
                    }
                }

                override fun onCancelled(databaseError: DatabaseError) {

                }
            })

            holder.txtNome.text = item.nome
            holder.txtMatricula.text = item.matricula
            holder.txtEmail.text = item.email

            holder.linearLayoutUsuario.setOnClickListener {
                val it = Intent(context, ChatActivity::class.java)
                context.startActivity(it)
            }
        }
    }

    override fun getItemCount(): Int {
        return mUsuarioList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var txtNome: TextView
        var txtMatricula: TextView
        var txtEmail: TextView
//        var imgAvatar: ImageView
        var linearLayoutUsuario: LinearLayout

        init {

            txtNome = itemView.findViewById(R.id.txtNome) as TextView
            txtMatricula = itemView.findViewById(R.id.txtMatricula) as TextView
            txtEmail = itemView.findViewById(R.id.txtEmail) as TextView
//            imgAvatar = itemView.findViewById(R.id.imgAvatar) as ImageView
            linearLayoutUsuario = itemView.findViewById(R.id.linearLayoutUsuario) as LinearLayout

        }

    }
}
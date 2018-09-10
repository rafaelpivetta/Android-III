package com.exercicioiesb.casa.exerciciofinal.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.*
import android.widget.TextView
import com.exercicioiesb.casa.exerciciofinal.R
import com.exercicioiesb.casa.exerciciofinal.entity.Noticia
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    var mAuth: FirebaseAuth? = null

    var noticiasList: MutableList<Noticia> = ArrayList()

    lateinit var lista: RecyclerView

    var email: String = String()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAuth = FirebaseAuth.getInstance()

        val it = intent

        email = it.getStringExtra("email")

        noticiasList.add(Noticia(1, "Notícia1", "Notícia1 Notícia1 Notícia1 Notícia1 Notícia1 Notícia1 Notícia1 Notícia1 Notícia1 Notícia1 Notícia1 Notícia1 Notícia1 Notícia1.", "14/05/2018"))
        noticiasList.add(Noticia(2, "Notícia2", "Notícia2 Notícia2 Notícia2 Notícia2 Notícia2 Notícia2 Notícia2 Notícia2 Notícia2 Notícia2 Notícia2 Notícia2 Notícia2 Notícia2 Notícia2 Notícia2 Notícia2 Notícia2 Notícia2 Notícia2 Notícia2 Notícia2 Notícia2.", "14/05/2018"))
        noticiasList.add(Noticia(3, "Notícia3", "Notícia3 Notícia3 Notícia3 Notícia3 Notícia3 Notícia3 Notícia3 Notícia3 Notícia3 Notícia3 Notícia3 Notícia3 Notícia3 Notícia3 Notícia3 Notícia3 Notícia3 Notícia3 Notícia3 Notícia3.", "14/05/2018"))
        noticiasList.add(Noticia(4, "Notícia4", "Notícia4 Notícia4 Notícia4 Notícia4 Notícia4 Notícia4 Notícia4 Notícia4 Notícia4 Notícia4 Notícia4 Notícia4 Notícia4 Notícia4 Notícia4 Notícia4 Notícia4 Notícia4 Notícia4 Notícia4.", "14/05/2018"))
        noticiasList.add(Noticia(5, "Notícia5", "Notícia5 Notícia5 Notícia5 Notícia5 Notícia5 Notícia5 Notícia5 Notícia5 Notícia5 Notícia5 Notícia5 Notícia5 Notícia5 Notícia5 Notícia5 Notícia5.", "14/05/2018"))
        noticiasList.add(Noticia(6, "Notícia6", "Notícia6 Notícia6Notícia6Notícia6Notícia6Notícia6Notícia6Notícia6Notícia6Notícia6Notícia6 Notícia6 Notícia6 Notícia6 Notícia6 Notícia6 Notícia6 Notícia6 Notícia6 Notícia6 Notícia6 Notícia6.", "14/05/2018"))
        noticiasList.add(Noticia(7, "Notícia7", "Notícia7 Notícia7 Notícia7 Notícia7 Notícia7 Notícia7 Notícia7 Notícia7 Notícia7 Notícia7 Notícia7 Notícia7 Notícia7 Notícia7 Notícia7 Notícia7 Notícia7 Notícia7.", "14/05/2018"))
        noticiasList.add(Noticia(8, "Notícia8", "Notícia8 Notícia8 Notícia8 Notícia8 Notícia8 Notícia8 Notícia8 Notícia8 Notícia8 Notícia8 Notícia8 Notícia8 Notícia8 Notícia8 Notícia8 Notícia8 Notícia8 Notícia8 Notícia8 Notícia8 Notícia8 Notícia8 Notícia8.", "14/05/2018"))


        val adpt = NoticiaAdapter(this)
        lista = findViewById(R.id.recyclerView)
        lista.itemAnimator = DefaultItemAnimator()
        lista.layoutManager = LinearLayoutManager(this)
        lista.adapter = adpt

    }

    inner class NoticiaAdapter(private val context: Context) : RecyclerView.Adapter<NoticiaViewHolder>() {
//        private var referenciaFirebase: DatabaseReference? = null
//        private var noticias: MutableList<Noticia>? = null
//        private var todasNoticias: Noticia? = null

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoticiaViewHolder {
            val itemView = LayoutInflater.from(context).inflate(R.layout.cell_noticias, parent, false)
            return NoticiaViewHolder(itemView)
        }

        override fun onBindViewHolder(holder: NoticiaViewHolder, position: Int) {

            val item = noticiasList[position]
            holder.txtTitulo.text = item.titulo
            holder.txtConteudo.text = item.conteudo
            holder.txtData.text = item.data

//            noticias = java.util.ArrayList<Noticia>()

//            referenciaFirebase = FirebaseDatabase.getInstance().reference

//            referenciaFirebase!!.child("noticia").orderByChild("id").equalTo(item.titulo).addValueEventListener(object : ValueEventListener {
//                override fun onDataChange(dataSnapshot: DataSnapshot) {
//                    noticias!!.clear()
//
//                    for (postSnapshot in dataSnapshot.children) {
//                        todasNoticias = postSnapshot.getValue<Noticia>(Noticia::class.java)
//
//                        noticias!!.add(todasNoticias!!)
//
//                        val displayMetrics = context.resources.displayMetrics
//
//                        val height = 50
//                        val width = 50
//
////                    Picasso.get().load(todasNoticias!!.getUrlImagem()).resize(width, height).centerCrop().into(holder.fotoProdutoCardapio)
//                    }
//                }
//
//                override fun onCancelled(databaseError: DatabaseError) {
//
//                }
//            })


            // holder.linearLayoutProdutoCardapio.setOnClickListener { }
        }

        override fun getItemCount(): Int {
            return noticiasList.size
        }

    }

    inner class NoticiaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var txtTitulo: TextView
        var txtConteudo: TextView
        var txtData: TextView

        init{
            itemView.setOnClickListener {
                val intent = Intent(this@MainActivity, DetalheNoticiaActivity::class.java)
                startActivity(intent)
            }
            txtTitulo = itemView.findViewById(R.id.txtTitulo)
            txtConteudo = itemView.findViewById(R.id.txtConteudo)
            txtData = itemView.findViewById(R.id.txtData)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id = item.itemId

        if (id == R.id.action_perfil_usuario) {
            abrirTelaPerfil()
        }else if (id == R.id.action_lista_usuario) {
            abrirListaUsuario()
        } else if (id == R.id.action_sair_admin) {
            deslogar()
        }

        return super.onOptionsItemSelected(item)
    }

    private fun abrirTelaPerfil() {
        val intent = Intent(this@MainActivity, PerfilUsuarioActivity::class.java)
        intent.putExtra("email", email)
        startActivity(intent)
    }

    private fun abrirListaUsuario(){
        val intent = Intent(this@MainActivity, ListaUsuariosActivity::class.java)
        startActivity(intent)
    }

    private fun deslogar() {

        mAuth?.signOut()

        val intent = Intent(this@MainActivity, LoginActivity::class.java)
        startActivity(intent)
        finish()

    }
}
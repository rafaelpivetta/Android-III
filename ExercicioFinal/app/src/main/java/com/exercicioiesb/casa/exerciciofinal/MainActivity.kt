package com.exercicioiesb.casa.exerciciofinal

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.*
import android.widget.AdapterView
import android.widget.BaseAdapter
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var mAuth: FirebaseAuth? = null

    var noticiasList: MutableList<Noticia> = ArrayList()

    //Recycler
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

        //        lsvNotes.adapter = noticiasAdapter
//        lsvNotes.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, position, id ->
//
//            startActivity(Intent(this@MainActivity, DetalheNoticiaActivity::class.java))
//
//        }

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
            holder.txtConteudo.text = item.conteudo.toString().substring(0, 40)+"..."
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
                println("TEST")
                Toast.makeText(itemView.context, "Direcionar para notícia.", Toast.LENGTH_LONG).show()
            }
            txtTitulo = itemView.findViewById(R.id.txvTitulo)
            txtConteudo = itemView.findViewById(R.id.txvConteudo)
            txtData = itemView.findViewById(R.id.txvData)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id = item.itemId

        if (id == R.id.action_add_usuario) {
            abrirTelaPerfil()
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

    private fun deslogar() {

        mAuth?.signOut()

        val intent = Intent(this@MainActivity, LoginActivity::class.java)
        startActivity(intent)
        finish()

    }

//    inner class NoticiasAdapter : BaseAdapter {
//
//        private var noticiasList = ArrayList<Noticia>()
//        private var context: Context? = null
//
//        constructor(context: Context, noticiasList: ArrayList<Noticia>) : super() {
//            this.noticiasList = noticiasList
//            this.context = context
//        }
//
//        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
//
//            val view: View?
//            val vh: ViewHolder
//
//            if (convertView == null) {
//                view = layoutInflater.inflate(R.layout.cell_noticias, parent, false)
//                vh = ViewHolder(view)
//                view.tag = vh
//            } else {
//                view = convertView
//                vh = view.tag as ViewHolder
//            }
//
//            vh.tvTitulo.text = noticiasList[position].titulo
//            vh.tvConteudo.text = noticiasList[position].conteudo
//            vh.tvData.text = noticiasList[position].data
//
//            return view
//        }
//
//        override fun getItem(position: Int): Any {
//            return noticiasList[position]
//        }
//
//        override fun getItemId(position: Int): Long {
//            return position.toLong()
//        }
//
//        override fun getCount(): Int {
//            return noticiasList.size
//        }
//    }
//
//    private class ViewHolder(view: View?) {
//        val tvTitulo: TextView
//        val tvConteudo: TextView
//        var tvData: TextView
//
//        init {
//            this.tvTitulo = view?.findViewById(R.id.txvTitulo) as TextView
//            this.tvConteudo = view?.findViewById(R.id.txvConteudo) as TextView
//            this.tvData = view?.findViewById(R.id.txvData) as TextView
//        }
//    }
}
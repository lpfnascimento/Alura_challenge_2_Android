package alura.ecommerce.challenge.ui.recyclerview

import alura.ecommerce.challenge.R
import alura.ecommerce.challenge.model.Product
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterRecyclerView(
    private val itens : List<Product>,
    private val context: Context) :
    RecyclerView.Adapter<AdapterRecyclerView.ViewHolder>() {
    //construção da claase viewholder - que retornar a view de viewholder


    //é quem vai pegar e implementar as views
    class ViewHolder(view:View):RecyclerView.ViewHolder(view){
        fun vinculation (item: Product){
            val name = itemView.findViewById<TextView>(R.id.nome_produto)
            name.text = item.name
            val description = itemView.findViewById<TextView>(R.id.descricao_produto)
            description.text = item.description
            val price = itemView.findViewById<TextView>(R.id.valor_produto)
            price.text = item.price.toString()
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       //precisa criar layout inflater com metodos proprios
        val expand_views = LayoutInflater.from(context) //precisa do context
        val view = expand_views.inflate(R.layout.activity_product_unit,parent, false) //passar qual é o laytout que quer utilizar

        return ViewHolder(view)
        //viewhoder já tem acesso a cada uma das views
    }
    //indica qual é o viewholder, qual posição e o que fazer
    override fun onBindViewHolder(holder:ViewHolder, position: Int) {
        val item = itens[position]
        holder.vinculation(item)
    }
    //pega a coleção e indica qual é o tamanho
    override fun getItemCount(): Int = itens.size


}
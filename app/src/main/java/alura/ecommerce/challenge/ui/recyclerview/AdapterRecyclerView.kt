package alura.ecommerce.challenge.ui.recyclerview

import alura.ecommerce.challenge.R
import alura.ecommerce.challenge.databinding.ActivityMainBinding
import alura.ecommerce.challenge.databinding.ActivityProductUnitBinding
import alura.ecommerce.challenge.extensions.tentaCarregarImagem
import alura.ecommerce.challenge.model.Product
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.NumberFormat
import java.util.*

class AdapterRecyclerView(
    private val itens : List<Product>,
    private val context: Context) :
    RecyclerView.Adapter<AdapterRecyclerView.ViewHolder>() {
    //construção da claase viewholder - que retornar a view de viewholder

    //é quem vai pegar e implementar as views
    class ViewHolder(private val binding: ActivityProductUnitBinding):RecyclerView.ViewHolder(binding.root){
        fun vinculation (item: Product)
        {
            val name =  binding.nomeProduto
            name.text = item.name
            val description = binding.descricaoProduto
            description.text = item.description
            val price = binding.valorProduto
            price.text = item.price.toString()

            price.text = currencyFormatBrazil(product = item,price)

            val visibility = if(item.image != null){
                View.VISIBLE
            } else {
                View.GONE
            }

            binding.imageView.visibility = visibility

            binding.imageView.tentaCarregarImagem(item.image)
        }

        private fun currencyFormatBrazil(
            product: Product,
            price: TextView
        ): String{
            val currencyFormat: NumberFormat = NumberFormat.getCurrencyInstance(Locale("pt", "br"))
            return currencyFormat.format(product.price)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       //precisa criar layout inflater com metodos proprios
        val expand_views = LayoutInflater.from(context) //precisa do context
        val binding = ActivityProductUnitBinding.inflate(expand_views,parent, false) //passar qual é o laytout que quer utilizar

        return ViewHolder(binding)
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
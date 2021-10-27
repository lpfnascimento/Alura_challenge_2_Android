package alura.ecommerce.challenge.ui.activity

import alura.ecommerce.challenge.R
import alura.ecommerce.challenge.dao.DaoProduct
import alura.ecommerce.challenge.databinding.ActivityMainBinding
import alura.ecommerce.challenge.model.Product
import alura.ecommerce.challenge.ui.recyclerview.AdapterRecyclerView
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.math.BigDecimal

class MainActivity : AppCompatActivity(R.layout.activity_main)
{
       private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        fabButtonConfigure()
    }

    override fun onResume() {

        super.onResume()
        val daoList = DaoProduct()
        val adapter = AdapterRecyclerView(itens = daoList.searchAll(), context = this)
        val recyclerView = binding.recyclerviewListaProdutos
        recyclerView.adapter = adapter
    }

    private fun fabButtonConfigure()
    {
        val fab = binding.fabProductList
        fab.setOnClickListener {
            val intent = Intent(this, FormProductActivity::class.java)
            startActivity(intent)
        }
    }
}//end_main_activity



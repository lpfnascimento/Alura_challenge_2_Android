package alura.ecommerce.challenge.ui.activity

import alura.ecommerce.challenge.R
import alura.ecommerce.challenge.dao.DaoProduct
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
    override fun onCreate(savedInstanceState: Bundle?)  {
        super.onCreate(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        val daoList = DaoProduct()
        val adapter = AdapterRecyclerView(itens = daoList.searchAll(), context = this)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview_lista_produtos)
        recyclerView.adapter = adapter

        val fab = findViewById<FloatingActionButton>(R.id.fab_product_list)
        fab.setOnClickListener {
            val intent = Intent(this, FormProductActivity::class.java)
            startActivity(intent)
        }
        Log.i("atualiza", "oncrete: $daoList")
    }
}



package alura.ecommerce.challenge.ui.activity

import alura.ecommerce.challenge.R
import alura.ecommerce.challenge.dao.DaoProduct
import alura.ecommerce.challenge.databinding.ActivityFormProductBinding
import alura.ecommerce.challenge.extensions.tentaCarregarImagem
import alura.ecommerce.challenge.model.Product
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import java.math.BigDecimal

class FormProductActivity : AppCompatActivity(R.layout.activity_form_product) {
    private val binding by lazy {
        ActivityFormProductBinding.inflate(layoutInflater)
    }
    private var url: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        title = "Cadastrar Produtos"
        saveButtonConfiguration()
        binding.activityFormularioProdutoImagem.setOnClickListener {
            FormularioImagemDialog(this)
                .showImage(url) { image ->
                    url = image
                    binding.activityFormularioProdutoImagem.tentaCarregarImagem(url)
                }
        }
    }

    private fun saveButtonConfiguration() {
        val saveButton = binding.buttonSaveForm
        val dao = DaoProduct()
        saveButton.setOnClickListener {
            val productNew = productCreation()
            dao.addProduct(productNew)
            Log.i("FormProductActivity", "onCreate: ${dao.searchAll()}")
            Log.i("FormProductActivity", "onCreate: $productNew")
            finish()
        }
    }

    private fun productCreation(): Product {
        // val nameField =
        val name = binding.nameForm.text.toString()
        //val descriptionField =
        val description = binding.descriptionForm.text.toString()
        //val priceField=
        val priceText = binding.priceForm.text.toString()
        val price = if (priceText.isBlank()) {
            BigDecimal.ZERO
        } else {
            BigDecimal(priceText)
        }
        return Product(
            name = name,
            description = description,
            price = price,
            image = url
        )
    }
}


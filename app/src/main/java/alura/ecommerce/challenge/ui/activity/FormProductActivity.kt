package alura.ecommerce.challenge.ui.activity

import alura.ecommerce.challenge.R
import alura.ecommerce.challenge.dao.DaoProduct
import alura.ecommerce.challenge.model.Product
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.math.BigDecimal

class FormProductActivity : AppCompatActivity(R.layout.activity_form_product) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val saveButton = findViewById<Button>(R.id.button_form)
        saveButton.setOnClickListener {
            val nameField = findViewById<TextView>(R.id.name_form)
            val name = nameField.text.toString()
            val descriptionField = findViewById<TextView>(R.id.description_form)
            val description = descriptionField.text.toString()
            val priceField = findViewById<TextView>(R.id.price_form)
            val priceText = priceField.text.toString()
            val price = if(priceText.isBlank()){
                BigDecimal.ZERO
            }else{
                BigDecimal(priceText)
            }
            val productNew = Product(
                name = name,
                description = description,
                price = price
            )
            Log.i("FormProductActivity", "onCreate: $productNew")
            val dao = DaoProduct()
            dao.addProduct(productNew)
            Log.i("FormProductActivity", "onCreate: ${dao.searchAll()}")
            finish()
        }
    }
}



package alura.ecommerce.challenge.dao

import alura.ecommerce.challenge.model.Product
import java.math.BigDecimal

class DaoProduct { //classe para armazenar e adicionar produtos
    //precisa ter métodos para adicionar e consultar os produtos

    fun addProduct(product: Product) {
        Companion.itensProduct.add(product)
    }

    fun searchAll(): List<Product> {
        return Companion.itensProduct.toList()
    }

    companion object {
        private val itensProduct = mutableListOf<Product>(
            Product(
                "Lindt",
                "Chocolate ao Leite",
                BigDecimal("19.99")
            )
        )
    }
}
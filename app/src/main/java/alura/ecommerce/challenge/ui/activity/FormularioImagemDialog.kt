package alura.ecommerce.challenge.ui.activity

import alura.ecommerce.challenge.databinding.ActivityImageFormBinding
import alura.ecommerce.challenge.extensions.tentaCarregarImagem
import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog

class FormularioImagemDialog(private val context: Context)
{
    fun showImage(
        urlPadrao: String? = null,
        quandoImagemCarragada: (imagem: String) -> Unit
    )
    {
        ActivityImageFormBinding
            .inflate(LayoutInflater.from(context)).apply {

                urlPadrao?.let {
                    imageLayoutUrl.tentaCarregarImagem(it)//tenta carregar é uma funcao de imageviewextenions
                    formImagemUrl.setText(it)
                }

                activityButtomReflesh.setOnClickListener {
                    val url = formImagemUrl.text.toString()
                    imageLayoutUrl.tentaCarregarImagem(url)
                }

                AlertDialog.Builder(context)
                    .setView(root)
                    .setPositiveButton("Confirmar") { _, _ ->
                        val url = formImagemUrl.text.toString()
                        quandoImagemCarragada(url)
                    }
                    .setNegativeButton("Cancelar") { _, _ ->

                    }
                    .show()
            }
    }

}

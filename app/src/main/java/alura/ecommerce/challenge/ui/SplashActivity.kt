package alura.ecommerce.challenge.ui

import alura.ecommerce.challenge.R
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class SplashActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    Handler().postDelayed(
    {
        startActivity(Intent(this,MainActivity::class.java))
        finish()
    }, 2000)
}

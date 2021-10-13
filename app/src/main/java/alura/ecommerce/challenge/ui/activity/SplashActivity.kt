package alura.ecommerce.challenge.ui.activity

import alura.ecommerce.challenge.R
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity


class SplashActivity : AppCompatActivity(R.layout.activity_splash)
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        startMainActivity()
    }

    private fun startMainActivity() {
        Handler(Looper.getMainLooper()).postDelayed(
            {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }, 2000
        )
    }
}

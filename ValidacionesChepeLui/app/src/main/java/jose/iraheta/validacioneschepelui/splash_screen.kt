package jose.iraheta.validacioneschepelui

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class splash_screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //creamos una corrutina

        //tiene que ser el hilo main por que ese si muestra cosas en pantalla

        GlobalScope.launch(Dispatchers.Main) {
            //Espera 3 segundos
            delay(3000)

            val pantallaInicio = Intent(this@splash_screen , MainActivity::class.java)
            startActivity(pantallaInicio)

            // Finalizar
            finish()
        }


    }
}
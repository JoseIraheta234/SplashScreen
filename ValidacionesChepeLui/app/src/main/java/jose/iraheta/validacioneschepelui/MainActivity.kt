package jose.iraheta.validacioneschepelui

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 1- Mandar a llamar a todos los elementos de las vistas

        val txtnombre = findViewById<EditText>(R.id.txtNombre)
        val txtCorreo = findViewById<EditText>(R.id.txtCorreo)
        val txtClave = findViewById<EditText>(R.id.txtClave)
        val txtEdad = findViewById<EditText>(R.id.txtEdad)
        val txtDUI = findViewById<EditText>(R.id.txtDUI)
        val btnAgregar = findViewById<Button>(R.id.btnAgregar)

        // 2- Programamos que los campos no esten vacios
        btnAgregar.setOnClickListener {

            //validamos que los campos no esten vacios

            if(txtnombre.text.isEmpty()|| txtCorreo.text.isEmpty()
                || txtClave.text.isEmpty() || txtEdad.text.isEmpty()
                || txtDUI.text.isEmpty()
            ){

                Toast.makeText(this, "Campos vacios", Toast.LENGTH_SHORT).show()
            }
            else{
                if(!txtEdad.text.matches("[0-9]+".toRegex())){
                    Toast.makeText(this,"ingrese numeros", Toast.LENGTH_SHORT).show()
                }else{
                    if (!txtCorreo.text.matches("[a-zA-Z0-9.-_]+@[a-z]+\\.+[a-z]".toRegex())){
                        Toast.makeText(this,"Ingrese correo valido", Toast.LENGTH_SHORT).show()
                    }else{
                        //validar que la contraseña tengaminimo 6 caracteres
                        if(txtClave.text.length < 6){
                            Toast.makeText(this, "La clave debe contener mas de 6 digitos", Toast.LENGTH_SHORT).show()
                        }else{
                            if(txtDUI.text.length == 10 || !txtDUI.text.matches("[0-9]+[-]+[0-9]".toRegex())){
                                Toast.makeText(this,"Ingrese DUI valido", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                }
            }

        }
    }
}
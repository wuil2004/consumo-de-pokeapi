package com.tesji.pokedex;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.tesji.pokedex.Modelo.ModeloRetorno;
import com.tesji.pokedex.Modelo.Pokedex;
import com.tesji.pokedex.R;

public class MainActivity extends AppCompatActivity {
    public Button btn_login;
    public TextInputEditText txtConsulta;
    public String respuesta = "", imagen = "";
    public ModeloRetorno pokedex = new ModeloRetorno();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_login = findViewById(R.id.btnconsultar);
        txtConsulta = findViewById(R.id.txt_titulo);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                consultaApi rg= new consultaApi();
                try {
                    rg.respuesta(txtConsulta.getText().toString());
                    muestraToast("procesando....");
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            pokedex = rg.modeloRetorno;
                            respuesta = "ID: " + pokedex.getId() + "\n" +
                                    "NOMBRE: " + pokedex.getName() + "\n"+
                                    "Altura: " + pokedex.getHeight() + "\n"+
                                    "Peso: " + pokedex.getWeight();
                            imagen = pokedex.getFront_default();
                            if (!respuesta.equals("")){
                                Intent intent = new Intent(MainActivity.this,Consulta_Activity.class);

                                intent.putExtra("informacion", respuesta);
                                intent.putExtra("imagen", imagen);
                                startActivity(intent);
                            }

                        }
                    }, 5000);
                }catch (Exception ex){
                    muestraToast("Error: " + ex);
                }
            }
        });

    }

    private void muestraToast(String mensaje) {
        Toast.makeText(this, " " + mensaje, Toast.LENGTH_SHORT).show();
    }
}
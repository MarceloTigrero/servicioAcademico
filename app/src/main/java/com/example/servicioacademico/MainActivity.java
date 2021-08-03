package com.example.servicioacademico;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText matricula,nombre,apellido,facultad,correo;
    Button inreso;

    static String Marcelo = "192.168.100.68";
    static String Marco = "192.168.100.4";
    static String Diego = "192.168.100.193";
    static String Alex = "x.x.x.x";
    RequestQueue requestQueue;




    private static final String URL1 = "http://" + Diego + "/Trash/registro.php";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        matricula =(EditText) findViewById(R.id.matriculatext);
        nombre =(EditText) findViewById(R.id.nombretext);
        apellido =(EditText) findViewById(R.id.apellidotext);
        facultad =(EditText) findViewById(R.id.facultadtext);
        correo =(EditText) findViewById(R.id.correotext);
        inreso = (Button) findViewById(R.id.btnIngreso);

        inreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String matri = matricula.getText().toString().trim();
                String nom = nombre.getText().toString().trim();
                String apell = apellido.getText().toString().trim();
                String facul = facultad.getText().toString().trim();
                String corr = correo.getText().toString().trim();
                createUsuario(matri,nom,apell,facul,corr);

            }
        });
    }

    private void createUsuario(final String matricula, final String nombre, final String apellido, final String facultad, final String correo) {

        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                URL1,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(MainActivity.this, "Registrado", Toast.LENGTH_SHORT).show();

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "No Registrado" + error, Toast.LENGTH_LONG).show();
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("matricula", matricula);
                params.put("Nombre", nombre);
                params.put("Apellido", apellido);
                params.put("Facultad", facultad);
                params.put("correo", correo);
                return params;

            }
        };
        requestQueue.add(stringRequest);
    }

}
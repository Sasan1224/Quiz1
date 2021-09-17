package com.example.quiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Auto_ev extends AppCompatActivity implements View.OnClickListener {

    private CheckBox s1, s2, s7;
    private Button finBtn;
    int puntos;
    String name, ident;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuesta_sint);

        finBtn = findViewById(R.id.finBtn);
        s1 = findViewById(R.id.s1);
        s2 = findViewById(R.id.s2);
        s7 = findViewById(R.id.s7);





        finBtn.setOnClickListener(this);

        s1.setOnClickListener(this);
        s2.setOnClickListener(this);
        s7.setOnClickListener(this);


        name = getIntent().getExtras().getString("name");
        ident = getIntent().getExtras().getString("ident");
        puntos = getIntent().getExtras().getInt("puntos");

        if (s1.isChecked() == false && s2.isChecked() == false &&  s7.isChecked() == false) {
            finBtn.setVisibility(View.INVISIBLE);
        }


    }

    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.finBtn:

                Intent s = new Intent(this, MainActivity.class);
                savePuntos();
                startActivity(s);
                break;

            case R.id.s1:
                s1.isChecked();

                //los puntos que vale cada opción, si no lo presiona se quitan los puntos
                if(s1.isChecked()){
                    puntos+=1;
                }else{
                    puntos-=1;
                }
                //Se pone a -ninguna de las anteriores- inhabilitada
                s7.setChecked(false);
                break;

            case R.id.s2:
                s2.isChecked();
                if (s2.isChecked()) {
                    puntos += 3; //Es igual a decir pnt = pnt+4
                }else{
                    puntos+=3;
                }
                s7.setChecked(false);
                break;



            //Este es 0 porque es Ninguno de los anteriores
            case R.id.s7:
                s7.isChecked();
                if (s7.isChecked()) {
                    puntos = 0;
                }
                s1.setChecked(false);
                s2.setChecked(false);
                break;

        }

        //Para que aparezca si presionaron una opción
        if (s1.isChecked() || s2.isChecked() ||  s7.isChecked()) {
            finBtn.setVisibility(View.VISIBLE);
        } else {
            finBtn.setVisibility(View.INVISIBLE);
        }

    }

    private void savePuntos(){
        SharedPreferences preferences = getSharedPreferences("locker", MODE_PRIVATE);
        String almacenado = preferences.getString("puntajeNE", ""); //Con esto se guarda lo que ya estaba ahí almacenado
        String nu = "Usuario: " + name + " - id: " + ident +" - puntos: " + puntos + "\n";
        preferences.edit().putString("puntajeNE", nu + almacenado).apply();
    }
}
